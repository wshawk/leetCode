package string;

/**
 * @author hawk
 * @package string
 * @desc 1071. 字符串的最大公因子
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 *
 * @date 2022/1/3
 */
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStringsBetter("ABCABC", "ABC"));
        System.out.println(gcdOfStringsBetter("ABABAB", "ABAB"));
        System.out.println(gcdOfStringsBetter("LEET", "CODE"));
        System.out.println(gcdOfStringsBetter("ABCDEF", "ABC"));
        System.out.println(gcdOfStringsBetter("ABABCCABAB", "ABAB"));
        System.out.println(gcdOfStringsBetter("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }
    // 错误做法
    public static String gcdOfStrings(String str1, String str2) {
        int str2Len = str2.length();
        for (int i = 0, str1Len = str1.length(); i < str1Len; i++) {
            if (i < str2Len) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return "";
                }
            } else {
                break;
            }
        }
        if (str1.length() % str2Len == 0) {
            if (str1.replaceAll(str2, "").equals("")){
                return str2;
            }else{
                return "";
            }

        }
        for (int i = 0; i < str2Len; i++) {
            String common = str2.substring(0, i + 1);
            if (str2.replaceAll(common, "").equals("")) {
                if (str1.replaceAll(common, "").equals("")){
                    return common;
                }
            }
        }

        return "";
    }

    /**
     * 欧几里得算法又称辗转相除法，是指用于计算两个非负整数a，b的最大公约数。应用领域有数学和计算机两个方面。计算公式gcd(a,b) = gcd(b,a mod b)。
     * 如果 str1 和 str2 存在最大公约数 str，那么就相当于 str1 和 str2 都是由 str 组成的，那么 str1 + str2 和 str2 + str1 应该是相等的
     *         如果不满足，那么不存在最大公约数
     *
     *         我们可以通过 两个字符串的长度来求得最大公约数的长度
     *         比如 str1 = "ABABAB", str2 = "ABAB"
     *             len1 = 6         len2 = 4
     *             那么最大公约数 str = "AB"
     *                          len = 2
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStringsBetter(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public static int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    int gcdRecursion(int m, int n) {
        if (n == 0) {
            return m;
        }
        int r = m % n;
        return gcdRecursion(n, r);
    }
}
