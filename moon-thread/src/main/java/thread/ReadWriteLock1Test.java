package thread;

import java.util.Random;
import java.util.concurrent.locks.*;

public class ReadWriteLock1Test {
	public static void main(String[] args) {
		final Date001 myData = new Date001(); // 这是各线程的共享数据
		for (int i = 0; i < 1; i++) { // 开启3个读线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						myData.get();
					}
				}
			}).start();
		}


		for (int i = 0; i < 1; i++) { // 开启3个写线程
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						myData.put(new Random().nextInt(10000));
					}
				}
			}).start();
		}
	}
}

class Date001 {
	private Object data = null;
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public void get() {
		rwl.readLock().lock(); // 读锁开启，读线程均可进入
		try { // 用try finally来防止因异常而造成的死锁
			System.out.println(Thread.currentThread().getName()+ "is ready to read");
			Thread.sleep(new Random().nextInt(100));
			System.out.println(Thread.currentThread().getName()+ "have read date" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock(); // 读锁解锁
		}
	}

	public void put(Object data) {
		rwl.writeLock().lock(); // 写锁开启，这时只有一个写线程进入
		try {
			System.out.println("----------"+Thread.currentThread().getName()+ "is ready to write");
			Thread.sleep(5000);
			this.data = data;
			System.out.println("----------"+Thread.currentThread().getName()+ "have write date" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock(); // 写锁解锁
		}
	}
}