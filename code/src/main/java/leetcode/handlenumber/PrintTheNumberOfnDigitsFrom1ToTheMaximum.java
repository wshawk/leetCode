package leetcode.handlenumber;

/**
 * @author hawk
 * @package leetcode.handlenumber
 * @desc 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @date 2021/2/5
 */
public class PrintTheNumberOfnDigitsFrom1ToTheMaximum {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：46.8 MB, 在所有 Java 提交中击败了43.49%的用户
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        if (n == 0){
            return new int[0];
        }
        StringBuilder nine = new StringBuilder();
        for (int i=0; i<n; i++){
            nine.append("9");
        }
        int num = Integer.parseInt(nine.toString());
        int[] res = new int[num];
        for (int i=0; i<num; i++){
            res[i]=i+1;
        }
        return res;
    }
}
