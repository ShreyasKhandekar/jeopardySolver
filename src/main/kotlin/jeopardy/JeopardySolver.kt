package jeopardy

import org.apache.lucene.store.FSDirectory
import java.io.File
import java.nio.file.Paths


fun main(args: Array<String>){
    if(args.isEmpty()){
        printUsage()
    } else if(args[0] == "-h" || args[0] == "--help"){
        printUsage()
        printHelp()
    } else {
        if(args.contains("-r") || args.contains("--reindex") ||
            !File(indexFile).exists()) {
            //buildFullIndex()
            buildSampleIndex()
        }
        val engine: QueryEngine = QueryEngine(FSDirectory.open(
            Paths.get(indexFile)))

    }
}

fun buildSampleIndex() {
    buildIndex(listOf(sampleDataPath))
}

fun buildFullIndex() {
    val fileList = mutableListOf<String>()

    File(fullDatasetPath).walk().forEach {
        fileList.add("$it")
    }
    fileList.removeAt(0) // First element is just the directory name
    buildIndex(fileList)
}

fun printHelp() {
    println("-q | --query\t\t\t\tQuery Mode. Cannot be used with -p or -t")
    println("-r | --reindex\t\t\t\tReindex Files.")
    println("-t | --test\t\t\t\t\tRun Sanity Tests. Cannot be used with -q or -p")
    println("-p | --perf\t\t\t\t\tRun Accuracy Benchmarks. Cannot be used with -t or " +
            "-q")
    println("-s scoreFormula |\n--score scoreFormula\t\tSet Score formula to " +
            "one of the following:\n\t\t\t\t\t\t\t\t" +
            "BM25: Uses BM25 scoring\n\t\t\t\t\t\t\t\t" +
            "tfidf: Use the vector space model of tf*idf scoring")
    println("-h | --help\t\t\t\t\tPrint this message. Cannot be used with any other " +
            "option")
}

fun printUsage() {
    println("Usage:\n\t JeopardySolver [-q] [-r]" +
            " [-t] [-p] [-s scoreFormula] [-h]")
}
