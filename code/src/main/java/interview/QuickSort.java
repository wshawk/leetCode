package interview;

import java.util.stream.Stream;

/**
 * @author hawk
 * @package interview
 * @desc
 * @date 2025/3/6
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 4, 6, 7, 9, 0, 8, 5};
        quickSortHawk(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到分区点
            int pivotIndex = partition(arr, low, high);

            // 递归排序左右两部分
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为基准值
        int i = low - 1; // i 是小于基准值区域的尾部索引

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 将基准值放到正确的位置
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        return i + 1; // 返回基准值的索引
    }




    public static void quickSortHawk(int[] arr){
        quickSortHawk(arr, 0, arr.length - 1);
    }

    public static void  quickSortHawk(int[] arr, int low, int high){
        if (low < high){
            int index = partitionHawk(arr, low, high);

            quickSortHawk(arr, low, index - 1);
            quickSortHawk(arr, index + 1, high);
        }
    }

    private static int partitionHawk(int[] arr, int low, int high) {
        int standValue = arr[high];
        while (low < high){
            while (low < high && arr[low] <= standValue){
                low++;
            }
            arr[high] = arr[low];
            while (low < high && arr[high] >= standValue){
                high--;
            }
            arr[low] = arr[high];
        }
        arr[high] = standValue;
        return high;
    }
}
