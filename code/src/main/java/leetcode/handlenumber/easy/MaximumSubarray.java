package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 53. 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 * @date 2021/9/3
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5,-6};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 不是很明白。。。。
     * https://leetcode-cn.com/problems/maximum-subarray/comments/
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num:nums){
            if (num > 0){
                sum+=num;
            }else{
                sum=num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

}
