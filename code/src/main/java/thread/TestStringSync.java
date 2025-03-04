package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author hawk
 * @package thread
 * @desc
 * @date 2022/6/1
 */
public class TestStringSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread a = new Thread(() ->testStringSync("456"));
        Thread b = new Thread(() ->testStringSync("456"));
        Thread c = new Thread(() ->testStringSync("456"));
        Thread d = new Thread(() ->testStringSync("456"));

        a.start();
        b.start();
        c.start();
        d.start();

        Thread.sleep(3000);
    }

    private static void testStringSync(String shopId){
        System.out.println(Thread.currentThread().getName() +" shopId: " + shopId + "进入方法");
        synchronized (shopId.intern()){
            System.out.println(Thread.currentThread().getName() + ":  success");
        }
    }
}
