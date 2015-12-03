package thread;

public class ThreadLocal2Test {
	// ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public static void main(String[] args) {
		ThreadLocal2Test sn = new ThreadLocal2Test();
		// ③ 3个线程共享sn，各自产生序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}

	private static class TestClient extends Thread {
		private ThreadLocal2Test sn;

		public TestClient(ThreadLocal2Test sn) {

			this.sn = sn;
		}
		public void run() {
			System.out.println("thread[" + Thread.currentThread().getName()+ "] --> sn[" + sn.seqNum.get() + "]");
			sn.seqNum.set(3);
			System.out.println("thread[" + Thread.currentThread().getName()+ "] --> sn[" + sn.seqNum.get() + "]");

		}
	}
}