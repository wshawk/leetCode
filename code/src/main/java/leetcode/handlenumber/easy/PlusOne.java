package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 66. 加一
 * @date 2021/6/7
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 通过次数299,286提交次数653,900
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {8,9,9,9};
        int[] res = plusOne(arr);
        for (int i : res){
            System.out.println(i);
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了99.09%的用户
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int last = digits.length - 1;
        int[] newArr = new int[digits.length + 1];
        while (true){
            if (digits[last] + 1 == 10){
                digits[last] = 0;
                last--;
                if (last < 0){
                    newArr[0] = 1;
                    break;
                }
            }else{
                digits[last] = digits[last] + 1;
                break;
            }
        }
        if (newArr[0] != 1){
            return digits;
        }else{
            return newArr;
        }
    }
}
