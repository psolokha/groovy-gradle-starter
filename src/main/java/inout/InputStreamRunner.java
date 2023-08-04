package inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("")
                .toFile();
        try (FileInputStream inputStream = new FileInputStream(file)) {
//            System.out.println(new String(inputStream.readAllBytes()));
            byte[] bytes = new byte[inputStream.available()];
            int counter = 0;
            byte currentByte;
            while((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String strValue = new String(bytes);
            System.out.println(strValue);
        }
    }
}
