package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test3 {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
         
        for(int i=0;i<N;i++) {
            if(i<N-1)
                new Writer(barrier).start();
            else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }
        }
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
 
        @Override
        public void run() {
            System.out.println("�߳�"+Thread.currentThread().getName()+"����д������...");
            try {
                Thread.sleep(5000);      //��˯����ģ��д�����ݲ���
                System.out.println("�߳�"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
                try {
                    cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    // TODO Auto-generated catch block
                   System.out.println("1----------"+Thread.currentThread().getName());
                   e.printStackTrace();
                   System.out.println("1----------"+Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
            	 System.out.println("2----------"+Thread.currentThread().getName());
                 e.printStackTrace();
                 System.out.println("2----------"+Thread.currentThread().getName());
            }catch(BrokenBarrierException e){
            	 System.out.println("3----------"+Thread.currentThread().getName());
                 e.printStackTrace();
                 System.out.println("3----------"+Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName()+"�����߳�д����ϣ�����������������...");
        }
    }
}