package Consumer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java���߳�ģ������������������
 * <p/>
 * ProducerConsumer������ Producer������ Consumer������ Product��Ʒ Storage�ֿ�
 *
 * @author JY-IT-D001
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();

        try {
            Storage storage = new Storage(10);

            ExecutorService service = Executors.newFixedThreadPool(10, new HandlerThreadFactory());
            CompletionService<String> completionService = new ExecutorCompletionService<String>(service);
            int producerNum = 5;
            int consumerNum = 5;
            int level;// ����������ˮƽ
            AtomicBoolean isSuccess = new AtomicBoolean(true);
            CyclicBarrier barrier = new CyclicBarrier(producerNum);
            for (int i = 0; i < producerNum; i++) {
                level = i;
                Producer producer = new Producer("��" + i, level, storage, isSuccess, barrier);
                completionService.submit(producer);
            }
            System.out.println("----------------------------------------------------------------");

            for (int i = 0; i < consumerNum; i++) {
                Consumer consumer = new Consumer("��" + i, storage);
                completionService.submit(consumer);
            }


            System.out.println("===================================================================");
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(completionService.take().get());
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            service.shutdown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}