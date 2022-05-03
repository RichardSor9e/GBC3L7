package Tests;

public class OrdinaryClass {

    @Test
    public static void test1(){
        System.out.println("test 1");
    }
    @Test(priority = 5)
    public static void test2(){
        System.out.println("test 2");
    }
    @Test(priority = 4)
    private static void test3(){
        System.out.println("test 3");
    }
    @Test(priority = 3)
    public static void test4(){
        System.out.println("test 4");
    }
@BeforeSuite
    public static void test5(){
        System.out.println("test 5");
    }
    @AfterSuite
    public static void test6(){
        System.out.println("test 6");
    }
    @Test
    public static void test7(){
        System.out.println("test 7");
    }


}
