package Phaser;

import java.util.concurrent.Phaser;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		
		/**
		 * �����ָ�ϣ������� Task ��ʵ���� phased ���񡣴� phased������3��phases����ʹ��Phaser�ӿ���������Task����ͬ����
		 * ����Щ��������ִ�����ǵ�phasesʱ����������3�����񲢴�ӡ����phaser�����״̬��Ϣ���ٿ�̨��
		 * 
		 * ����ʹ�����µķ�������ȡphaser�����״̬��
		 * getPhase():�˷�������phaser ����� actual phase 
		 * getRegisteredParties():�˷�������ʹ��phaser������Ϊͬ�����Ƶ������� 
		 * getArrivedParties(): �˷��������Ѿ�����actual phaseĩ�˵������� 
		 * getUnarrivedParties(): �˷������ػ�û����actual phaseĩ�˵�������
		 */

		// 9. �����µ���3�������ߵ� Phaser ������Ϊ phaser��

		Phaser phaser = new Phaser(3);

		// 10. ����������3���߳���ִ��3��task����

		for (int i = 0; i < 3; i++) {

			Task task = new Task(i + 1, phaser);

			Thread thread = new Thread(task);

			thread.start();

		}

		// 11.��������10�ε�forѭ������ѧ����phaser�������Ϣ��

		for (int i = 0; i < 10; i++) {

			// 12. д���� registered parties ����Ϣ��phaser��phase�������parties,
			// ��δ�����parties ����Ϣ��

			System.out.printf("********************\n");

			System.out.printf("Main: Phaser Log\n");

			System.out.printf("Main: Phaser: Phase: %d\n", phaser.getPhase());

			System.out.printf("Main: Phaser: Registered Parties:%d\n",
					phaser.getRegisteredParties());

			System.out.printf("Main: Phaser: Arrived Parties:%d\n",
					phaser.getArrivedParties());

			System.out.printf("Main: Phaser: Unarrived Parties:%d\n",
					phaser.getUnarrivedParties());

			System.out.printf("********************\n");

			// 13. ���߳�����1�룬���������ѭ����

			TimeUnit.SECONDS.sleep(1);

		}

	}
}

// 1. ����һ���࣬��Ϊ Task ��ʵ�� Runnable �ӿ�.

class Task implements Runnable {

	// 2. ����һ��˽�� int ���ԣ���Ϊ time��

	private int time;

	// 3. ����˽�� Phaser ���ԣ���Ϊ phaser.

	private Phaser phaser;

	// 4. ʵ����Ĺ��캯������ʼ������ֵ��

	public Task(int time, Phaser phaser) {

		this.time = time;

		this.phaser = phaser;

	}

	// 5. ʵ�� run() ���������ȣ�ʹ�� arrive() ����ָʾ phaser ��������ʼִ���ˡ�

	@Override
	public void run() {

		phaser.arrive();

		// 6. д��Ϣ���ٿ�̨�����׶�һ��ʼ�����̷߳������߼��룬ʹ��time��������������д��Ϣ���ٿ�̨�����׶�һ��������ʹ��
		// phaser ���Ե� arriveAndAwaitAdvance() ��������ʣ�µ�����ͬ����

		System.out.printf("%s: Entering phase 1.\n", Thread.currentThread()
				.getName());

		try {

			TimeUnit.SECONDS.sleep(time);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.out.printf("%s: Finishing phase 1.\n", Thread.currentThread()
				.getName());

		phaser.arriveAndAwaitAdvance();

		// 7. Ϊ�ڶ��͵����׶��ظ���һ�׶ε���Ϊ���ڵ����׶ε�ĩ��ʹ�� arriveAndDeregister()��������
		// arriveAndAwaitAdvance() ������

		System.out.printf("%s: Entering phase 2.\n", Thread.currentThread()
				.getName());

		try {

			TimeUnit.SECONDS.sleep(time);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.out.printf("%s: Finishing phase 2.\n", Thread.currentThread()
				.getName());

		phaser.arriveAndAwaitAdvance();

		System.out.printf("%s: Entering phase 3.\n", Thread.currentThread()
				.getName());

		try {

			TimeUnit.SECONDS.sleep(time);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.out.printf("%s: Finishing phase 3.\n", Thread.currentThread()
				.getName());

		phaser.arriveAndDeregister();

	}
}
