"""Check local Markdown links, PDF transcription coverage and worked examples.

Run from any folder: python tools/check_course.py
Requires a JDK on PATH; uses a temporary directory for test outputs.
"""
from pathlib import Path
from urllib.parse import unquote
import json,re,subprocess,tempfile

ROOT=Path(__file__).resolve().parents[1]

def check_docs():
    files=list(ROOT.rglob('*.md'))
    for f in files:
        text=f.read_text(encoding='utf-8')
        assert len(re.findall(r'^```',text,re.M))%2==0, f'Unclosed fence: {f}'
        for target in re.findall(r'\]\(([^)]+)\)',text):
            target=unquote(target.split('#')[0].strip('<>'))
            if not target or re.match(r'https?:|mailto:',target):continue
            assert (f.parent/target).exists(),f'Broken link: {f}: {target}'
    records=json.loads((ROOT/'00-Course-Info/sources/manifest.json').read_text())
    for record in records:
        page_numbers=[]
        for p in record['outputs']:
            text=(ROOT/p).read_text(encoding='utf-8')
            page_numbers.extend(map(int,re.findall(r'^## PDF page (\d+)$',text,re.M)))
        assert sorted(page_numbers)==list(range(1,record['pages']+1)),record['source']
    for unit in ROOT.glob('[0-9][0-9]-*'):
        assert (unit/'README.md').exists() and (unit/'PRACTICE.md').exists(),unit
    print(f'PASS: links and fences in {len(files)} Markdown files; all pages of {len(records)} source PDFs represented.')

def check_examples():
    receipt=ROOT/'12-Abstraction-and-Interfaces/examples/ReceiptDemo.java'
    report=ROOT/'13-Collections-Framework-and-File-IO/examples/AttendanceReport.java'
    def run(*args):
        return subprocess.run(['java',*map(str,args)],capture_output=True,text=True)
    r=run(receipt)
    assert r.returncode==0 and r.stdout.splitlines()==['Cash: KES 500','Card: KES 800'],r.stderr
    with tempfile.TemporaryDirectory(prefix='java-course-check-') as d:
        d=Path(d); src=d/'input.txt';out=d/'report.txt'
        src.write_text('Amina\nBrian\nAmina\n\n',encoding='utf-8')
        r=run(report,src,out)
        assert r.returncode==0,r.stderr
        assert out.read_text().splitlines()==['Amina: 2','Brian: 1']
        before=out.read_bytes();r=run(report,src,out)
        assert r.returncode!=0 and out.read_bytes()==before,'Existing report overwritten'
        r=run(report,d/'missing.txt',d/'missing-output.txt')
        assert r.returncode!=0 and not (d/'missing-output.txt').exists()
        src.write_text('',encoding='utf-8');r=run(report,src,d/'empty.txt')
        assert r.returncode==0 and (d/'empty.txt').read_bytes()==b''
    print('PASS: ReceiptDemo output; AttendanceReport normal, empty, missing-input and existing-output cases.')

if __name__=='__main__':
    check_docs();check_examples()
