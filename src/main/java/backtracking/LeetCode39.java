package main.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 组合总和 实现方法1：递归 leetcode 39
     *
     * @param candidates 候选数组
     * @param target     目标和
     * @return 结果集
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    /**
     * 递归算法
     *
     * @param candidates 候选数组
     * @param target     目标和
     * @param sum        当前和
     * @param index      选择列表起始位置
     */
    private void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }
}
