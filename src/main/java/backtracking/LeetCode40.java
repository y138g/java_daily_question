package main.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode40 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 标记数组
    boolean[] used;
    int sum = 0;

    /**
     * 组合总和 II 实现方法1：递归 leetcode 40
     *
     * @param candidates 候选数组
     * @param target     目标和
     * @return 结果集
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 对数组排序
        Arrays.sort(candidates);
        // 回溯
        backtracking(candidates, target, 0);
        return result;
    }

    /**
     * 递归算法
     *
     * @param candidates 候选数组
     * @param target     目标和
     * @param index      选择列表起始位置
     */
    private void backtracking(int[] candidates, int target, int index) {
        // 加入结果集
        if (sum == target) result.add(new ArrayList<>(path));
        for (int i = index; i < candidates.length; i++) {
            // 终止条件
            if (sum + candidates[i] > target) break;
            // 同层节点已经遍历过，跳过（当前节点大于零且当前节点大于上一个节点且上一个节点的标志不为为 false）
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
