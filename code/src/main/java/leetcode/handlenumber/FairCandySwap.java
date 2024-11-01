package leetcode.handlenumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hawk
 * @Title: FairCandySwap
 * @Description:
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 *
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 *
 * @since 2021/02/01 0:31
 */
public class FairCandySwap {
    /**
     * 唔...
     * 我还是先刷其他的吧，太菜了！
     * TODO: 记得做这道题~
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        Map<Integer, Integer> aMap = new HashMap<>();
        int sumA=0;
        for (int i=0,len=A.length; i<len-1; i++){
            sumA+=A[i];
            aMap.put(i, A[i]);
        }
        int sumB=0;
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i=0,len=B.length; i<len-1; i++){
            sumB+=B[i];
            bMap.put(i, A[i]);
        }

        if (sumA == sumB){
            // 取相等元素的值返回即可
        }else{
            int reduce = Math.abs(sumA - sumB);
            // 找出A和B中的多个元素相加等于该差值，然后返回这些值
        }
        return null;
    }
}
