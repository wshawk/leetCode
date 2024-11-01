package leetcode.handlenumber.hard;

/**
 * @author hawk
 * @package leetcode.handlenumber.hard
 * @desc
 * @date 2022/2/22
 */
public class TrappingRainWater {
    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
        testBreak();
    }

    public static int trap(int[] height) {
        int ans = 0;
        if (height.length == 0){
            return ans;
        }
        return ans;
    }

    public static void testBreak() {

        for(int i = 0; i < 3; i++) {
            a:
            for(int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if(j == 3) {
                    break a;
                }
            }
        }
        System.out.print(" >>> OK");
    }
}
