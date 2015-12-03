package base.string;

import dto.People;

public class Main {

	public static void main(String[] args) {
		Main mm = new Main();

		int i = 1;
		Integer ii = new Integer(1);
		String a = "ppp";
		String b = new String("ppp");
		StringBuffer c = new StringBuffer("ppp");
		People aaa = new People("aaa", 40);

		String ef = b;
		ef ="eee";
		System.out.println(b + "       " + ef);


		System.out.println("========================");

		mm.modifyInt(i);
		mm.modifyInteger(ii);
		mm.modifyStringA(a);
		mm.modifyStringB(b);
		mm.modifyStringC(c);
		mm.modifyObject(aaa);

		System.out.println(i);
		System.out.println(ii);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("--------------");
		aaa.show();
		


	}

	private void modifyInt(int i) {
		i = 40;
	}

	private void modifyInteger(Integer i) {
		i = new Integer(40);
	}

	private void modifyStringA(String str) {
		str = "sssss";
	}

	private void modifyStringB(String str) {
		str = new String("sss");
	}


	private void modifyStringC(StringBuffer str) {
		// str=new StringBuffer("");
		str = str.append("sss");
	}

	private void modifyObject(People aaa) {
		aaa.setAge(11);
		aaa.setName("ooo");
	}
}
