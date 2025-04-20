package main.java.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode491 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 递增子序列 实现方法1：回溯 leetcode 491
     *
     * @param nums 数组
     * @return 结果集
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 如果数组长度小于2，则直接返回结果
        if (nums.length < 2) return result;
        // 调用回溯函数，从第一个元素开始
        backtracking(nums, 0);
        // 返回结果
        return result;
    }

    /**
     * 回溯函数
     *
     * @param nums       数组
     * @param startIndex 起始位置
     */
    private void backtracking(int[] nums, int startIndex) {
        // 如果路径长度大于等于2，则将路径添加到结果集中
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        // 使用HashSet来存储已经访问过的元素
        HashSet<Integer> set = new HashSet<>();
        // 从startIndex开始遍历数组
        for (int i = startIndex; i < nums.length; i++) {
            // 如果当前元素小于路径中的最后一个元素，或者已经访问过，则跳过
            if ((!path.isEmpty() && nums[i] < path.getLast()) || set.contains(nums[i])) continue;
            // 将当前元素添加到HashSet中
            set.add(nums[i]);
            // 将当前元素添加到路径中
            path.add(nums[i]);
            // 递归调用backtracking函数，从下一个元素开始
            backtracking(nums, i + 1);
            // 将路径中的最后一个元素移除
            path.removeLast();
        }
    }
}
