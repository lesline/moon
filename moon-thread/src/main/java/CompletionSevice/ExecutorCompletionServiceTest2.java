package CompletionSevice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




public class ExecutorCompletionServiceTest2 {

	static class Task implements Callable<String> {
		private int i;

		public Task(int i) {
			this.i = i;
		}

		@Override
		public String call() throws Exception {
			Thread.sleep(10000);
			return Thread.currentThread().getName() + "ִ��������" + i;
		}
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		testExecutorCompletionService();
	}

	private static void testExecutorCompletionService()
			throws InterruptedException, ExecutionException {
		int numThread = 5;
		ExecutorService executor = Executors.newFixedThreadPool(numThread);
		  List<Future<String>> futures=new ArrayList(numThread);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(
				executor);
		for (int i = 0; i < numThread; i++) {
			futures.add(completionService.submit(new ExecutorCompletionServiceTest2.Task(i)));
		}
		System.out.println("--------------");
//		for(Future f:futures){
//			System.out.println(f.get());
//		}

		executor.shutdown();
		/*
		 * ������ͨ��Executor�ύһ�鲢��ִ�е����񣬲���ϣ����ÿһ��������ɺ��������õ����
		 */
		for (int i = 0; i < numThread; i++) {
			System.out.println(completionService.take().get());
		}
		
		
		
	}
}