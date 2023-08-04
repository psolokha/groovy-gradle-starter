package serialize;

import functional.helper.Student;

import java.io.*;
import java.nio.file.Path;

public class SerializeRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Path outPath = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/outStudent.txt");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outPath.toFile()))) {
            Student student = new Student(25, "Vasya");
            objectOutputStream.writeObject(student);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(outPath.toFile()))) {
            Object object = objectInputStream.readObject();
            System.out.println(object);
        }
    }
}
