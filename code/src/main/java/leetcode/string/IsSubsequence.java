package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/7/26
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i=0;
        for (int m=0; m<t.length(); m++){
            if (s.charAt(i) == t.charAt(m)){
                if (++i == s.length()){
                    return true;
                }
            }
        }

        return  false;
    }
    public boolean isSubsequencess(String s, String t) {
       if (s.length() == 0){
           return true;
       }
        for (int i=0,j=0; j<t.length(); j++){
            if (s.charAt(i) == t.charAt(j)){
                if (++i == s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
