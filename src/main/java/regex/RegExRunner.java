package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tel number:
 * +375 (xx) yyy-yy-yy
 * xx - code.of (29, 33, 44, 25)
 * yyy-yy-yy - numbers 0-9
 *    +  3  7  5     (  2  9  )     1  2  3  -  4  5  -  6  7
 * ^\\W\\d\\d\\d\\s\\W\\d\\d\\W\\s\\d\\d\\d\\W\\d\\d\\W\\d\\d$
 * ^\\W\\d{3}\\s\\W\\d{2}\\W\\s\\d{3}\\W\\d{2}\\W\\d{2}$
 * ^\+375\\s\((29|33|44|25)\)\\s\\d{3}\-\\d{2}\-\\d{2}$
 * --------------------------
 * 'abc' matches() - жесткое совпадение
 *              "abc"   +
 *              "uabc"  -
 *              "abcu"  -
 * 'abc' find() - мягкий поиск
 *              "abc"   +
 *              "uabc"  +
 *              "abuc"  -
 */
public class RegExRunner {
    public static void main(String[] args) {
        String phoneNumber = "+375 (44) 321-76-98";
        String regex = "^\\+375\\s\\((29|33|44|25)\\)\\s\\d{3}\\-\\d{2}\\-\\d{2}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        System.out.println(matcher.matches());
        System.out.println(Pattern.matches(regex, phoneNumber)); // the same
        System.out.println(phoneNumber.matches(regex)); // the same


        String newRegex = "\\+375\\s\\((?<code>29|33|44|25)\\)\\s\\d{3}\\-\\d{2}\\-\\1";
        String stringWithPhoneNumbers = "fdslfk kldsmfklds +375 (44) 321-76-44 lsdfmkl +375 (29) 301-44-98 dflkslmdfslkdmf +375 (25) 111-22-99";

        Pattern compiledPattern = Pattern.compile(newRegex);
        Matcher matcherForString = compiledPattern.matcher(stringWithPhoneNumbers);

        while (matcherForString.find()) {
            System.out.println(matcherForString.group("code"));
        }

    }
}
