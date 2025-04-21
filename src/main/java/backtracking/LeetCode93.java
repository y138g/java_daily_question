package main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    /**
     * 复原 IP 地址 实现方法1：回溯 leetcode 93
     *
     * @param s 目标字符串
     * @return 返回有效 ip 结果集
     */
    public List<String> restoreIpAddresses(String s) {
        restoreIpAddressesHandler(s, 0, 0);
        return result;
    }

    /**
     * 回溯处理函数
     *
     * @param s      目标字符串
     * @param start  当前处理字符串的起始位置
     * @param number 表示 stringbuilder 中ip段的数量
     */
    public void restoreIpAddressesHandler(String s, int start, int number) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
        if (start == s.length() || number == 4) return;

        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) break;

            stringBuilder.append(s, start, i + 1);

            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
            if (number < 3) stringBuilder.append(".");

            number++;
            restoreIpAddressesHandler(s, i + 1, number);
            number--;
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + number, i + number + 2);
        }
    }
}
