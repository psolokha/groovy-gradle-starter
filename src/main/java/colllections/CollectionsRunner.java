package colllections;

import java.util.Iterator;

public class CollectionsRunner {
    public static void main(String[] args) {
        LocalList<String> list = new LocalList<>(3);

        list.add("str1");
        list.add("str2");
        list.add("str3");

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
