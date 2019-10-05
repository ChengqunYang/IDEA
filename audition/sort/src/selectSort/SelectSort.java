package selectSort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = new int[] {2,1,3,6,4,8,5,9,7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        //遍历所有的数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数依次进行比较,记录下最下的那个数的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //如果最小的和当前遍历的数的下标不一样(当前遍历的数字不是后面的数字中最小的)
            if(i!= minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }
}
