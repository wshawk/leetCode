package handlenumber.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author hawk
 * @package handlenumber.easy
 * @desc 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/9/7
 */
public class TwoSum {
    public static void main(String[] args) {
        Arrays.stream(twoSumByHash(new int[]{3, 2, 4}, 6)).forEach(System.out::println);
    }

    /**
     * 暴力破解
     * @param nums 输入数组
     * @param target 输入结果
     * @return 返回结果
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] resArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == sub && i != j) {
                    if (i > j) {
                        resArr[0] = j;
                        resArr[1] = i;
                    } else {
                        resArr[0] = i;
                        resArr[1] = j;
                    }
                }
            }
        }
        return resArr;
    }

    public static int[] twoSumByHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
