package quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 8, 1, 9, 2, 4, 7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        //满足排序的条件有数字可以排序
        if (start < end) {
            //把数组中的第一个元素作为基准数
            int flag = arr[start];
            int low = start;
            int high = end;
            //当高低指针不重合的情况下一直比较
            while (low < high) {
                //高指针指向的位置的数比基准数大,高指针向低移动一位
                while (low < high && flag <= arr[high]) {
                    high--;
                }
                //高指针位置元素比基准数小,使用高指针元素覆盖低指针元素
                arr[low] = arr[high];
                //如果低指针位置的元素比基准数小,低指针向高移动一位
                while (low < high && arr[low] <= flag) {
                    low++;
                }
                //低指针位置的元素比基准数大,使用低指针的元素覆盖高指针元素
                arr[high] = arr[low];
            }
            //高低指针重合后,将基准数赋给任意指针所指向的位置
            arr[low] = flag;
            //一次排序完成,递归排序
            //处理前半部分
            quickSort(arr,start,low);
            //处理后半部分
            quickSort(arr,low+1,end);
        }
    }
}
