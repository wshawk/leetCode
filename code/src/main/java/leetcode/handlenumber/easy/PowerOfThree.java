package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 326. 3的幂
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * 进阶：
 *
 * 你能不使用循环或者递归来完成本题吗？
 *
 * @date 2021/9/23
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
    public static boolean isPowerOfThree(int n) {
      while (n >= 3){
          int remainder = n % 3;
          if (remainder > 0){
              return false;
          }
          n = n/3;
      }
      return n == 1;
    }

    public boolean isPowerOfThreeByLeetCode(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * 无循环解法
     * 在题目给定的 3232 位有符号整数的范围内，最大的 3 的幂为 3^{19} = 1162261467
     * 我们只需要判断 n 是否是 3^{19}的约数即可。
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThreeNoCycle(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
