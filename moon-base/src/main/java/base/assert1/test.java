package base.assert1;

import org.junit.Test;

/**
 * Created by lesline on 15/12/7.
 */
public class test {
    /**
     * Integer 中值-128~127 缓存在了cache中,所以
     * 当在    -128~127 中,a == b 为true
     * 当不在  -128~127 中,a == b 为false
     */
    @Test
    public void testInt10() {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
    }

    @Test
    public void testInt1000() {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);
    }

    @Test
    public void testAssert() {
        //断言1结果为true，则继续往下执行
        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");
    }
}
