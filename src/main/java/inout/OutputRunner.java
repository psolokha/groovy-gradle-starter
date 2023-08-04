package inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class OutputRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/someOutData.txt")
                .toFile();

        try (FileOutputStream outStream = new FileOutputStream(file, true)) {
            outStream.write("Hello world from OutputRunner class".getBytes(StandardCharsets.UTF_8));
        }

        File copyOfFile = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/copyOutData.txt").toFile();

        try (FileOutputStream outputStream = new FileOutputStream(copyOfFile)) {
            byte[] inputBytes;
            try (FileInputStream inputStream = new FileInputStream(file)) {

                inputBytes = new byte[inputStream.available()];

                int counter = 0;
                byte currentByte;

                while((currentByte = (byte) inputStream.read()) != -1) {
                    inputBytes[counter++] = currentByte;
                }
            }

            for (int i = inputBytes.length-1; i > 0; i--) {
                if (inputBytes[i] == (byte) ' ') {
                    outputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
                } else outputStream.write(inputBytes[i]);
            }

        }
    }


}
