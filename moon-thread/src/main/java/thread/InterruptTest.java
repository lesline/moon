package thread;

import java.util.concurrent.Semaphore;

public class InterruptTest implements Runnable {

	public static int a = 0;

	/** 信号量 */
	private Semaphore semaphore = new Semaphore(0); // 1
	public static String b = "111";

	public synchronized void inc() {
		a++;
	}

	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			System.out.println("-------------");
		}

		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		Runnable r = new InterruptTest();
		Thread t1 = new Thread(r);
		t1.start();

		System.out.println("------1------" + t1.isInterrupted());
		t1.interrupt();

		for (int i = 0; i < 1000; i++) {

			System.out.println("------2------" + t1.isInterrupted());
			Thread.sleep(10000);
		}

	}
}