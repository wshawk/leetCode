package handlenumber.middle;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author hawk
 * @package handlenumber.middle
 * @desc 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 * @date 2021/12/30
 */
public class HandOfStraights {
    public static void main(String[] args) {
        System.out.println(isNStraightHandBetter(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null) {
            return false;
        }
        if (!(hand.length % groupSize == 0)) {
            return false;
        }
        // 排序
        Arrays.sort(hand);
        List<Integer> list = new ArrayList<>(hand.length);
        for (int i : hand) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            int first = list.get(0);
            list.remove(0);
            for (int a = 0; a < groupSize - 1; a++) {
                int removeIndex = -1;
                for (int i=0, len=list.size(); i<len; i++){
                    if (list.get(i) == first + a + 1){
                        removeIndex = i;
                    }
                }
                if (removeIndex == -1){
                    return false;
                }
                list.remove(removeIndex);
            }
        }

        return true;
    }



    public static boolean isNStraightHandBetter(int[] hand, int groupSize) {
        if (hand == null) {
            return false;
        }
        if (!(hand.length % groupSize == 0)) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i:hand){
            if (!map.containsKey(i)){
                continue;
            }
            for (int a=0; a<groupSize; a++){
                int n = i+a;
                if (!map.containsKey(n)){
                    return false;
                }
                map.put(n, map.get(n) -1);
                if (map.get(n) == 0){
                    map.remove(n);
                }
            }
        }
        return true;
    }
}
