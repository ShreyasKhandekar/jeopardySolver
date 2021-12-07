# Results

Results from running the queries on different indices

## Accuracy Benchmarks

### BM25

#### Plain Score only on content
- Standard Analyser with Lemmatization with only the first 15 lines : 20%
- Whitespace Analyser with Lemmatization with only the first 20 lines : 22%
- Whitespace Analyser without Lemmatization on the whole document : 11%
- Standard Analyser without Lemmatization on the whole document : 29%
- English Analyser without Lemmatization on the whole document : 29%

#### Adding content and sections score
- Standard Analyser with Lemmatization with only the first 15 lines : 20%
- Whitespace Analyser with Lemmatization with only the first 20 lines : 3%
- Whitespace Analyser without Lemmatization on the whole document : 22%
- Standard Analyser without Lemmatization on the whole document : 29%
- English Analyser without Lemmatization on the whole document : 16%
