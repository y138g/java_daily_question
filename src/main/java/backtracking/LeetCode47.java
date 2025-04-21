package main.java.backtracking;

import java.util.*;

public class LeetCode47 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    /**
     * 全排序 II 实现方法1：回溯 leetcode 47
     *
     * @param nums 需要全排序的数组
     * @return 全排序结果
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 定义一个布尔数组，用于记录每个元素是否被使用过
        used = new boolean[nums.length];
        // 对数组进行排序，方便后续去重
        Arrays.sort(nums);
        // 调用回溯函数
        backtracking(nums, used);
        // 返回结果
        return result;
    }

    /**
     * 回溯函数
     *
     * @param nums 需要全排序的数组
     * @param used 记录每个元素是否被使用过的布尔数组
     */
    private void backtracking(int[] nums, boolean[] used) {
        // 如果路径长度等于数组长度，说明已经找到了一组解
        if (path.size() == nums.length) {
            // 将路径添加到结果集中
            result.add(new ArrayList<>(path));
            return;
        }
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素与前一个元素相等且前一个元素未被使用，或者当前元素已被使用，则跳过
            if ((i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) || used[i]) continue;
            // 将当前元素添加到路径中
            path.add(nums[i]);
            // 标记当前元素已被使用
            used[i] = true;
            // 递归调用回溯算法
            backtracking(nums, used);
            // 从路径中移除最后一个元素
            path.removeLast();
            // 标记当前元素未被使用
            used[i] = false;
        }
    }
}
