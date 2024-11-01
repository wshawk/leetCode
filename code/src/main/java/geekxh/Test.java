package geekxh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hawk
 * @package geekxh
 * @desc
 * @date 2023/2/23
 */
public class Test {
    public static void main(String[] args) {
        tes(5, 3);
    }

    public static List<List<Integer>> tes(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= 0 || k > n) {
            return ans;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, ans);

        return ans;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (k == path.size()) {
            System.out.println(path);
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - k + path.size() +1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, ans);
            path.removeLast();
        }
    }


}
