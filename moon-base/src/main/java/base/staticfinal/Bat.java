package base.staticfinal;import java.util.List; import java.util.ArrayList; import java.util.LinkedList;public class Bat{    final double PI=3.14;          //在定义时便给址值    final int i;            //因为要在构造函数中进行初始化，所以此处便不可再给值    final List list;        //此变量也与上面的一样    Bat(){        i=100;         list=new LinkedList();    }    Bat(int ii,List l){         i=ii;         list=l;     }     public   void tt(int i){    	i=3;    	System.out.println(i);    }        public static void main(String[] args){     	    	final int i=4;            Bat b=new Bat();                 b.tt(i);        System.out.println(i);                             b.list.add(new Bat());         //b.i=25;         //b.list=new ArrayList();         System.out.println("I="+b.i+" List Type:"+b.list.getClass());         b=new Bat(23,new ArrayList());         b.list.add(new Bat());         System.out.println("I="+b.i+" List Type:"+b.list.getClass());     } }