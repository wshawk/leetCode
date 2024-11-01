package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 136. 只出现一次的数字
 * @date 2021/6/7
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 通过次数414,146提交次数578,961
 */
public class SingleNumber {
    /**
     *
     * 异或运算的基本性质：
     * 1. a ^ a = 0
     * 2. a ^ 0 = a
     * 3. a ^ (b ^ c) = (a ^ b) ^ c
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了96.34%的用户
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums){
            res ^= i;
        }
        return res;
    }
}
