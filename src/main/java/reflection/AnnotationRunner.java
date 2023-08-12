package reflection;

import reflection.model.Proger;

import java.util.Arrays;

public class AnnotationRunner {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Proger> progerClass = Proger.class;
        System.out.println(Arrays.toString(
                progerClass.getDeclaredField("age").getAnnotations()));
    }
}
