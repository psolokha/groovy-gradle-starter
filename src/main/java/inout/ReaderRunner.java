package inout;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        File inputFile = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/someData.txt").toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            System.out.println(reader.lines()
                    .collect(Collectors.joining("\n")));
        }
    }
}
