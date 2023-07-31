package customTr;

public class CustomThread extends Thread {

    int i = 0;

    @Override
    public void run() {
        System.out.println("in new thread class");
        i++;
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }

}
