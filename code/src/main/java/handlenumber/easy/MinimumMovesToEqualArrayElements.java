package handlenumber.easy;

import java.util.Arrays;

/**
 * @author hawk
 * @package handlenumber.easy
 * @desc 453. 最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 *
 * @date 2021/10/20
 */
public class MinimumMovesToEqualArrayElements {
    /**
     * 假设目前数组总和为sum，我们需要移动次数为m，那么整体数组总和将会增加m * (n - 1)，这里的n为数组长度，最后数组所有元素都相等为x，于是有：
     *
     * sum + m * (n - 1) = x * n (1)
     *
     * 我们再设数组最小的元素为min_val，m = x - min_val，即 x = m + min_val带入(1)得：
     *
     * m = sum - min_val * n
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - (Arrays.stream(nums).min().getAsInt() * nums.length - 1);
    }
}
