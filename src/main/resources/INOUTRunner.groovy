import static org.example.Utils.printer
/*

//Запускается из cmd

print "Please, enter your name : "
def name = System.console().readLine()

printer("Hello $name")

 */

/** reading files **/

String path = "files/someData.txt"
File myFile = new File(path)
/*
printer "file content with text - " + myFile.text

def listFromFile = myFile.collect {it}

printer "List from file: $listFromFile"

def lines = myFile.readLines()
printer "lines : $lines"

myFile.eachLine {line, numLine ->
    printer "$numLine : $line"
}

 */

/** write files **/

def outFile = "files/outData.txt"
def readerToFile = "type here any symbols?"
new File(outFile).append(readerToFile)

byte[] content = myFile.bytes
new File("files/byBytesData.txt").append(content)

def dirPath = "C:/projects/groovy-gradle-starter/src/main/resources"
new File(dirPath).eachFile {file -> printer file.getAbsolutePath()}
printer "now Recurse"
new File(dirPath).eachFileRecurse {file -> printer file.getAbsolutePath()}

/** Let's store data in new file **/
def fileListData = "files/listFiles.txt"
def listDataFile = new File(fileListData)
new File(dirPath).eachFileRecurse {it ->
    listDataFile << it
    listDataFile << '\n'}

printer new File(outFile).text

/** to overwrite the file **/
new File(outFile).text = "new text here"

printer new File(outFile).text

