package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hawk
 * @package string
 * @desc 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * @date 2021/10/8
 */
public class RepeatedDNASequences {
    /**
     * 思路：
     *      哈希表记录子串出现次数，返回次数大于 1 的 子串
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i+10 <= s.length(); i++){
            String child = s.substring(i, i+10);
            int t = map.getOrDefault(child, 0);
            if (t == 1) repeatList.add(child);
            map.put(child, t+1);
        }
        return repeatList;
    }
}
