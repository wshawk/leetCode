import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author hawk
 * @package PACKAGE_NAME
 * @desc
 * @date 2022/6/10
 */
public class TestThreadPool {
    private static final Logger log = Logger.getLogger("TestThreadPool");
    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                3,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1024),
                r -> {
                    Thread t = new Thread(r);
                    t.setName("yc"+atomicLong.decrementAndGet());
                    if (t.isDaemon()) {
                        t.setDaemon(false);
                    }
                    if (Thread.NORM_PRIORITY != t.getPriority()) {
                        t.setPriority(Thread.NORM_PRIORITY);
                    }
                    return t;
                });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("---execute--"+Thread.currentThread().getName());
                throw new RuntimeException("execute我报错了");
            }
        });
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("---submit--"+Thread.currentThread().getName());
                throw new RuntimeException("submit我报错了");
            }
        });
    }
}
