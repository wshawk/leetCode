package leetcode.handlenumber;

/**
 * @author hawk
 * @package leetcode.handlenumber
 * @desc 1588. 所有奇数长度子数组的和
 * TODO: 待解决
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * 通过次数 19,172 提交次数 23,893
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * @date 2021/5/24
 */
public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = (arr.length & 1) == 1 ? arr.length : arr.length - 1;
        for (int i = 1; i < n; i = i + 2){
        }
        return 0;
    }
    public int getSum(int[] arr, int length){
        if (length < 1){
            return 0;
        }
        if (length > arr.length){
            return 0;
        }
        for (int i=length-1; i>0; i--){
            System.out.println(arr[i]);
        }
        return 0;
    }
}
