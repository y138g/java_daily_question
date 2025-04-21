package main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    /**
     * 分割回文串 实现方法1：回溯 leetcode 131
     *
     * @param s 字符串
     * @return 结果集
     */
    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return result;
    }

    /**
     * 回溯算法
     *
     * @param s          字符串
     * @param startIndex 起始位置
     * @param sb         字符串拼接
     */
    public void backtracking(String s, int startIndex, StringBuilder sb) {
        // 终止条件，当起始点为字符串长度时，放入结果集
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            // 判断是否回文子串
            if (isPalindrome(sb.toString())) {
                path.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 双指针判断是否为回文子串
     *
     * @param s 切割的字符串
     * @return 是否为回文子串
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
