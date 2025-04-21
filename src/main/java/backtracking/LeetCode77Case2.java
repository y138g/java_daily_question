package main.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77Case2 {

    // 结果集
    List<List<Integer>> result = new ArrayList<>();
    // 路径
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 组合 实现方式1：回溯算法剪枝优化 leetcode 77
     *
     * @param n 范围 [1, n]
     * @param k 组合内元素个数
     * @return 返回组合集
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 回溯算法剪枝
     *
     * @param n          范围 [1, n]
     * @param k          组合内元素个数
     * @param startIndex 起始位置
     */
    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
