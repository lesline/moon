package base.fx;
public class GenericsFooDemo {
    public static void main(String args[]) {
        GenericsFoo<String> strFoo = new GenericsFoo<String>("Hello Generics!");
        GenericsFoo<Double> douFoo = new GenericsFoo<Double>(new Double("33"));
        GenericsFoo<Object> objFoo = new GenericsFoo<Object>(new Object());
        System.out.println("strFoo.getX=" + strFoo.getX());
        System.out.println("douFoo.getX=" + douFoo.getX());
        System.out.println("objFoo.getX=" + objFoo.getX());
    }
}