package leetcode.handlenumber;

/**
 * @author hawk
 * @package leetcode.handlenumber
 * @desc LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例 1：
 *
 * 输入：[4,2,1]
 *
 * 输出：4
 *
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 示例 2：
 *
 * 输入：[2,3,10]
 *
 * 输出：8
 *
 * 限制：
 *
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 *
 * @date 2021/1/29
 */
public class TakeTheCoin {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.9 MB, 在所有 Java 提交中击败了22.51%的用户
     * @param coins
     * @return
     */
    public static int minCount(int[] coins) {
        int times = 0;
        for (int coin : coins) {
            if (coin == 1) {
                times = times + 1;
            }
            if (coin > 1 && coin % 2 == 1) {
                times = times + (coin / 2 + 1);
            } else {
                times = times + coin / 2;
            }
        }
        return times;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了45.74%的用户
     * 亮点：
     *      1. 代码简洁
     *      2. 利用int除法时，向下取整
     * @param coins
     * @return
     */
    public int minCountBetter(int[] coins) {
        int res = 0;
        for (int coin: coins) {
            res += (coin + 1) / 2;
        }
        return res;
    }
}
