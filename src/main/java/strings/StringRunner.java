package strings;

public class StringRunner {

    public static void main(String[] args) {
        String value = "dfgdf  :( fdgfd :( zxczxcz :) dsfgdfg :(";
        String result = replace(value);
//        System.out.println(result);
//        System.out.println(hw1("abc Cpddd Dio OsfWw").equals("ABCPDIOSFW"));
        System.out.println(hw2("8, 1 2 ? 4, 3 ?"));
    }

    public static String replace(String value) {
        return value.replace(":(", ":)");
    }
    // abc Cpddd Dio OsfWw -> ABCPDIOSFW
    public static String hw1(String value) {

        StringBuilder result = new StringBuilder();

        for (char ch : value.toCharArray())
            if (!result.toString().contains(String.valueOf(Character.toUpperCase(ch))) && !(ch == ' ')) {
                result.append(Character.toUpperCase(ch));
            }

        return result.toString();
    }

    //8, 1 2 ? 4, 3 ? -> 18 (8+1+2+4+3)
    public static int hw2(String value) {
        String numLn = "0123456789";
        StringBuilder resBld = new StringBuilder();
        for (char ch : value.toCharArray()) {
            if (numLn.contains(String.valueOf(ch))) {
                resBld.append(ch);
            }
        }

        int i = 0;
        for (char ch : resBld.toString().toCharArray()) {
            i += Integer.parseInt(String.valueOf(ch));
        }

        return i;
    }
}




