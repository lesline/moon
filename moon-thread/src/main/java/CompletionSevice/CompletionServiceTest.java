package CompletionSevice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletionServiceTest {

    static class Task implements Callable<String> {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            //Thread.sleep(5000);
            System.out.println(i);
            for (int i = 1; i < 1000000; i++) {
                String a = new String("aaa");
            }
            System.out.println("--");
            return Thread.currentThread().getName() + "执行完任务：" + i;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        testUseFuture();
    }

    private static void testUseFuture() {
        int numThread = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numThread - 3);
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        for (int i = 0; i < numThread; i++) {
            Future<String> future = executor
                    .submit(new CompletionServiceTest.Task(i));
            futureList.add(future);
        }

        System.out.println("-------------------");
        for (Future f : futureList) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

/*		while (numThread > 0) {
            for (Future<String> future : futureList) {
				String result = null;
				try {
					result = future.get(0, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					System.out.println("--------------");
				}
				if (null != result) {
					futureList.remove(future);
					numThread--;
					System.out.println(result);
					// 此处必须break，否则会抛出并发修改异常。（也可以通过将futureList声明为CopyOnWriteArrayList类型解决）
					break;
				}
			}
		}*/

        executor.shutdown();
        //executor.awaitTermination(3, TimeUnit.SECONDS);

        //executor.submit(new CompletionServiceTest.Task(15));
        System.out.println("==========================");

        /**
         * shutDown()    等待线程池中的任务执行完成（包含队列中等待的任务），线程池中不允许新增任务
         * shutdownNow() 试图停止正在执行的任务，队列中等待的任务不处理，线程池中不允许新增任务
         *
         *
         * shutDown()
         * 线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。
         * 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态。此时，则不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常
         *
         * shutdownNow()
         * 根据JDK文档描述，大致意思是：执行该方法，线程池的状态立刻变成STOP状态，并试图停止所有正在执行的线程，不再处理还在池队列中等待的任务
         * ，当然，它会返回那些未执行的任务。
         * 它试图终止线程的方法是通过调用Thread.interrupt()方法来实现的，但是大家知道，这种方法的作用有限，如果线程中没有sleep、wait、Condition、定时锁等应用,
         * interrupt()方法是无法中断当前的线程的。所以，ShutdownNow()并不代表线程池就一定立即就能退出，它可能必须要等待所有正在执行的任务都执行完成了才能退出。

         */
    }
}
