package leetcode.handlenumber.easy;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc
 * @date 2022/7/31
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
