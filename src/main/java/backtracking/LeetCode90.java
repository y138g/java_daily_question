package main.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class LeetCode90 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    /**
     * 子集 II 实现方法1：回溯 leetcode 90
     *
     * @param nums 数组
     * @return 返回的不重复子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 将当前路径添加到结果中
        result.add(new ArrayList<>(path));
        // 排序
        Arrays.sort(nums);
        // 初始化used数组，用于标记元素是否被使用
        used = new boolean[nums.length];
        // 回溯
        backtracking(nums, 0);
        // 返回结果
        return result;
    }

    /**
     * 回溯
     *
     * @param nums       数组
     * @param startIndex 起始位置
     */
    private void backtracking(int[] nums, int startIndex) {
        // 如果startIndex等于nums的长度，说明已经遍历完了，直接返回
        if (startIndex == nums.length) return;

        // 遍历数组，从startIndex开始
        IntStream.range(startIndex, nums.length)
                // 过滤掉不符合条件的元素
                .filter(i -> i <= 0 || nums[i] != nums[i - 1] || used[i - 1]).forEach(i -> {
            // 将当前元素加入路径
            path.add(nums[i]);
            // 标记当前元素已使用
            used[i] = true;
            // 将当前路径加入结果集
            result.add(new ArrayList<>(path));
            // 递归调用，从下一个位置开始
            backtracking(nums, i + 1);
            // 回溯，将当前元素从路径中移除
            path.removeLast();
            // 标记当前元素未使用
            used[i] = false;
        });
    }
}
