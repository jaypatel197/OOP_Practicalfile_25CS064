import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {}

class MyTests {
    @Run
    public void test1() { System.out.println("Running test1"); }

    public void notATest() { System.out.println("Skipped"); }

    @Run
    public void test2() { System.out.println("Running test2"); }
}

public class MiniTestRunner {
    public static void main(String[] args) throws Exception {
        MyTests obj = new MyTests();
        Method[] methods = obj.getClass().getDeclaredMethods();

        int count = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(Run.class)) {
                m.invoke(obj);
                count++;
            }
        }

        System.out.println("Total tests ran: " + count);
    }
}