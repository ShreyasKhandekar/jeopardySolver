# Results

Results from running the queries on different indices

## Accuracy Benchmarks

### BM25

#### Plain Score only on content
- Standard Analyser with Lemmatization with only the first 15 lines : 20%
- Whitespace Analyser with Lemmatization with only the first 20 lines : 22%
- Whitespace Analyser with Lemmatization on the whole document : 25%
- Whitespace Analyser without Lemmatization on the whole document : 11%
- Standard Analyser without Lemmatization on the whole document : 29%
- English Analyser without Lemmatization on the whole document : 29%

#### Adding content and sections score
- Standard Analyser with Lemmatization with only the first 15 lines : 17%
- Whitespace Analyser with Lemmatization with only the first 20 lines : 20%
- Whitespace Analyser with Lemmatization on the whole document : 20%
- Whitespace Analyser without Lemmatization on the whole document : 9%
- Standard Analyser without Lemmatization on the whole document : 22%
- English Analyser without Lemmatization on the whole document : 22%

#### If Content Score above certain threshold then return top answer
else add section score 
threshold for each type of index is in brackets

- Standard Analyser with Lemmatization with only the first 15 lines(20) : 16%
- Whitespace Analyser with Lemmatization with only the first 20 lines(17) : 21% 
- Whitespace Analyser with Lemmatization on the whole document(10) : 24%
- Whitespace Analyser without Lemmatization on the whole document(5) : 11%
- Standard Analyser without Lemmatization on the whole document(15) : 28%
- English Analyser without Lemmatization on the whole document(15): 28%

From here on I will just test the English Analyzer without lemmatization on the
whole document because it performs the best across all the techniques for scoring.
