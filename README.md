# Jeopardy Solver

The aim of this program is to replicate a part of IBM's Watson where it uses
Information Retrieval strategies to answer Jeopardy questions.

We use a similar strategy of scouring Wikipedia pages and answering queries
based on the top page match.

In order to see the details of the project, the techniques used, and an analysis
of the performance of the best results, see the project file pdf: 
[ShreyasKhandekar-ProjectFile.pdf](ShreyasKhandekar-ProjectFile.pdf)

## How to run

The jar file is included in the target folder and can be run directly from the
command line.

Usage:
```bash
java -jar target/jeopardySolver-1.0-jar-with-dependencies.jar  [-q] [-r] [-t] [-s scoreFormula] [-h]
```

For instructions on what each of the flags mean, run with the `-h` flag.

This jar file also includes the Kotlin runtime, so you do not need Kotlin in
order to be able to run the program.


## How to create new jar

If you want to make changes to the project just to mess around,
you can recompile the jar file using maven
```bash
mvn clean install
```

Maven should handle all the dependencies for you automatically

## Indexing Running time Expectations

On a half decent machine here are some of the running times for indexing the
Wikipedia subset in [wiki-subset](src/main/resources/wiki-subset)

- Standard Analyser with Lemmatization with only the first 15 lines : 2-4 Hours
- Whitespace Analyser with Lemmatization with only the first 20 lines : 2-4 Hours
- Whitespace Analyser with Lemmatization on the whole document : 8-10 Hours
- Whitespace Analyser without Lemmatization on the whole document : 1-5 minutes
- Standard Analyser without Lemmatization on the whole document : 1-5 minutes
- English Analyser without Lemmatization on the whole document : 2-5 minutes


## Documentation

You can find the documentation for the code under [target/dokka](target/dokka)
Or click [here](target/dokka/index.html)

In order to regenerate the docs run:

```bash
mvn pre-site
```

Which will replace the existing docs with the regenerated ones.