package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc
 * @date 2024/11/2
 */
public class MoveZero {
    /**
     * 错误的案例
     * @param nums
     */
    public static void moveZeroesError(int[] nums) {
        // 记录非零数
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[i] = nums[++j];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
