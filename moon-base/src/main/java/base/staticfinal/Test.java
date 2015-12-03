package base.staticfinal;

import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		/**
		 * 为什么第一个比较结果为true，而第二个比较结果为fasle。这里面就是final变量和普通变量的区别了，
		 * 当final变量是基本数据类型以及String类型时
		 * ，如果在编译期间能知道它的确切值，则编译器会把它当做编译期常量使用。也就是说在用到该final变量的地方
		 * ，相当于直接访问的这个常量，不需要在运行时确定
		 * 。这种和C语言中的宏替换有点像。因此在上面的一段代码中，由于变量b被final修饰，因此会被当做编译器常量
		 * ，所以在使用到b的地方会直接将变量b 替换为它的 值。而对于变量d的访问却需要在运行时通过链接来进行。
		 */
		
		SortedSet eee=new TreeSet();
		
		
		String a = "hello2";
		String aa=new String("hello2");
		final String b = "hello";
		String d = "hello";
		String c = b + 2;
		String e = d + 2;
		System.out.println((a == c));
		System.out.println(a==aa);
		System.out.println((a == e));
	}
}