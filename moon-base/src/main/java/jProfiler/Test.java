package jProfiler;

public class Test extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        for(int i=1; i<10000; i++) {
            new HelloWorld();
            t.sleep(100); // ����100����
        }
    }
}

class HelloWorld {
    public HelloWorld() {
        System.out.println("Hello Jayzee!");
    }
}