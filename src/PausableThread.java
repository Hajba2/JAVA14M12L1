public class PausableThread extends Thread {

    private volatile boolean isAlive = true;
    private volatile boolean needToRun = false;

    @Override
    public void run() {
        System.out.println("Before while in custom thread");
        while (isAlive) {
            if (needToRun) {
                System.out.println("running thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("After while in custom thread");
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isNeedToRun() {
        return needToRun;
    }

    public void setNeedToRun(boolean needToRun) {
        this.needToRun = needToRun;
    }

    public static void main(String[] args) throws InterruptedException {
        PausableThread pausableThread = new PausableThread();
        pausableThread.start();

        Thread.sleep(1000);
        System.out.println("main thread sleep...");
        Thread.sleep(2000);

        System.out.println("pausableThread.setNeedToRun(true)");
        pausableThread.setNeedToRun(true);

        System.out.println("main thread sleep...");
        Thread.sleep(2000);

        System.out.println("pausableThread.setNeedToRun(false)");
        pausableThread.setNeedToRun(false);

        System.out.println("main thread sleep...");
        Thread.sleep(2000);

        System.out.println("pausableThread.setNeedToRun(true)");
        pausableThread.setNeedToRun(true);

        System.out.println("main thread sleep...");
        Thread.sleep(2000);

        System.out.println("turn off pausable thread");
        pausableThread.setAlive(false);

    }
}
