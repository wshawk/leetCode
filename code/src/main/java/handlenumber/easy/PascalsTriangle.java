package handlenumber.easy;

import java.util.List;

/**
 * @author hawk
 * @package handlenumber.easy
 * @desc 118. 杨辉三角
 * @date 2021/6/9
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 通过次数175,029提交次数245,830
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        final int NMAX = 10;

        // allocate triangular array
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            odds[n] = new int[n + 1];
        }

        // fill triangular array
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++)
            {
                /*
                 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                 */
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }

                odds[n][k] = lotteryOdds;
            }
        }

        // print triangular array
        for (int[] row : odds)
        {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> generate(int numRows) {

        return null;
    }
}
