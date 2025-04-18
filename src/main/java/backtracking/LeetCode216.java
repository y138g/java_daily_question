package main.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tree = new LinkedList<>();

    /**
     * 组合总和 III 实现方法1：回溯 leetcode 216
     *
     * @param k 组合长度
     * @param n 目标和
     * @return 返回结果集
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    /**
     * 回溯算法
     *
     * @param k         组合长度
     * @param targetNum 目标和
     * @param start     选择列表起始位置
     * @param sum       当前和
     */
    private void backtracking(int k, int targetNum, int start, int sum) {
        // 当前和大于目标和，返回
        if (sum > targetNum) return;
        // 当前组合长度等于目标组合长度，且当前和等于目标和，加入结果集并返回
        if (tree.size() == k && sum == targetNum) {
            result.add(new ArrayList<>(tree));
            return;
        }
        // 遍历选择列表，剪枝
        for (int i = start; i <= 9 - (k - tree.size()) + 1; i++) {
            tree.add(i);
            sum += i;
            backtracking(k, targetNum, i + 1, sum);
            tree.removeLast();
            sum -= i;
        }
    }
}
