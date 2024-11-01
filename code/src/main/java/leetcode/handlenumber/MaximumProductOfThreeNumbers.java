package leetcode.handlenumber;

import java.util.Arrays;

/**
 * @author hawk
 * @package leetcode.handlenumber
 * @desc
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 1. 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 2. 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @date 2021/1/20
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        // if (nums.length == 3) {
        //     return nums[0] * nums[1] * nums[2];
        // }
        // Arrays.sort(nums);
        // if (nums[0] < 0
        //         && nums[0] * nums[1] > nums[nums.length - 1] * nums[nums.length - 2]
        // ) {
        //     return nums[0] * nums[1] * nums[nums.length - 1];
        // } else {
        //     return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        // }
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }
}
