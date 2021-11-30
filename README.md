# Jeopardy Solver

This project is in progress.

The aim of this program is to replicate a part of IBM's Watson where it uses
Information Retrieval strategies to answer Jeopardy questions.

We use a similar strategy of scouring Wikipedia pages and answering queries
based on the top page match.

## How we handle Wikipedia pages

Each wikipedia page consists of various kinds of texts that must be processed
differently.
At the outset, each wikipedia page contains at least one of the following:

- A Title
- Section Titles
  - These titles are treated as our top valued tier while searching
  - Section titles are delimited by two equals signs (`==`) on each side
- Contents
  - The contents of the page are treated as the second tier while searching
- Links and Redirects:
   - [tpl] ... [/tpl] - These seem to be for any text that is a hyperlink
     - Most of the tpl links are citations to web pages, journals, and books, and
  thus contribute useful information to the content of the page. This is why I
  chose to include the content between these [/tpl] tags while stripping out
  tags themselves.
   - \#REDIRECT
     - These links simply redirect the Wikipedia page to another wikipedia page.
     - Since this means that the page contains no relevant information, it is
     useless to search. 
     - ***Therefore, we do not index pages which are redirects.***
- Special characters
  - There are some characters like `&` which just don't play nice with lucene.
  - In order to deal with them we just escape them using a backslash(`\ `)

## Stemming and Lemmatization

All pages and contents are stemmed and lemmatized using the Stanford CoreNLP
Library

TODO: Replace Standard Analyser in parseWikipedia.kt with whitespace analyser.

Reason: After using coreNLP for lemmatization and pos and  ssplit we cannot use the stasndard analyser from lucene otherwise it will stem the words using its default porter stemmer. So we use whitespace analyser to not use stemmer. FIX QUICK.

## How the tiered index works

### Option1: 
Search section titles first, if you get a score above a certain threshold then
return that document as the answer. If not then go ahead and search the content
of the page.
### Option 2: 
You can search both simultaneously and combine the two scores for a total score
for the document.