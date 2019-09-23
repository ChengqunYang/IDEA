package radixSort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{921, 334, 63, 22, 15,89,77, 475, 875, 54, 76};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //先找到最大的元素,决定排序多少轮
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //求最大数字的位数
        int maxLength = (max+"").length();
        //用于临时存储数据的数组
        int[][] temp = new int[10][arr.length];
        //定义变量存储数组中已经存储的元素的个数(用于确定将下一个数字放到数组中的什么位置)
        int[] counts = new int[10];
        //根据最大长度决定比较的次数,每一轮根据n的值取出不同位的数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //对每一个数分别计算余数
            for (int j = 0; j < arr.length; j++) {
                int ys = arr[j]/n%10;
                temp[ys][counts[ys]]=arr[j];
                //让数组中的元素个数加1
                counts[ys]++;
            }
            //对每一位排完序后,把数字取出来
            for (int k = 0, s = 0; k < counts.length; k++) {
                //如果对应位里面有数字,将其取出
                if (counts[k] != 0) {
                    for (int l = 0; l < counts[k]; l++) {
                        arr[s] = temp[ k][l];
                        s++;
                    }
                    //把计数数组清空
                    counts[k] = 0;
                }
            }
        }
    }
}
