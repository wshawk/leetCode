package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hawk
 * @package string
 * @desc 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
 *
 * 请你返回words数组中一致字符串 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 *
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed中的字符 互不相同。
 * words[i] 和allowed只包含小写英文字母。
 *
 * @date 2021/1/29
 */
public class CountTheNumberOfConsistentStrings {
    /**
     * 执行用时：66 ms, 在所有 Java 提交中击败了6.99%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了6.08%的用户
     *
     * 这种做法太low了。。。
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        String[] allowedStrings = allowed.split("");
        int count = 0;
        for (String word:words){
            for (String allow:allowedStrings){
                word = word.replace(allow,"");
            }
            if (word.length() == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 执行用时：164 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：44.5 MB, 在所有 Java 提交中击败了5.04%的用户
     *
     * 想着用下stream，看能不能提高一下效率，结果表明我想的太多了。。。
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsV1(String allowed, String[] words) {
        Set<String> allowset = new HashSet<>(Arrays.asList(allowed.split("")));
        return Integer.parseInt(String.valueOf(Arrays.stream(words).filter(x->{
            Set<String> xset  = new HashSet<>(Arrays.asList(x.split("")));
            return allowset.containsAll(xset);
        }).count()));
    }
    /**
     * 执行用时：164 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：44.7 MB, 在所有 Java 提交中击败了5.04%的用户
     *
     * 去掉stream，好像也没差？
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsV2(String allowed, String[] words) {
        int count=0;
        Set<String> allowset = new HashSet<>(Arrays.asList(allowed.split("")));
        for (String word:words){
            Set<String> xset  = new HashSet<>(Arrays.asList(word.split("")));
            if (allowset.containsAll(xset)){
                count++;
            }
        }
        return count;
    }

    /**
     * 执行用时：27 ms, 在所有 Java 提交中击败了21.91%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了10.16%的用户
     *
     * 别人的题解。。。
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsByOtherPerson(String allowed, String[] words) {
        int result=words.length;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                String a=null;
                if(!allowed.contains(a.valueOf(words[i].charAt(j)))){
                    result--;break;
                }
            }
        }
        return result;
    }
}
