package leetcode.string;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 819. 最常见的单词
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 *  
 *
 * 示例：
 *
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *  
 *
 * 提示：
 *
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 *
 * @date 2022/4/17
 */
public class MostCommonWord {

    /**
     * paragraph 只包含字母、空格和下列标点符号!?',;.
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) {
                continue;
            }
            int j = i;
            while (j < n && Character.isLetter(cs[j])) {
                j++;
            }
            String sub = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) {
                continue;
            }
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) {
                ans = sub;
            }
        }
        return ans;
    }

    /**
     * 自己写的
     * @param paragraph
     * @param banned
     * @return
     */
    public static String own(String paragraph, String[] banned) {
        String t = paragraph.replace(",", " ")
                .replace("!", " ")
                .replace(".", " ")
                .replace("'", " ")
                .replace("?", " ")
                .replace(";", " ")
                .toLowerCase();
        List<String> words = Stream.of(t.split(" "))
                .filter(word -> !"".equals(word))
                .collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>(1024);
        words.removeIf(word -> Arrays.asList(banned).contains(word));
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        AtomicReference<String> ans = new AtomicReference<>("");
        final int[] max = {0};
        map.forEach((k, v) -> {
            if (v > max[0]) {
                max[0] = v;
                ans.set(k);
            }
        });
        return ans.get();
    }
}
