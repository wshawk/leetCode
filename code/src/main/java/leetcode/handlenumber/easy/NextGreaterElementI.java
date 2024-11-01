package leetcode.handlenumber.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 *
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 *
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * `@date 2021/10/26
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 利用hashMap进行处理
        // int[] ans = new int[nums1.length];
        // Map<Integer, Integer> rightNextMap = new HashMap<>(nums2.length);
        // for (int i=0; i<=nums2.length-1;i++){
        //     int rightNext = -1;
        //     for (int j=i+1; j<=nums2.length-1; j++){
        //         if (nums2[j] > nums2[i]){
        //             rightNext = nums2[j];
        //             break;
        //         }
        //     }
        //     rightNextMap.put(nums2[i], rightNext);
        // }
        // for (int i=0; i<=nums1.length-1; i++){
        //     ans[i] = rightNextMap.get(nums1[i]);
        // }
        // return ans;

        /**
         * 单调栈
         * 具体的，由于我们目标是找到某个数其在 nums2 的右边中第一个比其大的数，因此我们可以对 nums2nums2 进行逆序遍历。
         * 我们在遍历 nums2nums2 时，实时维护一个单调栈，当我们遍历到元素 nums2[i] 时，可以先将栈顶中比 nums2[i] 小的元素出栈，最终结果有两种可能：
         *
         * 栈为空，说明 nums2[i] 之前（右边）没有比其大的数；
         *
         * 栈不为空， 此时栈顶元素为 nums2[i] 在 nums2 中（右边）最近的比其大的数。
         *
         * 再利用数组中数值各不相同，在遍历 nums2 的同时，使用哈希表记录每个 nums2[i] 对应目标值是多少即可。
         *
         */
        Map<Integer, Integer> map = new HashMap<>(nums2.length-1);
        Stack<Integer> stack = new Stack<>();

        for (int i= nums2.length-1; i>=0; i--){
            int x = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= x){
                stack.pop();
            }
            map.put(x, stack.isEmpty() ? -1 : stack.peek());
            stack.push(x);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
