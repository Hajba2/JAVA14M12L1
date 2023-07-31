import java.util.ArrayList;
import java.util.List;

public class SynkThreadObjTest {

    volatile int counter = 0;

    public static void main(String[] args) {
        SynkThreadObjTest synkThreadObjTest = new SynkThreadObjTest();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    //increment();
                    synchronized (synkThreadObjTest) {
                        synkThreadObjTest.counter = synkThreadObjTest.counter + 1;
                    }
                }
            });
            threads.add(thread);
        }


        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(counter);
    }
}
