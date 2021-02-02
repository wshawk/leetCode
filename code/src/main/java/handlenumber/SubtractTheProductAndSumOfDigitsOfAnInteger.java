package handlenumber;

/**
 * @author hawk
 * @package handlenumber
 * @desc
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * 提示：
 *
 * 1 <= n <= 10^5
 * @date 2021/2/2
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了5.86%的用户
     * 内存消耗：35.8 MB, 在所有 Java 提交中击败了5.16%的用户
     * @date 2021/2/2
     * @param n
     * @return
     */
    public static int subtractProductAndSumV1(int n) {
        String str = n+"";
        String[] arr = str.split("");
        int multipleResult=1;
        int sumResult=0;
        for (String s : arr) {
            multipleResult *= Integer.parseInt(s);
            sumResult += Integer.parseInt(s);
        }
        return  multipleResult - sumResult;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.4 MB, 在所有 Java 提交中击败了24.32%的用户
     * @param n
     * @return
     */
    public static int subtractProductAndSumV2(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int multipleResult=1;
        int sumResult=0;
        for (int i=0; i<num.length; i++){
            int temp = num[i] - '0';
            multipleResult *= temp;
            sumResult += temp;
        }
       return multipleResult - sumResult;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.3 MB, 在所有 Java 提交中击败了36.22%的用户
     * @param n
     * @return
     */
    public static int subtractProductAndSumV3(int n) {
        int add = 0, mul = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            add += digit;
            mul *= digit;
        }
        return mul - add;
    }
}
