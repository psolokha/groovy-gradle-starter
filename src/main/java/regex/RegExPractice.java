package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPractice {
    public static void main(String[] args) {
        String stringWithPhoneNumbers = "fdslfk kldsmfklds +375 (44) 321-76-44 lsdfmkl +375 (29) 301-44-98 dflkslmdfslkdmf +375 (25) 111-22-99 fdgdfgergs";
        String regex = "\\+375\\s\\((29|33|44|25)\\)\\s(?<first>\\d{3})\\-(?<second>\\d{2})\\-(?<third>\\d{2})";

        Matcher matcher = Pattern.compile(regex).matcher(stringWithPhoneNumbers);
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            String firstGroup = matcher.group("first");
            String secondGroup = matcher.group("second");
            String thirdGroup = matcher.group("third");
            matcher.appendReplacement(builder, firstGroup + " - " + secondGroup + " - " + thirdGroup);
        }
        matcher.appendTail(builder);

        builder.append(System.lineSeparator());

        // Groups:                              $1                  $2         $3      $4
        String regexNoGroups = "\\+375\\s\\((29|33|44|25)\\)\\s(\\d{3})\\-(\\d{2})\\-(\\d{2})";
        Matcher matcherNoGroups = Pattern.compile(regexNoGroups).matcher(stringWithPhoneNumbers);

        while (matcherNoGroups.find()) {
            matcherNoGroups.appendReplacement(builder, "$1 - $2 - $3 - $4");
        }
        matcherNoGroups.appendTail(builder);
        
        System.out.println(builder);
        System.out.println(stringWithPhoneNumbers.replaceAll(regexNoGroups, "$2 $3 $4")); // the same
    }
}
