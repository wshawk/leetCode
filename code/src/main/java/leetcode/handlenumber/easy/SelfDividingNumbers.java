package leetcode.handlenumber.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 728. 自除数
 * @date 2021/6/10
 * 自除数是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足1 <= left <= right <= 10000。
 * 通过次数31,952提交次数42,171
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SelfDividingNumbers {
    public  List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i=left; i<=right; i++){
            if (isSelfDividingNumber(i)){
                res.add(i);
            }
        }
        return res;
    }
    public  boolean isSelfDividingNumber(int num){
        // 取到该数字的每一位数
        List<Integer> list = new ArrayList<>();
        int temp = num;
        while (temp > 0){
            int t = temp % 10;
            if (t == 0){
                return false;
            }else {
                list.add(t);
            }
            temp/=10;
        }
        for (Integer i : list){
            if (num % i != 0){
                return false;
            }
        }
        return true;
    }
}
