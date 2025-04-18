package main.java;

import main.java.backtracking.LeetCode216;
import main.java.backtracking.LeetCode77Case1;
import main.java.backtracking.LeetCode77Case2;

public class Test {


    public static void main(String[] args) {
        LeetCode77Case1 leetcode77 = new LeetCode77Case1();
        LeetCode77Case2 leetcode772 = new LeetCode77Case2();
        System.out.println(leetcode77.combine(4, 3));
        System.out.println(leetcode772.combine(4, 3));

        System.out.println("------------------");
        LeetCode216 leetcode216 = new LeetCode216();
        System.out.println(leetcode216.combinationSum3(3, 8));
    }
}
