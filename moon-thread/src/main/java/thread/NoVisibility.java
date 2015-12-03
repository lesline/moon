package thread;

public class NoVisibility {

	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {

				// System.out.println("--");
				Thread.yield();
			}

			System.out.println(number);
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new ReaderThread().start();
		// Thread.currentThread().sleep(1000);
		number = 42;

		// System.out.println("--------------1-------------");

		ready = true;
		// System.out.println("--------------2-------------");
	}

}
