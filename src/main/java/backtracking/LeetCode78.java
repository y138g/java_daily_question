package main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 子集 实现方法1：回溯 leetcode 78
     *
     * @param nums 数组
     * @return 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    /**
     * 回溯算法
     *
     * @param nums  数组
     * @param start 起始位置
     */
    private void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
