package leetcode.handlenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsHawk
 * @Title: PalindromeNumber
 * @ProjectName code
 * @Description: 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 *
 * 提示：
 *
 * -231<= x <= 231- 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * @since 2021/5/23 11:12
 */
public class PalindromeNumber {

    public static boolean isPalindromeHawk(int x){
        if (x < 0) return false;
        int n = 0;
        List<Integer> list = new ArrayList<>();
        while(x >= 1){
            list.add(x % 10);
            x = x / 10;
            n++;
        }
        // 奇数
        if ((list.size() & 1) == 1){
            int index = (list.size() + 1) / 2;
            for (int i=0; i<index; i++){
                if (!(list.get(i).equals(list.get(list.size()-1 - i)))){
                    return false;
                }
            }
        }else{
            for (int i =0; i<list.size(); i++){
                if (!(list.get(i).equals(list.get(list.size()-1 - i)))){
                    return false;
                }
            }
        }
        return true;
    }
}
