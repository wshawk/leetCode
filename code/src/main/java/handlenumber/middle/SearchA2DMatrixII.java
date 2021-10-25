package handlenumber.middle;

/**
 * @author hawk
 * @package handlenumber.middle
 * @desc 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109<= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109<= target <= 109
 *
 * @date 2021/10/25
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 方法一：直接遍历
         */

        // for (int[] ints : matrix) {
        //     for (int anInt : ints) {
        //         if (anInt == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        /**
         * 方法二：取每行最后一个进行比较
         */
        for (int[] ints: matrix){
            if (target < ints[ints.length - 1]){
                for (int anInt : ints){
                    if (target == anInt){
                        return true;
                    }
                }
            }else if(target == ints[ints.length - 1]){
                return true;
            }
        }
        return false;
    }
}
