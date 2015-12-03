package Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * �ֿ�
 * 
 * @author JY-IT-D001
 * 
 */
public class Storage {

	private BlockingQueue<Product> queues = null;
	private int initSize = 10;// �ֿ��ʼ��С

	public Storage(int num) {
		init(num);
	}

	public void init() {
		queues = new ArrayBlockingQueue<Product>(initSize);
	}

	public void init(int initSize) {
		queues = new ArrayBlockingQueue<Product>(initSize);
	}

	/**
	 * ����
	 * 
	 * @param p
	 * @throws InterruptedException
	 */
	public void push(Product p) throws InterruptedException {
		queues.put(p);
	}

	/**
	 * ����
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Product pop() throws InterruptedException {
		return queues.take();
	}
}
