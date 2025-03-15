import java.lang.ref.WeakReference;

/**
 * @author hawk
 * @package PACKAGE_NAME
 * @desc
 * @date 2021/11/11
 */
public class Test {
    public static void main(String[] args) {
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println("before gc: " + weakReference.get());
        System.gc();
        System.out.println("after gc: " + weakReference.get());


        Object obj = new Object();
        WeakReference<Object> weakReference2 = new WeakReference<>(obj);
        System.out.println("before gc: " + weakReference2.get());
        System.gc();
        System.out.println("after gc: " + weakReference2.get());
    }
}

