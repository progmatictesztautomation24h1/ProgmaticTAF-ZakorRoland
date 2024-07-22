import org.testng.annotations.*;

public class TestNgDemo {

//    public static void main(String[] args) {
//        init();
//        test();
//        test2();
//        tearDown();
//    }


    @BeforeTest
    public static void init(){
        System.out.println("Before test. Driver stuff.");
    }

    @BeforeClass
    public static void beforeTestClass(){
        System.out.println("Executed before any test touched in the class");
    }

    @BeforeMethod
    public static void beforeTestCase(){
        System.out.println("Executed before test case execution.");
    }

    @Test    //teszt metódus
    public static void test(){
        int[] array = new int[2];
        System.out.println(array[5]);
        System.out.println("Test execution.");
    }

    @Test //teszt metódus
    public static void test2(){
        System.out.println("Test2 execution");
    }

    @AfterMethod
    public static void afterTestCase(){
        System.out.println("Excuted after test case execution.");
    }

    @AfterClass
    public static void afterTestClass(){
        System.out.println("Executed after all test executed in the class");
    }

    @AfterTest
    public static void tearDown(){
        System.out.println("Test finished. Cleanup.");
    }
}
