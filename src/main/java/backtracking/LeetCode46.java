package main.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 全排列 实现方法1：回溯 leetcode 46
     *
     * @param nums 数组
     * @return 全排列结果
     */
    public List<List<Integer>> permute(int[] nums) {
        // 调用回溯函数
        backtracking(nums);
        // 返回结果
        return result;
    }

    /**
     * 回溯函数
     *
     * @param nums 数组
     */
    private void backtracking(int[] nums) {
        // 如果路径长度等于数组长度，说明已经找到了一组解
        if (path.size() == nums.length) {
            // 将路径添加到结果集中
            result.add(new ArrayList<>(path));
            return;
        }
        // 遍历数组中的每一个元素
        for (int num : nums) {
            // 如果路径中已经包含了该元素，则跳过
            if (path.contains(num)) continue;
            // 将该元素添加到路径中
            path.add(num);
            // 递归调用回溯算法
            backtracking(nums);
            // 将路径中的最后一个元素移除
            path.removeLast();
        }
    }
}
