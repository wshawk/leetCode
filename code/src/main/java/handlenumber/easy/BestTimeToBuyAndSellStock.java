package handlenumber.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package handlenumber.easy
 * @desc
 * @date 2022/7/29
 */
public class BestTimeToBuyAndSellStock {
    /**
     * 暴力破解
     * @param prices
     * @return
     */
    public int maxProfitBad(int[] prices) {
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++){
            int buyPrice = prices[i];
            for (int j=i+1; j<prices.length; j++){
                maxProfit = Math.max(prices[j] - buyPrice, maxProfit);
            }
        }

        return maxProfit;
    }


    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1){
            return maxProfit;
        }

        int minPrice = prices[0];
        for (int i=1; i<prices.length; i++){
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
