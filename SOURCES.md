# Sources and original archive

[Course home](README.md) · [Book chapters](00-Course-Info/sources/textbook/README.md) · [Conversion manifest](00-Course-Info/sources/manifest.json)

## Study sources

- Riara University RBCS 7121: weekly notes, practical sessions, summaries and course outline.
- Oracle Academy Java Foundations: lesson slides and supplied exercise files.
- Y. Daniel Liang, *Introduction to Java Programming, Comprehensive Version*, 10th edition: the supplied course eBook.

Unit READMEs combine existing explanations with original study additions, textbook connections, comparisons, checkpoints and practice prompts. Week 9 and Week 10 now have complete edited lessons and runnable examples. Source transcriptions preserve original wording for reference.

## Original archive

PDFs, original `NOTES.md` files, the root README and progress file were copied and verified before migration:

```text
C:\Users\ianmu\Desktop\java-originals-2026-11-18
```

The archive preserves previous relative paths. Keep it for original diagrams, slide layouts, exact printed code and recovery of the previous notes. It is outside the repository and is not included in a Git clone.

## Conversion limits

Markdown transcriptions preserve PDF page boundaries and searchable text inside expandable blocks. Complex tables, diagrams, mathematical symbols and some code indentation require the archived original. Edited lessons supply formatted Java, comparison tables and selected Mermaid diagrams.

The book is split using chapter bookmarks, with separate front matter and appendices/index files. The supplied PDF contains the 33 print chapters. References to bonus web chapters remain in its contents, but those chapters are not present in the supplied file.

Each manifest entry records the original path, SHA-256 checksum, page count and generated Markdown paths. The converter is `tools/convert_sources.py` and requires `pypdf`.

Removing PDFs from the working tree reduces the size of the current course files. PDFs already stored in Git history remain there; this migration does not rewrite history.
