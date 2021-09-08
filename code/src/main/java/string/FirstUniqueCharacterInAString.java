package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author hawk
 * @package string
 * @desc 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/9/8
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println('a' - 'z');
    }
    /**
     * 暴力破解
     * @param s
     * @return
     */
    public int firstUniqCharByForceBrute(String s) {
        String[] sub = s.split("");
        Map<String, Integer> map = new HashMap<>();
        Set<String> dup = new HashSet<>();
        for (int i=0;i<sub.length;i++){
            if (map.containsKey(sub[i])){
                dup.add(sub[i]);
            }
            map.put(sub[i], i);
        }
        dup.forEach(map::remove);
        int i = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            i = Math.min(i,entry.getValue());
        }
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    public int firstUniqCharByMap(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        for (int i=0; i< s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return  -1;
    }

    /**
     * 每个字符底层都是存储的数字，不同的字符所表示的数字不同
     * @param s
     * @return
     */
    public int firstUniqCharBaseNum(String s) {
       char[] chs = s.toCharArray();
       // 26个小写字母，在字符中出现的次数，索引 0 位置上的值表示 a 在字符串中出现的次数。
       int[] map = new int[26];

        for (char ch : chs) {
            int index = ch - 'a';
           // 每出现一次， 加 1
            map[index]++;
        }

        for (int i = 0; i < chs.length; i++) {
            // 得出该字符在26个字符按中的位置
            int index = chs[i] - 'a';
            if (map[index] == 1) {
                return i;
            }
        }

        return -1;
    }
}
