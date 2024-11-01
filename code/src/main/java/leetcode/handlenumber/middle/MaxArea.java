package leetcode.handlenumber.middle;

/**
 * @author hawk
 * @package leetcode.handlenumber.middle
 * @desc
 * @date 2024/11/1
 */
public class MaxArea {
    /**
     * 无法通过，看看是为什么呢
     * @param height
     * @return
     */
    public int maxAreaError(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            int l = i;
            int r = height.length - 1;
            while (l < r){
                int x = r - l;
                if (height[l] >= height[r]){
                    maxArea = Math.max(maxArea, x * r);
                    r--;
                }else{
                    maxArea = Math.max(maxArea, x * l);
                    l++;
                }
            }
        }
        return maxArea;
    }

    /**
     * 又一个错误案例，看看为什么错了，
     * @param height
     * @return
     */
    public int maxAreaError2(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r){
            int x = r - l;
            if (height[l] >= height[r]){
                maxArea = Math.max(maxArea, x * r);
                r--;
            }else{
                maxArea = Math.max(maxArea, x * l);
                l++;
            }
        }
        return maxArea;
    }

    public int maxAreaSuccess(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r){
            int x = r - l;
            if (height[l] >= height[r]){
                maxArea = Math.max(maxArea, x * height[r--]);
            }else{
                maxArea = Math.max(maxArea, x * height[l++]);
            }
        }
        return maxArea;
    }
}
