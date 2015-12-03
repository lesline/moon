package Producer;


import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;


class Producer implements Callable<String> {
	private String name;
	private Storage storage = null;
	private int level;
	private AtomicBoolean isSuccess;
	public Producer(String name, int level, Storage storage, AtomicBoolean isSuccess) {
		this.name = name;
		this.level=level;
		this.storage = storage;
		this.isSuccess=isSuccess;
	}


	public String call() throws Exception {
		Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数

		try {
			Thread.sleep(1000*(level+1));
			if(level==2){
				throw new InterruptedException("当level==2时抛出错误");
			}
			System.out.println("++++++++" + name + "准备生产[" + product.toString()+ "]");
			storage.push(product);
			System.out.println("++++++++" + name + "已生产[" + product.toString()+ "]");
		} catch (InterruptedException e) {
			e.printStackTrace();
			isSuccess.set(false);
			return name+"生产失败";
		}finally{
			if(!isSuccess.get()){
				System.out.println("=================生产线程失败==================="+this.name);
				//throw new Exception("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 生产线程失败");
			}else{
				System.out.println("=================生产线程结束==================="+this.name);
			}
		}

		return name+"生产成功";
	}
}