package org.example

import groovy.io.FileType

class IORunner {
    static void main(String[] args) {
        //get file
        def file = new File(".gitignore")

        //read all text in file
        println file.text

        //read each line in file
        file.each { println it}

        //create and write new file
        def file2 = new File("groovyIOTesting.txt")
        file2.text = "Let's write a line\n"
        file2 << "New line\n" << "Another line\n" << "And others...\n"

        //writer from reader of file2 object
        def writer = new StringWriter()
        try (def reader = file2.newReader()){
            writer << reader
        }
        println writer

        //Walk printing all dirs
        def srcDir = new File("src")
        //single
        srcDir.eachDir { println it}
        // recurse
        srcDir.eachDirRecurse { println it}
        // all Files and Dirs
        srcDir.eachFileRecurse() { println it}
        //files only
        srcDir.eachFileRecurse(FileType.FILES) { println it}
    }
}
