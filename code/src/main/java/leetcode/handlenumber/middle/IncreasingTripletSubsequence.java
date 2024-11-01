package leetcode.handlenumber.middle;

/**
 * @author hawk
 * @package leetcode.handlenumber.middle
 * @desc
 * @date 2022/1/12
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));;
    }
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }

        for (int i=0; i<nums.length - 2; i++){
            if (nums[i] < nums[i+1] && nums[i+1] < nums[i + 2]){
                return true;
            }
        }
        return false;
    }
}
