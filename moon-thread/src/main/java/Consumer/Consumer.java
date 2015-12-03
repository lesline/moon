package Consumer;

import java.util.concurrent.Callable;

class Consumer implements Callable<String> {
	private String name;
	private Storage s = null;

	public Consumer(String name, Storage s) {
		this.name = name;
		this.s = s;
	}

	@Override
	public String call() {
		
		try {
			System.out.println("--------" + name + "׼������");
			Product product = s.pop();
			System.out.println("--------" + name + "������[" + product.toString()+ "]");
		} catch (InterruptedException e) {
			e.printStackTrace();
			return name + "����ʧ��";
		}
		
		return name + "���ѳɹ�";
	}

}