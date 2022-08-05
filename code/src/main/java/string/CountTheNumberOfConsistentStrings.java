package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了92.33%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了60.44%的用户
     *
     * 别人的题解2。。。质的提升、飞跃
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsByOtherPerson2(String allowed, String[] words) {
        int ans = solve(allowed);
        int total = 0;
        for (String word : words) {
            int res = solve(word);
            if((res & ans) == res){
                total ++;
            }
        }
        return total;
    }

    public int solve(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            ans |= (1 << x);
        }
        return ans;
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了99.18%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了68.79%的用户
     *
     * 别人的题解3。。。提升1ms
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsByOtherPerson3(String allowed, String[] words) {
        int result = 0;
        //使用一个数组记录allowed 包含的字符，数组定位，效率较高
        int[] allow = new int[26];
        char[] chars = allowed.toCharArray();
        for (char aChar : chars) {
            allow[aChar - 'a'] = 1;
        }
        for (String word : words) {
            char[] arr = word.toCharArray();
            int index = 0;
            int length = arr.length;
            for (; index < length; index++) {
                //如果这个字符没有在allowed 中，直接结束
                if (allow[arr[index] - 'a'] == 0) {
                    break;
                }
            }
            //如果相等说明这个字符有判断到最后，结果加1
            if (index == length) {
                result++;
            }
        }
        return result;
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了47.32%的用户
     *
     * 别人的题解4。。。再次提升1ms，100.00%
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsByOtherPerson4(String allowed, String[] words) {
        int[] temp = new int[26];
        char[] arry = allowed.toCharArray();
        for (int i = 0; i < allowed.length(); i++) {
            // 通过临时变量数组，将数组内的所有值，都置为1
            temp[arry[i] - 'a'] = 1;
        }
        // 统计最多有words数组个匹配的
        int count = words.length;
        for (String s : words) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                // 如果要比较的字符串通过上面计算，不等于1，则表示不匹配
                if (temp[s.charAt(i) - 'a'] != 1) {
                    // 不匹配则减1，然后当前不需要再继续判断，跳出第二层循环
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
