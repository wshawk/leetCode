package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。
 *
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 *
 * 输入：sentence = "leetcode"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/9/18
 */
public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
    public static boolean checkIfPangram(String sentence) {
        // 错误
        // return Stream.of(sentence.toCharArray()).collect(Collectors.toSet()).size() == 26;
        char[] chars = sentence.toCharArray();
        Set<Integer> set = new HashSet<>();
        for (char c: chars){
            set.add(c - 'a');
        }
        return set.size() == 26;
    }
}
