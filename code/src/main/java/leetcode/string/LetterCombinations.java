package leetcode.string;

import javafx.scene.AmbientLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hawk
 * @package leetcode.string
 * @desc
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @date 2023/3/1
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return ans;
        }

        Map<Character, List<String>> map = initMap();
        for (char c : digits.toCharArray()) {
            List<String> strings = map.get(c);
            
        }

        return ans;
    }

    private Map<Character, List<String>> initMap(){
        Map<Character, List<String>> map = new HashMap<>();
        List<String> two = new ArrayList<>(3);
        two.add("a");
        two.add("b");
        two.add("c");

        map.put('2', two);

        List<String> three = new ArrayList<>(3);
        three.add("d");
        three.add("e");
        three.add("f");

        map.put('3', three);

        List<String> four = new ArrayList<>(3);
        four.add("g");
        four.add("h");
        four.add("i");

        map.put('4', four);

        List<String> five = new ArrayList<>(3);
        five.add("j");
        five.add("k");
        five.add("l");

        map.put('5', five);

        List<String> six = new ArrayList<>(3);
        six.add("m");
        six.add("n");
        six.add("o");

        map.put('6', six);

        List<String> seven = new ArrayList<>(4);
        seven.add("p");
        seven.add("q");
        seven.add("r");
        seven.add("s");

        map.put('7', seven);

        List<String> eight = new ArrayList<>(3);
        eight.add("t");
        eight.add("u");
        eight.add("v");

        map.put('8', eight);

        List<String> nine = new ArrayList<>(4);
        nine.add("w");
        nine.add("x");
        nine.add("y");
        nine.add("z");

        map.put('9', nine);


        return map;
    }
}
