package init;

class parent {
	int i = 11;
	static int m = 22;
	static {
		System.out.println("-----parent静态变量");
	}

	public parent() {
		System.out.println("parent 构造方法中 i=" + i);
		System.out.println("parent 构造方法中 m=" + m);

		this.method();
		
		i = 1111;
		m = 2222;
		System.out.println("parent 构造方法中 i=" + i);
		System.out.println("parent 构造方法中 m=" + m);
	}

	public void method() {
		System.out.println("-----parent------method");
		System.out.println(i);
		System.out.println(m);

	}
}

class son extends parent {
	int i = 33;
	static int m = 44;
	static {
		System.out.println("-----son-静态变量");
	}

	public son() {
		super();//默认有这一步
		System.out.println("son 构造方法中 i=" + i);
		System.out.println("son 构造方法中 m=" + m);
		i = 3333;
		m = 4444;

		System.out.println("son 构造方法中 i=" + i);
		System.out.println("son 构造方法中 m=" + m);
	
	}

	public void method() {
		System.out.println("-----son------method");
		System.out.println(this.i);
		System.out.println(m);

	}
        
        
        public static void main(String[] args)
        {
		son a = new son();
		System.out.println("---------------------------------");
		a.method(); 
        }
		
	/*
	-----parent静态变量
	-----son-静态变量
	parent 构造方法中 i=11
	parent 构造方法中 m=22
	-----son------method
	0
	44
	parent 构造方法中 i=1111
	parent 构造方法中 m=2222
	son 构造方法中 i=33
	son 构造方法中 m=44
	son 构造方法中 i=3333
	son 构造方法中 m=4444
	---------------------------------
	-----son------method
	3333
	4444
*/
}
