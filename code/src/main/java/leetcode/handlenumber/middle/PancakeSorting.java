package leetcode.handlenumber.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.handlenumber.middle
 * @desc
 * @date 2022/2/19
 */
public class PancakeSorting {
    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3,2,4,1}));
//        System.out.println(checkSort(new int[]{}));
    }

    public static List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        // idxs的索引是arr数组的值，value是arr数组值的索引
        int[] idxs = new int[n+1];
        for (int i = 0; i < n; i++) {
            idxs[arr[i]] = i;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            int idx = idxs[i];
            // idx == i - 1 说明数字在正确的位置上，不需要排序了
            if (idx == i - 1) continue;
            // idx != 0 的话，则需要先反转一次，将
            // idx == 0 的话，直接反转子数组就可以将数字放到合适的位置上
            if (idx != 0) {
                ans.add(idx + 1);
                reverse(arr, 0, idx, idxs);
            }
            ans.add(i);
            reverse(arr, 0, i - 1, idxs);
        }
        return ans;
    }

    static void reverse(int[] arr, int i, int j, int[] idxs) {
        while (i < j) {
            idxs[arr[i]] = j;
            idxs[arr[j]] = i;
            int c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
    }

//    public static List<Integer> pancakeSort(int[] arr) {
//        List<Integer> ans = new ArrayList<>();
//        if (checkSort(arr)){
//            return ans;
//        }
//
//        return ans;
//    }
//
//    public static boolean checkSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
