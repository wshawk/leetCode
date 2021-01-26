package binarytree;

/**
 * @author hawk
 * @package binarytree
 * @desc 在二叉树中找到两个节点的最近公共祖先（进阶）
 * 给定一棵二叉树，多次给出这棵树上的两个节点o1和o2，请对于每次询问，找到o1和o2的最近公共祖先节点。
 *
 * 输入描述：
 * 第一行输入两个整数n和root，n标识二叉树的总结点个数，root表示二叉树的根节点（约定为32位整数的最大值，Integer.MAX_VALUE 2147483647）
 * 以下n行每行三个整数，fa，lch，rch，表示fa的左儿子为lch，右儿子为rch。（如果lch为0则表示fa没有左儿子，rch同理）
 * 第n+2行输入一个整数m，表示询问的次数
 * 以下m行，每行两个节点o1和o2
 *
 * 输出描述：
 * 对于每组询问，每行输出一个整数表示答案。
 *
 * 示例1：
 *
 * 输入：
 * 8 1
 *
 * 1 2 3
 * 2 4 5
 * 4 0 0
 * 5 0 0
 * 3 6 7
 * 6 0 0
 * 7 8 0
 * 8 0 0
 *
 * 4
 * 4 5
 * 5 2
 * 6 8
 * 5 8
 * 8 1
 *
 * 输出：
 * 2
 * 1
 * 3
 * 1
 * 2147483647
 *
 * @date 2021/1/26
 */
public class TheNearestCommonAncestorOfBinaryTreeAdvanced {
}
