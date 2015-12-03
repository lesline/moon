package ExecutorService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MethodTest {

	/**
	 ExecutorService
	 shutDown()    等待线程池中的任务执行完成（包含队列中等待的任务），线程池中不允许新增任务
	 shutdownNow() 试图停止正在执行的任务，队列中等待的任务不处理，线程池中不允许新增任务
	 awaitTermination  当超过timeout时间后，会监测ExecutorService中所有任务是否完成执行
	 isShutdown     表示是是否执行了shutdown方法
	 isTerminated  表示调用 shutdown 或 shutdownNow后任务是否执行完成
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(4);
		service.submit(new Task1());
		service.submit(new Task1());
		service.submit(new LongTask());
		service.submit(new Task1());

		service.shutdown();


		System.out.println("1"+service.isShutdown());
		System.out.println("1"+service.isTerminated());
		while (!service.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("线程池没有关闭");
			System.out.println("||"+service.isShutdown());
			System.out.println("||"+service.isTerminated());
		}
		System.out.println("2"+service.isShutdown());
		System.out.println("2"+service.isTerminated());
		System.out.println("线程池已经关闭");

		//  test2();

	}

	private static void test2() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(new LongTask());
		service.submit(new LongTask());
		service.submit(new LongTask());
		service.submit(new LongTask());
		service.submit(new LongTask());

		List<Runnable> runnables = service.shutdownNow();
		System.out.println(runnables.size());

		while (!service.awaitTermination(1, TimeUnit.MILLISECONDS)) {
			System.out.println("线程池没有关闭");
		}
		System.out.println("线程池已经关闭");
	}




}
