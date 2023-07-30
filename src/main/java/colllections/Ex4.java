package colllections;

import java.util.*;

/**
 * Сложить два многочлена заданной степени, если коэффициенты многочлена хранятся в объекте HashMap в виде:
 * Ключ: номер степени
 * Значение: мультипликатор (множитель)
 * Вывести результирующий многочлен в виде строки: ax^6 + bx^4 + cx^3 + dx + 8
 */
public class Ex4 {

    public static void main(String[] args) {

        Map<Integer, Integer> r1 = Map.of(6,2, 5,5, 4,1, 2,7,1,3,0,9);
        Map<Integer, Integer> r2 = Map.of(5,1, 4,-1, 3,3,0,4, 2, -12);

//        System.out.println(sumMaps(r1, r2));
        System.out.println(sumMapsOth(r1, r2));

    }

    private static String sumMapsOth(Map<Integer, Integer> r1, Map<Integer, Integer> r2) {
        Map<Integer, Integer> tmpMap = new HashMap<>(r1);

        for (Map.Entry<Integer, Integer> entry : r2.entrySet()) {
            tmpMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        Map<Integer, Integer> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        sortedMap.putAll(tmpMap);
        List<String> stringList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (!(entry.getValue() == 0)) {
                stringList.add(entry.getKey() == 0 ? entry.getValue() + "" :
                        (entry.getKey() == 1 ? entry.getValue()+"x" : entry.getValue()+"x^"+entry.getKey()));
            }
        }
        return String.join(" + ", stringList).replace("+ -", "- ");
    }

    private static String sumMaps(Map<Integer, Integer> r1, Map<Integer, Integer> r2) {
        class InnerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? 1 : ((o1.equals(o2)) ? 0 : -1);
            }
        }
        Map<Integer, Integer> resultMap = new TreeMap<>(new InnerComparator());

        Set<Integer> powSet = new HashSet<>();
        powSet.addAll(r1.keySet());
        powSet.addAll(r2.keySet());

        System.out.println(powSet);

        powSet.forEach( i -> {
            resultMap.put(i, r1.getOrDefault(i, 0) + r2.getOrDefault(i, 0));
//            if (!r1.containsKey(i)) {
//                resultMap.put(i, r2.get(i));
//            } else if (!r2.containsKey(i)) {
//                resultMap.put(i, r1.get(i));
//            }else {
//                resultMap.put(i, r1.get(i) + r2.get(i));
//            }
        });

        System.out.println(resultMap);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : resultMap.entrySet()) {
            if (integerIntegerEntry.getValue() < 0) {
                sb.deleteCharAt(sb.lastIndexOf("+"));
            }

            if (integerIntegerEntry.getKey() == 0) {
                sb.append(integerIntegerEntry.getValue());
            } else if (integerIntegerEntry.getKey() == 1) {
                sb.append(integerIntegerEntry.getValue()).append("x").append('+');
            }  else if (integerIntegerEntry.getValue() == 0) {
                sb.append("x^").append(integerIntegerEntry.getKey()).append('+');
            } else {
                sb.append(integerIntegerEntry.getValue()).append("x^").append(integerIntegerEntry.getKey()).append('+');
            }
        }

        return sb.toString();
    }

}
