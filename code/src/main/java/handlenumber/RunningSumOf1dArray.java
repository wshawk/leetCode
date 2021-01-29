package handlenumber;

/**
 * @author hawk
 * @package handlenumber
 * @desc 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6<= nums[i] <=10^6
 * @date 2021/1/29
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了13.67%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了50.51%的用户
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        for (int i = 0, len = nums.length - 1; i <= len; i++) {
            runningSum[i] = sumOf1d(i, nums);
        }
        return runningSum;
    }

    public static int sumOf1d(int index, int[] nums) {
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了9.29%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了94.00%的用户
     * @param nums
     * @return
     */
    public int[] runningSumV1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<i; j++){
                result[i] +=nums[j];
            }
        }
        return result;
    }


}
