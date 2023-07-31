package customTr;

public class CustomThreadTest {

    public static void main(String[] args) {
        CustomThread ct1 = new CustomThread();
        CustomThread ct2 = new CustomThread();
        CustomThread ct3 = new CustomThread();
        CustomThread ct4 = new CustomThread();

        ct1.start();
        ct2.start();
        ct3.start();
        ct4.start();
    }
}
