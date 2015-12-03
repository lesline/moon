package thread;

public class JoinTest1 implements Runnable {

    public static int a = 0;

    public static String b = "111";


    public synchronized void inc() {
        a++;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            inc();
        }
    }

    public static void main(String[] args) throws Exception {

        Runnable r = new JoinTest1();
        Thread t1 = new Thread(r);
        t1.start();
        t1.join();


    }
}