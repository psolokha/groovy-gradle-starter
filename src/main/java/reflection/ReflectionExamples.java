package reflection;

import reflection.model.Proger;

import java.lang.reflect.*;

public class ReflectionExamples {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Proger proger = new Proger(25L, "Pasha", 33);
        Class<? extends Proger> aClass = proger.getClass();
        Class<Proger> progerClass = Proger.class;
        System.out.println(aClass == progerClass);

        Proger proger1 = testConstructor();
        testFieds(proger1);
        testMethods(proger1);
    }

    private static void testMethods(Proger proger) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methodGetName = proger.getClass().getDeclaredMethod("setName", String.class);
        methodGetName.invoke(proger, "Debil");
        System.out.println(proger);
    }
    private static Proger testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Proger> constructor = Proger.class.getConstructor(Long.class, String.class, Integer.class);
        Proger testProger = constructor.newInstance(7L, "Cyber", 29);
        System.out.println(testProger);
        return testProger;
    }

    private static void testFieds(Proger proger) throws IllegalAccessException {
        Field[] declaredFields = Proger.class.getSuperclass().getDeclaredFields(); // берем поле суперкласса
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object value = field.get(proger);
            System.out.println(field.getModifiers());
            System.out.println(Modifier.isPrivate(field.getModifiers()));
            System.out.println(value);
        }
    }
}
