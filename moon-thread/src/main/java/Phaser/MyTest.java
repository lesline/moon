package Phaser;

import java.util.concurrent.Phaser;

public class MyTest {  

    public static void main(String[] args) {  
        Phaser phaser = new Phaser(3) {//����3�������̣߳�����ڹ��캯���и�ֵΪ3  
            @Override  
            protected boolean onAdvance(int phase, int registeredParties) {  
                System.out.println("\n=========�����ķָ���=============");  
                //�����У���ֻʣһ���߳�ʱ������̱߳ض������̣߳�����true��ʾ�ս�  
                return registeredParties == 1;   
            }             
        };  
        System.out.println("����ʼִ��");  
        for(int i=0; i<3; i++) { //����������3���߳�  
            new MyThread01((char)(97+i), phaser).start();  
        }  
          
        phaser.register(); //�����̶߳�̬���ӵ�phaser�У��˾�ִ�к�phaser������4���߳�  
        while(!phaser.isTerminated()) {//ֻҪphaser���սᣬ���߳̾�ѭ���ȴ�  
            int n = phaser.arriveAndAwaitAdvance();  
        }  
        //��������ѭ������ζ��phaser�սᣬ��3�������߳��Ѿ�����  
        System.out.println("�������");  
    }  
}  

class MyThread01 extends Thread {  
    private char c;  
    private Phaser phaser;  
      
    public MyThread01(char c, Phaser phaser) {  
        this.c = c;  
        this.phaser = phaser;  
    }  

    @Override  
    public void run() {  
        while(!phaser.isTerminated()) {  
            for(int i=0; i<10; i++) { //����ǰ��ĸ��ӡ10��  
                System.out.print(c + " ");  
            }  
            //��ӡ�굱ǰ��ĸ�󣬽������Ϊ����������ĸ������b����Ϊe��������һ�׶δ�ӡ  
            c = (char) (c+3);   
            if(c>'z') {   
                //�����������ĸz������phaser�ж�̬����һ���̣߳����˳�ѭ���������߳�  
                //��3�������̶߳�ִ�д�����phaser�о�ֻʣһ�����߳���  
                phaser.arriveAndDeregister();  
                break;  
            }else {  
                //��֮���ȴ������̵߳���׶��յ㣬��һ�������һ���׶�  
                phaser.arriveAndAwaitAdvance();  
            }  
        }  
    }  
}  