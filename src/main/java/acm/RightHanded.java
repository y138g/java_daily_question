package main.java.acm;

import java.util.Scanner;

/**
 * 右旋转字符串 实现方法1：双指针 卡码网 55
 */
public class RightHanded {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        scanner.close();
        int start = n - 1;
        char[] chars = new char[s.length()];
        for (int end = s.length() - 1; end >= s.length() - n; end--) {
            chars[start] = s.charAt(end);
            start--;
        }
        start = n;
        for (int i = 0; i < s.length() - n; i++) {
            chars[start] = s.charAt(i);
            start++;
        }
        System.out.println(new String(chars));
    }
}
