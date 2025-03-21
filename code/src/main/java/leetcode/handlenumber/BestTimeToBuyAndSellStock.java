package leetcode.handlenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wsHawk
 * @Title: BestTimeToBuyAndSellStock
 * @ProjectName code
 * @Description: 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * @since 2021/5/23 22:45
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 暴力破解。。。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        long startTime = System.currentTimeMillis();
        List<Integer> resultList = new ArrayList<>();
        for (int i=0, len=prices.length; i<len; i++){
            List<Integer> list = new ArrayList<>();
            for (int j=i+1; j<len; j++){
                list.add(prices[j] - prices[i]);
            }
            Collections.sort(list);
            if (list.size() > 0){
                resultList.add(list.get(list.size() - 1));
            }
        }
        Collections.sort(resultList);
        if (resultList.size() == 0 || resultList.get(resultList.size() - 1) < 0){
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
            return 0;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        return resultList.get(resultList.size() - 1);
    }

    public static int maxProfitDP(int[] prices){
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
