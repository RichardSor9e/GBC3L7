package Tests;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;

public class TestExecutor {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {


OrdinaryClass ordinaryClass = new OrdinaryClass();

Class<?> newOne = Class.forName("Tests.OrdinaryClass");
        start(newOne);
    }



@Test
    public static void start(Class <?> classForTests) throws InvocationTargetException, IllegalAccessException {

    Method[] methods = classForTests.getDeclaredMethods();

    ArrayList<Method> arrayList = new ArrayList<>();

    for (Method method : methods) {
        if (method.isAnnotationPresent(Test.class)) {
            method.setAccessible(true);
            arrayList.add(method);

        }
    }
    Comparator<Method> comparator = Comparator.comparing(Method -> Method.getAnnotation(Test.class).priority());

    arrayList.sort(comparator);


    for (Method method : methods) {
        if (method.isAnnotationPresent(BeforeSuite.class)){
            arrayList.add(method);
            break;
        }
    }
    for (Method method : methods) {
        if (method.isAnnotationPresent(AfterSuite.class)){
            arrayList.add(method);
            break;
        }
    }




    for (int i = 0; i < arrayList.size(); i++) {
        arrayList.get(i).setAccessible(true);
    }

    arrayList.get(arrayList.size()-2).invoke(OrdinaryClass.class);

    for (int i = 0; i < arrayList.size()-2; i++) {
        arrayList.get(i).invoke(OrdinaryClass.class);
    }
    arrayList.get(arrayList.size()-1).invoke(OrdinaryClass.class);




}
}
