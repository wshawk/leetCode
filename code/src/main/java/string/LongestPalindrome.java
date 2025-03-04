package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hawk
 * @package string
 * @desc
 * @date 2022/7/29
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int initSize = (int) Math.ceil(s.length()/0.75d);
        Map<Character, Integer> map = new HashMap<>(initSize);
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int remainder = count % 2;
            res += count - remainder;
            if (remainder == 1){
                odd = 1;
            }
        }
        return res + odd;
    }
}
