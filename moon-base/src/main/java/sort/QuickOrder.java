package sort;

import java.util.Arrays;


public class QuickOrder {

    /*
     * 【第一次分割结果为使mid的左边<mid，右边>mid】
     *
     * 选首字段array[0]为目标中间字段mid，首字段array[0]=array[left]为空位
     *
     * 用mid先从右边最高位right比较，如果a[right]>mid,则right-1,继续，直到a[right-n]<mid时，将a[right-n]移到左空位
     * 此时a[right-n]为空位，此后，用mid从左边最低位left比较，找到a[left+n]>mid时,将其移到空位
     *
     *
     * 例一：
        4 5 1 9 2 3

          5 1 9 2 3    4
        3 5 1 9 2      4
        3   1 9 2 5    4
        3 2 1 9   5    4
        3 2 1   9 5    4



        例二：

        [4, 5, 1, 0, 2, 3]
        [3, 2, 1, 0, 4, 5]


     */
    public static void main(String[] args) {

        int[] a={4,5,1,0,2,3};
        System.out.println(Arrays.toString(a));
        getStr(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

    /*
     *
     */
    static void getStr(int[] a, int left, int right) {
        if(left >= right) return;
        int iLeft = left;
        int iRihgt = right;
        int mid = a[left];
        while (left < right) {
			/*
			 * 高位从右向左移
			 */
            while (left < right && mid < a[right]) {
                right--;
            }
            ;
            a[left] = a[right];
			/*
			 * 低位从左向右移
			 */
            while (left < right && mid > a[left]) {
                left++;
            }
            ;
            a[right] = a[left];
        }
        ;
        a[left] = mid;
        System.out.println(iLeft+":"+left+":"+iRihgt);
        System.out.println(Arrays.toString(a));
        getStr(a, iLeft, left - 1);
        getStr(a, left + 1, iRihgt);
    }

}
