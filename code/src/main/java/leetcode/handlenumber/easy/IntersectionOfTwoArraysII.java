package leetcode.handlenumber.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @date 2021/9/7
 */
public class IntersectionOfTwoArraysII {
    /**
     * 计算数组的交集，利用map来记录数组元素出现的次数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            if (map.get(j) != null && map.get(j) > 0) {
                res.add(j);
                map.put(j, map.get(j) - 1);
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0, len = res.size(); i < len; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    /**
     * 给定的数组已经排好序的情况，考虑双指针
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集
     */
    public int[] intersectBySort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = 0, m = 0;
        List<Integer> list = new ArrayList<>();
        while (n <= nums1.length - 1 && m <= nums2.length - 1) {
            if (nums1[n] == nums2[m]) {
                list.add(nums1[n]);
                n++;
                m++;
            } else if (nums1[n] < nums2[m]) {
                n++;
            } else {
                m++;
            }
        }
        int[] resArray = new int[list.size()];
        for (int i = 0, len = list.size(); i < len; i++) {
            resArray[i] = list.get(i);
        }

        return resArray;
    }
}
