package thread;


import java.util.Hashtable;


public class StaticThreadInit {
    static {
        Thread t = new Thread() {
            public void run() {
                System.out.println("进入run方法");
                System.out.println("1------" + website);
                website = "www.leegang.org";
                System.out.println("2------" + website);
                System.out.println("退出run方法");
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static String website = "www.crazyit.org";

    public static void main(String args[]) {
        System.out.println("main：" + StaticThreadInit.website);

        Hashtable a=new Hashtable();
        // Collections.unmodifiableMap(m)
        // Collections.synchronizedList(a);
    }
}