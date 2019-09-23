package insertSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {9,3,4,1,5,8,2,7,6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        //遍历所有数字
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                //遍历前i-1个已经有序的数字
                for (j = i-1; j >=0&&temp<arr[j]; j--) {
                    //如果遍历到当前数字比temp的数字大,则将这些数字都往后移动一位
                    arr[j + 1] = arr[j];
                }
                //把外层for循环的当前元素放到前一个数字小于它的位置上
                arr[j+1] = temp;
            }
        }
    }
}
