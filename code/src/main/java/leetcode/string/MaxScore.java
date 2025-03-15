package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc <a href="https://leetcode.cn/problems/maximum-score-after-splitting-a-string/?envType=study-plan-v2&envId=primers-list">1422. 分割字符串的最大得分</a>
 * @date 2025/3/15
 */
public class MaxScore {
    public static void main(String[] args) {
        MaxScore a = new MaxScore();
        System.out.println(a.maxScore2("011101"));
    }

    /**
     * 解法一
     * 思路：直接遍历所有结果，然后比较大小
     *
     * @param s
     * @return
     */
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int spiltIndex = 0;
        int maxScore = 0;
        while (spiltIndex < chars.length - 1) {
            int leftScore = getScore(chars, '0', 0, spiltIndex);
            int rightScore = getScore(chars, '1', spiltIndex + 1, chars.length - 1);
            maxScore = Math.max(maxScore, leftScore + rightScore);
            spiltIndex++;
        }
        return maxScore;
    }

    private int getScore(char[] chars, char c, int beginIndex, int endIndex) {
        int score = 0;
        for (int i = beginIndex; i <= endIndex; i++) {
            if (chars[i] == c) {
                score++;
            }
        }

        return score;
    }


    /**
     * 解法二：
     * 左边的字符串得分只和 0 相关，在逐个遍历时可以判断，
     * 右边的字符串得分只和 1 相关，可以一次统计完整个字符串里 1 的个数，每一个1，记一分，遍历时，左边出现1，右边的得分就减一分
     * 分割线随着下标递增，进行前进
     *
     * @param s
     * @return
     */
    public int maxScore2(String s) {
        int right1 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            right1 = right1 + c - '0';
        }

        int left0 = 0;
        int score = 0;
        // 此处需要注意，分割线必须保证两边都有元素，所以分割线不能到字符串最后一位
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0') {
                left0++;
            } else {
                right1--;
            }
            score = Math.max(score, right1 +left0);
        }

        return score;
    }


}
