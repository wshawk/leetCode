package thread;

import java.lang.ref.WeakReference;

/**
 * @author hawk
 * @package thread
 * @desc
 * @date 2022/5/30
 */

public class TestEntry {
    static class StrongEntry {
        /** The value associated with this ThreadLocal. */
        Object value;
        ThreadLocal<?> key;
        StrongEntry(ThreadLocal<?> k, Object v) {
            key = k;
            value = v;
        }
    }
    static class WeakEntry extends WeakReference<ThreadLocal<?>> {
        /** The value associated with this ThreadLocal. */
        Object value;
        WeakEntry(ThreadLocal<?> k, Object v) {
             super(k);
            value = v;
        }
    }
    public static void main(String[] args) {
        ThreadLocal<String> threadLocalStrong = new ThreadLocal<>();
        StrongEntry e1 = new StrongEntry(threadLocalStrong, "xxx");
        threadLocalStrong = null;
        System.out.println("StrongEntry k:" + e1.key);
        System.out.println("StrongEntry v:" + e1.value);
        System.gc();
        System.out.println("StrongEntry k:" + e1.key);
        System.out.println("StrongEntry v:" + e1.value);


        ThreadLocal<String> threadLocalWeak = new ThreadLocal<>();
        WeakEntry e2 = new WeakEntry(threadLocalWeak, "xxx");
        threadLocalWeak = null;
        System.out.println("WeakEntry k:" + e2.get());
        System.out.println("WeakEntry v:" + e2.value);
        System.gc();
        System.out.println("WeakEntry k:" + e2.get());
        System.out.println("WeakEntry v:" + e2.value);
    }
}
