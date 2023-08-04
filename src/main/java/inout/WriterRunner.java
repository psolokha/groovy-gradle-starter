package inout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterRunner {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/projects/groovy-gradle-starter/src/main/resources/files/writerOut.txt"))) {
            writer.write("Для начала запишем первую строку\n");
            writer.append("Hello world!\n");
            writer.append("Теперь можно использовать сепаратор");
            writer.newLine();
            writer.append("уот так уот");
        }

    }
}
