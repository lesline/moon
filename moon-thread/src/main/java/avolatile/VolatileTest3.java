package avolatile;
class VolatileSample2 {  
    int x = 0;  
    volatile boolean v = false;  
    String result;  

    public void writer() {  
        x = 42;  
        v = true;  
    }  

    public void reader() {  
    	
        /* 
         * ����� result="x="+x+",v="+v;�����ͻ���� x=0,v=true �����Ľ������Ϊ�� 
         * ���� ����ȫ�����ȷ���x�������߳���ִ��writer��������writer����ִ����ɺ� 
         * ���ٽ��ŷ���v����ʱ�ͻ���� x=0,v=true �Ľ���� 
         *  
         * �������result="v="+v+",x="+x;����Ҫ����� v=true,x=0 �Ľ������һ��Ҫ�� 
         * writer����ִ���겢д�ص����ڴ����ִ��reader����������v��������volatile�� 
         * ����volatile�������ֹreorder����������volatile����������ͬʱ�ϸ����� 
         * reorder volatile������Χ �ķ� volatile��������������x ��vǰ��ֵ����д���� 
         * ��ʱҲ��һ�����մ�˳�����Ե�vΪtrueʱ���������е�x�϶���42����������0�� 
         * ���ﲻҪע����ǣ�volatile�ı���Ҳ���ڶ�ȡ���ڴ�ʱ�ϸ��ճ����˳��ִ�У� 
         * ����������������ȷ���x��v�Ŀ��ܣ��������������Ҳ�����v=true,x=0�Ľ������ 
         *  
         * ����ֻ��x������volatile����Ҳ��һ���ġ���Ȼ���������������volatileʱ�� 
         * �����ȫ����Ϊ�������ȫ����ֹ�����ţ���һ���Ļ�ֻ�ǡ��ϸ����ơ����ѣ����ܻ��� 
         * ����ܰ�ȫ������һ�� ����������Ϊ�ȫ�� 
         *  
         * ��x,v����volatileʱ�� result="x="+x+",v="+v;ִ�еĽ�������п���Ϊ 
         * x=0,v=true�� ��Ϊvolatileֻ�Ǳ�֤�˿ɼ�����˳���������ص�Ϊ���������ܱ�֤ 
         * ԭ���ԡ����������Ҫ�õ� x=0,v=true��ֻ��reader������ִ�У��ȷ���x����v 
         * ��δ����ʱ����ʼ����writer������ ��writer��������ִ����󲢽�x,vд�����ڴ� 
         * ����ִ��reader��������������v����ʱ�Ľ� ������x=0,v=true�� ���⣬ 
         * result="x="+x+",v="+v;Ҳ���ϸ��ճ����˳����ִ�з��ʲ�������volatile�� 
         * ֻ����д���ڴ�ʱ�ǰ����������ִ��˳����ִ�У��ڶ���ʱ��Ҳ������ Ҫ���ճ��� 
         * �ķ���˳���������������volatile����ʱ����read�����Ϳ��ܲ��ᰴ�ճ���˳���� 
         * ִ�У��������Դ���ķ��ʲ���û��ʲôӰ�죬���ֻ�з��ʲ����Ĳ������һ�� 
         * ����������̲߳���ȫ�����⣩�����ȷ���x�����ܷ���v�����������ԭ���Եģ��� 
         * �п��ܴ������� �� �л��������̡߳� 

         * ���⣬�ڲ��ԵĹ����з���writer������ԭ����Ҫ��reader��ԭ����Ҫǿ��������� 
         * �ʲ����� һ��������ֵ���ԭ����ǿ 
         */  
        result = "x=" + x + ",v=" + v;  
        //result = "v=" + v + ",x=" + x;  
    }  

}  

public class VolatileTest3 {  
    public static void main(String[] args) {  
    	/**
(1) �����渴�Ʊ�������ǰ�����ڴ� (read and load)
 (2) ִ�д��룬�ı乲�����ֵ (use and assign)
 (3) �ù����ڴ�����ˢ������������� (store and write) 
    	 */
        while (!Thread.currentThread().isInterrupted()) {  
            final VolatileSample2 s = new VolatileSample2();  
            final Thread w = new Thread(){  
                public void run() {  
                    s.writer();  
                }  
            };  
              
            final Thread r = new Thread(){  
                public void run() {  
                    s.reader();  
                }  
            };  
            r.start();  
            w.start();  
            new Thread(){  
                public void run() {  
                    try {  
                        w.join();  
                        r.join();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    System.out.println(this.getName() + " " + s.result);  
                    if (s.result.equals("x=0,v=true")) {  
                        System.out.println(this.getName() + "------------------------------ " + s.result);  
                        System.exit(0);  
                    }  
                }  
            }.start();  

            Thread.yield();  
        }  
    }  
}  

