package main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    List<String> result = new ArrayList<>();

    /**
     * 电话号码的字母组合 实现方法1：回溯 leetcode 17
     *
     * @param digits 输入的数字
     * @return 可能的字母组合
     */
    public List<String> letterCombinations(String digits) {
        // 如果输入为空，则返回结果
        if (digits.isEmpty()) return result;
        // 数字键映射字母
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 回溯
        backtracking(digits, 0, letter);
        return result;
    }

    StringBuilder temp = new StringBuilder();

    /**
     * 回溯
     *
     * @param digits 输入的数字
     * @param num    当前处理的数字（输入的数字）下标
     * @param letter 数字键映射字母
     */
    private void backtracking(String digits, int num, String[] letter) {
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // 取出当前处理数字对应的字母
        String str = letter[digits.charAt(num) - '0'];
        // 遍历取出的字母
        for (int i = 0; i < str.length(); i++) {
            // 添加字母
            temp.append(str.charAt(i));
            // 递归，处理下一层
            backtracking(digits, num + 1, letter);
            // 剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
