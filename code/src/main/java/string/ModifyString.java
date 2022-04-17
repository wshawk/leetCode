package string;

/**
 * @author hawk
 * @package string
 * @desc 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 * 示例 2：
 * <p>
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 * 示例 3：
 * <p>
 * 输入：s = "j?qg??b"
 * 输出："jaqgacb"
 * 示例 4：
 * <p>
 * 输入：s = "??yw?ipkj?"
 * 输出："acywaipkja"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * <p>
 * s 仅包含小写英文字母和 '?' 字符
 * @date 2022/1/5
 */
public class ModifyString {
    private static final char[] LETTER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'w', 's', 'x', 'y', 'z', 'r', 't', 'u', 'v'};

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int n) {
        // * / + -
        int ans = n;
        int flag = 0;
        while ( n != 0){
            if (flag % 4 == 0){
                ans = ans * (n - 1);
            }else if (flag % 4 == 1){
                ans = ans / (n-1);
            }else if (flag % 4 == 2){
                ans = ans + (n-1);
            }else{
                ans = ans -(n-1);
            }
            if (flag == 3){
                flag = -1;
            }
            flag++;
            n--;
        }
        return ans;
    }

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++){
            char begin = 0,after = 0;
            if (i-1>= 0){
                begin = chars[i-1];
            }
            if (i+1 < chars.length){
                after = chars[i+1];
            }
            char curr = chars[i];
            if (curr == '?'){
                if (i == 0){
                    for (char c: LETTER){
                        if (c == after){
                            continue;
                        }
                        chars[i] = c;
                        break;
                    }
                }else if (i == chars.length -1){
                    for (char c: LETTER){
                        if (c == begin){
                            continue;
                        }
                        chars[i] = c;
                        break;
                    }
                } else{
                    for (char c: LETTER){
                        if (c != begin && c != after){
                            chars[i] = c;
                            break;
                        }
                    }
                }
            }

        }
        return new String(chars);
    }


    public String modifyStringAnother(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '?') {
                continue;
            }
            for (char c : LETTER) {
                if (i == 0) {
                    if (chars.length == 1){
                        chars[i] = 'a';
                        break;
                    }
                    if (c != chars[i + 1]) {
                        chars[i] = c;
                        break;
                    }
                } else if (i == chars.length - 1) {
                    if (c != chars[i - 1]) {
                        chars[i] = c;
                        break;
                    }
                } else {
                    if (c != chars[i - 1] && c != chars[i + 1]) {
                        chars[i] = c;
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}
