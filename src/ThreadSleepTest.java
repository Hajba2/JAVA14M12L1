public class ThreadSleepTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("in main thread");
        Thread mainThread = Thread.currentThread();
        System.out.println("mainThread.getName() = " + mainThread.getName());

        Thread customThread = new Thread(() -> {
            System.out.println("in custom thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        });
        //customThread.setName("firstCustomThread");


        customThread.start();

        System.out.println("before sleep");
        Thread.sleep(2000);
        System.out.println("after sleep");

    }
}
