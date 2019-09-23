package mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,5,2,1,4,6,8};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high+low)/2;
        if (low<high) {
            //处理左边
            mergeSort(arr, low, middle);
            //处理右边
            mergeSort(arr, middle + 1, high);
            //归并
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high-low+1];
        //记录第一个数组中需要开始遍历的下标
        int i = low;
        //记录第二个数组中需要开始遍历的下标
        int j = middle+1;
        //记录下一个要放入临时数组中的元素应该放到哪个下标
        int index = 0;
        //遍历两个数组取出最小的数字,放入临时数组中
        //条件为两个数组中的元素都没被遍历完
        while (i <= middle&&j<=high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
                index++;
            }else{
                temp[index] = arr[j];
                j++;
                index++;
            }
        }
        //其中有一个数组中的元素已经遍历完成,处理另一个数组中多于的数据
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        //把临时数组中的数据重新存入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }
}
