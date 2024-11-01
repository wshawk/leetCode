package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc
 * @date 2022/1/10
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));;
    }
    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        for (int i=num.length()-1; i>0; i--){
            long end = Long.parseLong(num.substring(i));
            long beforeA = Long.parseLong(num.substring(i-1, i));
            long beforeB = Long.parseLong(num.substring(i-2, i-1));

            if (end == beforeA + beforeB){
                return true;
            }
        }
        return false;

    }
}
