package book.initial;

/**
 * 双重检查加锁不是线程安全的,加volatile后可以保证线程安全
 */

public class DoubleCheckedLocking {
    private static Resource resource;//线程不安全
    //private volatile static Resource resource;--线程安全的

    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null)
                    resource = new Resource();
            }
        }
        return resource;
    }

    static class Resource {

    }
}