package main.java.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode501 {

    int maxCount = 0;
    TreeNode pre;
    int count = 0;
    List<Integer> list = new ArrayList<>();

    /**
     * 二叉搜索树中的众数 实现方法1:递归 leetcode 501
     *
     * @param root 二叉树
     * @return 众数
     */
    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
//        return list.stream().mapToInt(integer -> integer).toArray(); 流式计算会更耗时，时间复杂度虽然都为o(n)，但有转换
    }

    /**
     * 递归
     *
     * @param root 二叉树
     */
    private void find(TreeNode root) {
        if (root == null) return;
        // 左子节点递归
        find(root.left);
        int rootVal = root.val;
        // 计数
        if (pre == null || pre.val != rootVal) count = 1;
        else count++;
        // 更新结果，如果某个数出现的次数比最大次数大，清楚数组并重新赋值；如果相等则加入数组
        if (count > maxCount) {
            list.clear();
            list.add(rootVal);
            maxCount = count;
        } else if (count == maxCount) list.add(rootVal);
        pre = root;
        // 右子节点递归
        find(root.right);
    }
}
