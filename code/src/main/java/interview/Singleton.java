package interview;

/**
 * @author hawk
 * @package interview
 * @desc
 * @date 2025/2/14
 */
public class Singleton {

    private Singleton() {
    }

    private static final class InstanceHolder {
        static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.instance;
    }
}
