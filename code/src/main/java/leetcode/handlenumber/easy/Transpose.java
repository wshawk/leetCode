package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc <a href="https://leetcode.cn/problems/transpose-matrix/?envType=study-plan-v2&envId=primers-list">867. 转置矩阵</a>
 * @date 2025/3/14
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int hangLen = matrix[0].length;
        int shuLen = matrix.length;
        int[][] ans = new int[shuLen][hangLen];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
