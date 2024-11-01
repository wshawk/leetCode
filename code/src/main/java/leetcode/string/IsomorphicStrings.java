package leetcode.string;

import java.util.HashMap;

/**
 * @author hawk
 * @package leetcode.string
 * @desc
 * @date 2022/7/25
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>(s.length());
        HashMap<Character, Character> t2s = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if ((s2t.containsKey(a) && s2t.get(a) != b) || (t2s.containsKey(b) && t2s.get(b) != a)) {
                return false;
            }
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}
