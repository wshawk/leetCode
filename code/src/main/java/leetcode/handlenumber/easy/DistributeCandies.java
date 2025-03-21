package leetcode.handlenumber.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hawk
 * @package leetcode.handlenumber.easy
 * @desc 575. 分糖果
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 *
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 *
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 * 示例 2：
 *
 * 输入：candyType = [1,1,2,3]
 * 输出：2
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
 * 示例 3：
 *
 * 输入：candyType = [6,6,6,6]
 * 输出：1
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，尽管她能吃 2 枚，但只能吃到 1 种糖。
 *  
 *
 * 提示：
 *
 * n == candyType.length
 * 2 <= n <= 104
 * n 是一个偶数
 * -105 <= candyType[i] <= 105
 *
 * @date 2021/11/1
 */
public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(testErFen(5, new int[]{1,3,5,8,11,12,23,35,66,69,75,85,99,101}));
    }

    private static boolean testErFen(int i, int[] ints) {
        int low = 0;
        int high = ints.length;
        int mid = (low + high) / 2;
        int count = 1;
        while (mid >= 0 && mid <= ints.length - 1) {
            System.out.println("循环第 " + count + " 次");
            if (i > ints[mid]) {
                low = mid + 1;
            } else if (i < ints[mid]) {
                high = mid - 1;
            } else {
                return true;
            }
            mid = (low + high) / 2;
            count++;
        }
        return false;
    }


    public int distributeCandies(int[] candyType) {
        int n = candyType.length / 2;
        Map<Integer, Integer> map = new HashMap<>(candyType.length);
        for(int i:candyType){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        map.size()
        return 0;
    }
}
