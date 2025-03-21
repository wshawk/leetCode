package leetcode.handlenumber.easy;

import java.util.Arrays;

/**
 * @author wsHawk
 * @Title: FindPivotIndex
 * @ProjectName code
 * @Description: 724. 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * 示例 1：
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 *
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * @since 2021/9/10 23:38
 */
public class FindPivotIndex {
    /**
     * 暴力破解
     * 思路：
     *      数组遍历
     *      每个索引左边元素之和记作sumLeft
     *      每个索引右边元素之和记作sumRight
     *      如果 sumLeft == sumRight, 则返回该索引
     *      如果不存在  sumLeft == sumRight, 则返回 -1
     * @param nums 数组
     * @return 该数组的中心索引
     */
    public int pivotIndexByForceBrute(int[] nums) {
        for (int i=0; i<nums.length; i++){
           int sumLeft = 0;
           int sumRight = 0;
           for (int left=0; left < i; left++){
               sumLeft+=nums[left];
           }
           for (int right=i+1; right<nums.length; right++){
               sumRight+=nums[right];
           }
           if (sumLeft == sumRight){
               return i;
           }
        }
        return -1;
    }

    /**
     * 思路：
     *      计算出数组之和 sum
     *      中心索引左边元素之和 * 2 + 中心索引元素 == sum
     * @param nums 数组
     * @return 该数组的中心索引
     */
    public int pivotIndex(int[] nums){
        int sumLeft = 0;
        int sum = Arrays.stream(nums).sum();

        for (int i=0; i<nums.length; i++){
            if (sumLeft*2 + nums[i] == sum){
                return i;
            }
            sumLeft+=nums[i];
        }
        return -1;
    }
}
