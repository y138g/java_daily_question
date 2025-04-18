package main.java;

import main.java.backtracking.*;

public class Test {


    public static void main(String[] args) {
        LeetCode77Case1 leetcode77 = new LeetCode77Case1();
        LeetCode77Case2 leetcode772 = new LeetCode77Case2();
        System.out.println(leetcode77.combine(4, 3));
        System.out.println(leetcode772.combine(4, 3));

        System.out.println("------------------");
        LeetCode216 leetcode216 = new LeetCode216();
        System.out.println(leetcode216.combinationSum3(3, 8));

        System.out.println("------------------");
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));

        System.out.println("------------------");
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
