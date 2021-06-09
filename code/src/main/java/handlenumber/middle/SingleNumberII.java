package handlenumber.middle;

import java.util.BitSet;

/**
 * @author hawk
 * @package handlenumber.middle
 * @desc 137. 只出现一次的数字 II
 * @date 2021/6/7
 * 给你一个整数数组nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 *
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 通过次数89,904提交次数125,068
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(a & ~0);
    }

    /**
     * a & ~a = 0
     * a & ~0 = a
     * a ^ a = 0
     * a ^ 0 = a
     *
     * 没有看的很明白，，，
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
}
