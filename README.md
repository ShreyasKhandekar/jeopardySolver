# Jeopardy Solver

The aim of this program is to replicate a part of IBM's Watson where it uses
Information Retrieval strategies to answer Jeopardy questions.

We use a similar strategy of scouring Wikipedia pages and answering queries
based on the top page match.

In order to see the details of the project, the techniques used, and an analysis
of the performance of the best results, see the project file pdf: 
[ShreyasKhandekar-ProjectFile.pdf](ShreyasKhandekar-ProjectFile.pdf)

## How to create the jar

In order to make the `jar` file, you can use maven:

```bash
mvn clean install
```

Maven should handle all the dependencies for you automatically

## How to run

Due to limitations of the free version of git large file storage, I am unable to
provide a pre-compiled `jar` file via GitHub directly.

Therefore, you can use maven to create the `jar` file as described above.

Usage:

```bash
java -jar target/jeopardySolver-1.0-jar-with-dependencies.jar  [-q] [-r] [-t] [-s scoreFormula] [-h]
```

For instructions on what each of the flags mean, run with the `-h` flag.

This jar file also includes the Kotlin runtime, so you do not need Kotlin in
order to be able to run the program.

## Indexing Running time Expectations

On a half decent machine here are some of the running times for indexing the
Wikipedia subset in [wiki-subset](src/main/resources/wiki-subset)

- Standard Analyser with Lemmatization with only the first 15 lines : 2-4 Hours
- Whitespace Analyser with Lemmatization with only the first 20 lines : 2-4 Hours
- Whitespace Analyser with Lemmatization on the whole document : 8-10 Hours
- Whitespace Analyser without Lemmatization on the whole document : 1-5 minutes
- Standard Analyser without Lemmatization on the whole document : 1-5 minutes
- English Analyser without Lemmatization on the whole document : 2-5 minutes

## Getting the index

Due to git lfs limitations, I cannot reliably provide access to the index that
has already been generated using git.
Even though I have made my best efforts to optimize my code it might still be
hard to index if you do not have a decent machine.

Therefore, you can access my best performing pre-generated index via box.

Side Note: You can see how this index was created in the 
[program file](ShreyasKhandekar-ProjectFile.pdf)

You can download the index from box 
[here](https://arizona.box.com/v/ShreyasKhandekarJeopardySolver)
or copy and paste the following link 
https://arizona.box.com/v/ShreyasKhandekarJeopardySolver 

You must save it under `src/main/resources/` and call the folder `index`

### Troubleshooting

If you are on a Unix based system then unfortunately the uploaded index might
give you some grief. In case this happens you will have to re-index.

Delete the existing index using 

```bash
rm -rf src/main/resources/index
```

And then reindex and test using

```bash
java -jar target/jeopardySolver-1.0-jar-with-dependencies.jar -r -t
```

## Documentation

You can find the documentation for the code under [target/dokka](target/dokka)
Or click [here](https://rawgit.com/ShreyasKhandekar/jeopardySolver/main/target/dokka/index.html)

In order to regenerate the docs run:

```bash
mvn dokka:dokka
```

Which will replace the existing docs with the regenerated ones.
