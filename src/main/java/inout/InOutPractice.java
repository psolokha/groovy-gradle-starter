package inout;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class InOutPractice {
    public static void main(String[] args) throws IOException {
/*
        // #1 Вывести все слова из файла начинающиеся с гласной
        Path path = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/scanner.txt");
        Scanner scanner = new Scanner(path);

        while (scanner.hasNext()) {
            String word = scanner.next();
            if ("eyuioa".indexOf(word.charAt(0)) != -1) {
                System.out.println(word);
            }
        }

        // #2 Вывести все слова, для которых последняя буква одного слова совпадает с первой следующего
        Scanner scanner1 = new Scanner(path);
        String word1 = scanner1.next();

        while (scanner1.hasNext()) {
            String word2 = scanner1.next();
            if (word1.charAt(word1.length() - 1) == word2.charAt(0)) {
                System.out.println(word1 + " - " + word2);
            }
            word1 = word2;
        }

        // #3 В каждой строке найти нибольшее число цифр идущих подряд


        List<String> outList = new ArrayList<>();

        Scanner scanner2 = new Scanner(pathNums);

        while (scanner2.hasNext()) {
            Map<Integer, String> mapTmp = new HashMap<>();

            StringBuilder rslt = new StringBuilder();
            String tmpLine = scanner2.next();

            int[] numArr = new int[tmpLine.length()];

            for (int i = 0; i < tmpLine.length(); i++) {
                numArr[i] = Integer.parseInt(String.valueOf(tmpLine.toCharArray()[i]));
            }

            int counter = 0;
            for (int i = 1; i < numArr.length; i++) {

                if (numArr[i - 1] == (numArr[i] - 1)) {
                    if (rslt.isEmpty()) {
                        rslt.append(numArr[i - 1]);
                    }
                    rslt.append(numArr[i]);
                    counter++;
                } else if (counter > 0 && !(rslt.isEmpty())) {
                    mapTmp.put(counter, rslt.toString());
                    counter = 0;
                    rslt = new StringBuilder();
                }
            }

            if (counter > 0 && !(rslt.isEmpty())) {
                mapTmp.put(counter, rslt.toString());
            }

            if (!mapTmp.isEmpty()) {
                outList.add(mapTmp.get(mapTmp.keySet().stream()
                        .max(Integer::compareTo)
                        .orElseGet(null)));
            }
        }

        outList.forEach(System.out::println);
*/
        // #4  Прочитать текст java-файла, заменить в нем все public на private и сохранить в другом месте
//C:\projects\groovy-gradle-starter\src\main\java\generics\cars\Car.java
        Path path1 = Path.of("/projects/groovy-gradle-starter/src/main/java/generics/cars/Car.java");
        System.out.println(path1.getParent());
        String stringValue = Files.readString(path1);

        String resultString = stringValue.replace("public", "private");

        Path resultPath = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/Car2.java");
        Files.writeString(resultPath, resultString);

//        BufferedReader reader = new BufferedReader(new FileReader("/projects/groovy-gradle-starter/src/main/java/generics/cars/Car.java"));
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/projects/groovy-gradle-starter/src/main/resources/files/Car.java"))) {
//            reader.lines().forEach(line -> {
//                if (line.contains("public")) {
//                    try {
//                        writer.write(line.replace("public", "private"));
//                        writer.newLine();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    try {
//                        writer.write(line);
//                        writer.newLine();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//        } catch (IOException exception) {
//            exception.getStackTrace();
//        }

        // #5  Прочитать текст java-файла, переписать исмволы в каждой строке в обратном порядке
        Path path2 = Path.of("/projects/groovy-gradle-starter/src/main/java/generics/cars/Lada.java");
        Path resultPath2 = Path.of("/projects/groovy-gradle-starter/src/main/resources/files/Lada2.java");

        try (Stream<String> lines = Files.lines(path2);
        BufferedWriter resultStream2 = Files.newBufferedWriter(resultPath2, APPEND, CREATE)) {
            lines.map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            resultStream2.write(line.toString());
                            resultStream2.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        BufferedReader reader1 = new BufferedReader(new FileReader("/projects/groovy-gradle-starter/src/main/java/generics/cars/Car.java"));
//        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("/projects/groovy-gradle-starter/src/main/resources/files/Car1.java"))) {
//            reader1.lines().forEach(line -> {
//                char[] charArr = line.toCharArray();
//
//                StringBuilder newLine = new StringBuilder();
//                for (int i = charArr.length-1; i >=0; i--) {
//                    newLine.append(charArr[i]);
//                }
//                try {
//                    writer1.append(newLine.toString());
//                    writer1.newLine();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
    }
}
