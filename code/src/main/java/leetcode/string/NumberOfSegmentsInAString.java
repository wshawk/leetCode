package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * @date 2021/10/7
 */
public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello,    my name is John"));
    }

    /**
     * 分段计数
     */
    public static int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            ans++;
        }
        return ans;
    }
}
