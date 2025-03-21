package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * @date 2022/1/3
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                str.append(Character.toLowerCase(c));
            }
        }
        int n = str.length();
        for (int i=0; i<n; i++){
            if (!(str.charAt(i) == str.charAt(n-i-1))){
                return false;
            }
        }
        return true;
    }
}
