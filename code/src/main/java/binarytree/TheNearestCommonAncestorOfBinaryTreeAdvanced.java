package binarytree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author hawk
 * @package binarytree
 * @desc 在二叉树中找到两个节点的最近公共祖先（进阶）
 *
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

/*
8 1
1 2 3
2 4 5
4 0 0
5 0 0
3 6 7
6 0 0
7 8 0
8 0 0
4
4 5
5 2
6 8
5 8
 */
public class TheNearestCommonAncestorOfBinaryTreeAdvanced {

    public static class Node{
        int val;
        Node left;
        Node right;
        Node parent;
        int level;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
            parent = null;
            level = -1;
        }
    }

    public static int solution(Node[] nodes, Node node1, Node node2) {
        while(node1 != node2) {
            if(node1.level < node2.level) {
                node2 = node2.parent;
            } else if(node1.level > node2.level) {
                node1 = node1.parent;
            } else {
                node1 = node1.parent;
                node2 = node2.parent;
            }
        }
        return node1.val;
    }

    public static void getLevel(Node[] nodes) {
        for(int i = 1; i < nodes.length; i++) {
            if(nodes[i].level != -1) {
                continue;
            }
            helper(nodes[i]);
        }
    }

    public static int helper(Node node) {
        if(node.parent == null) {
            return 0;
        }
        if(node.level != -1) {
            return node.level;
        }

        node.level = 1 + helper(node.parent);

        return node.level;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int rootVal = Integer.parseInt(strs[1]);

        Node[] nodes = new Node[n + 1];
        for(int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            int f = Integer.parseInt(strs[0]);
            int l = Integer.parseInt(strs[1]);
            int r = Integer.parseInt(strs[2]);

            if(nodes[f] == null) {
                nodes[f] = new Node(f);
            }
            if(nodes[l] == null) {
                nodes[l] = new Node(l);
            }
            if(nodes[r] == null) {
                nodes[r] = new Node(r);
            }

            nodes[f].left = nodes[l];
            nodes[f].right = nodes[r];

            nodes[l].parent = nodes[f];
            nodes[r].parent = nodes[f];
        }

        getLevel(nodes);

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(bf.readLine());
        while(q-- > 0) {
            strs = bf.readLine().split(" ");
            int node1 = Integer.parseInt(strs[0]);
            int node2 = Integer.parseInt(strs[1]);

            sb.append(solution(nodes, nodes[node1], nodes[node2]));
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
    // public static void main(String[] args) throws Exception{
    //     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    //     String[] strs = bf.readLine().split(" ");
    //     int n = Integer.parseInt(strs[0]);
    //     int rootVal = Integer.parseInt(strs[1]);
    //
    //     Node[] nodes = new Node[n + 1];
    //     for(int i = 0; i < n; i++) {
    //         strs = bf.readLine().split(" ");
    //         int f = Integer.parseInt(strs[0]);
    //         int l = Integer.parseInt(strs[1]);
    //         int r = Integer.parseInt(strs[2]);
    //
    //         if(nodes[f] == null) {
    //             nodes[f] = new Node(f);
    //         }
    //         if(nodes[l] == null) {
    //             nodes[l] = new Node(l);
    //         }
    //         if(nodes[r] == null) {
    //             nodes[r] = new Node(r);
    //         }
    //
    //         nodes[f].left = nodes[l];
    //         nodes[f].right = nodes[r];
    //
    //         nodes[l].parent = nodes[f];
    //         nodes[r].parent = nodes[f];
    //     }
    //
    //     getLevel(nodes);
    //
    //     StringBuilder sb = new StringBuilder();
    //     int q = Integer.parseInt(bf.readLine());
    //     while(q-- > 0) {
    //         strs = bf.readLine().split(" ");
    //         int node1 = Integer.parseInt(strs[0]);
    //         int node2 = Integer.parseInt(strs[1]);
    //
    //         sb.append(solution(nodes, nodes[node1], nodes[node2]));
    //         sb.append("\n");
    //     }
    //     System.out.println(sb.toString().trim());
    // }

}
