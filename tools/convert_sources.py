"""Convert archived course PDFs to searchable Markdown. Originals stay outside Git.

Usage: python tools/convert_sources.py ARCHIVE_DIRECTORY
Text extraction preserves page boundaries; diagrams remain in archived originals.
"""
from pathlib import Path
import hashlib
import json
import re
import sys
from pypdf import PdfReader

ROOT = Path(__file__).resolve().parents[1]

def slug(text):
    return re.sub(r'[^a-z0-9]+', '-', text.lower()).strip('-')

def page_markdown(text):
    # Preserve layout-sensitive code/table extraction honestly in a collapsible block.
    # Prose remains searchable; curated unit READMEs supply verified Java examples.
    text = text.replace('\x00', '').replace('\r', '')
    text = re.sub(r'(?m)^\s*Page \d+ of \d+\s*$', '', text)
    text = text.replace('```', '` ` `')
    return '<details>\n<summary>Page text</summary>\n\n```text\n' + text.strip() + '\n```\n\n</details>\n'

def convert(archive):
    records = []
    manifest = ROOT/'00-Course-Info'/'sources'/'manifest.json'
    previous = {r['source']:r for r in json.loads(manifest.read_text(encoding='utf-8'))} if manifest.exists() else {}
    for source in sorted(archive.rglob('*.pdf')):
        relative = source.relative_to(archive)
        if len(relative.parts) < 3:
            continue
        checksum = hashlib.sha256(source.read_bytes()).hexdigest()
        prior = previous.get(relative.as_posix())
        if prior and prior['sha256'] == checksum and all((ROOT/p).exists() for p in prior['outputs']):
            records.append(prior)
            continue
        reader = PdfReader(source)
        is_book = source.name.startswith('Java eBook')
        if is_book:
            dest = ROOT / '00-Course-Info' / 'sources' / 'textbook'
            chapters = []
            for item in reader.outline:
                if isinstance(item, dict) and str(item.get('/Title', '')).startswith('Chapter '):
                    chapters.append((reader.get_destination_page_number(item), str(item['/Title'])))
            chapters.sort()
            boundaries = [(0, 'Front matter')] + chapters
            # The print edition ends its chapters at page 1262 (PDF page 1285).
            boundaries.append((1285, 'Appendices and index'))
            groups = [(start, boundaries[i+1][0] if i+1<len(boundaries) else len(reader.pages), title)
                      for i,(start,title) in enumerate(boundaries)]
        else:
            dest = ROOT / relative.parts[0] / 'sources' / relative.parts[1]
            groups = [(0, len(reader.pages), source.stem)]
        dest.mkdir(parents=True, exist_ok=True)
        outputs = []
        for start,end,title in groups:
            out = dest / (slug(title) + '.md')
            body = [f'# {title}\n', '[Source index](README.md) · [Unit lesson](../../README.md)\n', f'> Source: {source.name}\n',
                    '> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.\n']
            for i in range(start,end):
                body += [f'\n## PDF page {i+1}\n', page_markdown(reader.pages[i].extract_text() or '[No extractable text on this page.]')]
            out.write_text('\n'.join(body), encoding='utf-8')
            outputs.append(out.relative_to(ROOT).as_posix())
        records.append({'source':relative.as_posix(), 'sha256':hashlib.sha256(source.read_bytes()).hexdigest(),
                        'pages':len(reader.pages), 'outputs':outputs})
        print(f'Converted {relative}: {len(reader.pages)} pages', flush=True)
    (ROOT/'00-Course-Info'/'sources'/'manifest.json').write_text(json.dumps(records,indent=2),encoding='utf-8')

if __name__ == '__main__':
    convert(Path(sys.argv[1]).resolve())
