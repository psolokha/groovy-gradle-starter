package regex;

import java.util.regex.Pattern;

public class RegExTasks {
    public static void main(String[] args) {
        String correctEmail = "firstMail@yahoo.com";
        String incorrectEmail = "1mymail@yandex.ru";
        System.out.println(isEmail(correctEmail));
        System.out.println(isEmail(incorrectEmail));

        System.out.println("start<p id=\"p1\">ttttt</p>eeeeeee<p id = \"p2\">rrrrrr</p>uuuu"
                .replaceAll("(<p .+?>)(.+?</p>)", "<p>$2")); // (<p .+>)(.+</p>) - жадный поиск
    }

    private static boolean isEmail(String email) {
        String regex = "^[a-zA-Z]\\w+@\\w+.(org|com)$";
        return Pattern.matches(regex, email);
    }
}
