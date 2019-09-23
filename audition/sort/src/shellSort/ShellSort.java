package shellSort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[] {8,4,2,5,1,6,9,3,7};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        //遍历所有的步长,步长的规则为:初始值为长度/2,后每次除2
        for (int d = arr.length / 2; d > 0; d /= 2) {
            //遍历所有的元素:
            for (int i = d; i < arr.length; i++) {
                //遍历当前组的所有元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果当前元素大于加上步长的那个元素
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
            //System.out.println(d);
        }
    }
}
