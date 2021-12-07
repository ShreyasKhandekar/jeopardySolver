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
            buildFullIndex()
            //buildSampleIndex()
        }
    }
    // Index should be ready for use now.
    val index = FSDirectory.open(Paths.get(standardLemmaIndexFile))
    // See if we want to run tests
    if(args.contains("-t") || args.contains("--test")){
        // Run queries
        var correctCount = 0
        var totalCount = 0
        val reader = File(questionsPath).bufferedReader()
        var topic = reader.readLine()
        while(topic != null) {
            totalCount++
            val question = reader.readLine()
            val answer = reader.readLine()
            val answers = answer.split("|")
            if(jeopardyQuery(index,topic,question,answers,true))
                correctCount++

            topic = reader.readLine()
            while(topic == "") {
                topic = reader.readLine()
            }
        }

        print("Total: $totalCount\nCorrect: $correctCount\nAccuracy:")
        println(correctCount/totalCount.toDouble()*100)

        reader.close()
    } else if(args.contains("-p")){
        // Run Accuracy Benchmarks

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
    println("-t | --test\t\t\t\t\tRun Tests. Cannot be used with -q or -p")
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
