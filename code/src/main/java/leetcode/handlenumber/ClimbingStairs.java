package leetcode.handlenumber;

/**
 * @author wsHawk
 * @Title: ClimbingStairs
 * @ProjectName code
 * @Description: 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * @since 2021/5/22 22:19
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(climbStairsDynamicProgramming(6));
    }

    /**
     * 暴力解法
     * @param n 总共需要爬的楼梯数
     * @return 总共的方法数
     */
    public static int climbStairs(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划解法
     * @param n 总共需要爬的楼梯数
     * @return 总共的方法数
     */
    public static int climbStairsDynamicProgramming(int n){
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
