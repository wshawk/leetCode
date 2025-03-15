package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hawk
 * @package leetcode.string
 * @desc <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/?envType=study-plan-v2&envId=primers-list">2586. 统计范围内的元音字符串数</a>
 * @date 2025/3/15
 */
public class VowelStrings {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int ans = 0;
        for (int i = left; i <= right; i++) {
            char[] chars = words[i].toCharArray();
            if (set.contains(chars[0]) && set.contains(chars[chars.length - 1])){
                ans++;
            }
        }
        return ans;
    }

    public int vowelStrings1(String[] words, int left, int right) {
        String filter = "aeiou";
        int ans = 0;
        for (int i = left; i <= right; i++) {
            char[] chars = words[i].toCharArray();
            if (filter.indexOf(chars[0]) != -1 && filter.indexOf(chars[chars.length - 1]) != -1){
                ans++;
            }
        }
        return ans;
    }
}
