package heapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[] {5,2,6,8,1,9,4,3,7};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maxHeap(int[] arr,int size,int index) {
        //左子节点
        int leftNode = 2*index+1;
        //右子节点
        int rightNode = 2*index+2;
        int max = index;
        //和两个子节点进行对比,找出最大的节点
        if (leftNode<size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode<size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        //交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //调整完该节点后,可能会对已经调整好的堆造成影响,所以需要重新调整
            maxHeap(arr, size, max);
        }
    }
    private static void heapSort(int[] arr) {
        //从最后一个非叶子节点开始进行调整,调整到根节点
        int start = (arr.length - 1) * 2;
        for (int i = start; i >= 0; i--) {
            maxHeap(arr,arr.length,i);
        }
        //先把数组中的第0个和堆中的最后一个数进行位置交换,再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp =arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr,i,0);
        }
    }
}
