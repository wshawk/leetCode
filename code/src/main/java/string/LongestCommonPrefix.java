package string;

/**
 * @author wsHawk
 * @Title: LongestCommonPrefix
 * @ProjectName code
 * @Description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @since 2021/9/12 21:24
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String commonPrefix = strs[0];
        int len = strs.length;
        for (int i=1; i<len; i++){
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.length() == 0){
                break;
            }
        }
        return commonPrefix;
    }

    /**
     * 截取两个字符串公共前缀
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 公共前缀
     */
    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;

        while (index<length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }
}
