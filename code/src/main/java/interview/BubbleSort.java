package interview;

/**
 * @author hawk
 * @package interview
 * @desc
 * @date 2025/2/14
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }


    public static void bubbleSortBetter(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        boolean swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = false;
            for (int j = arr.length - 1 - i; j >= 0; j--) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            if (!swap){
                break;
            }
        }

    }
}
