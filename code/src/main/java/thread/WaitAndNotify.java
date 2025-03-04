package thread;

/**
 * @author hawk
 * @package thread
 * @desc
 * @date 2021/9/23
 */
public class WaitAndNotify {
    private static final Object LOCK = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Thread A " + i);
                        LOCK.notify();
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // LOCK.notify();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("Thread B " + i);
                        LOCK.notify();
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // LOCK.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
