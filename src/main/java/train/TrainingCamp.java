package main.java.train;

import static java.lang.Integer.MAX_VALUE;

public class TrainingCamp {

    /**
     * 二分查找 实现方法1：左闭右闭 leetcode 704
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回目标值的下标
     */
    public int searchCase1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 左指针小于右指针
        while (left < right) {
            // 计算中间指针 （右 - 左）/2 + 左 防止溢出
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 移除元素 实现方法1：快慢指针 leetcode 27
     *
     * @param nums 目标数组
     * @param val  目标值
     * @return 返回移除元素后的数组长度
     */
    public int removeElementCase1(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 有序数组的平方 实现方法1：双指针 leetcode 977
     *
     * @param nums 目标数组
     * @return 返回平方后的数组
     */
    public int[] sortedSquaresCase1(int[] nums) {
        int left = 0, right = nums.length - 1, n = nums.length - 1, leftNum, rightNum;
        int[] result = new int[nums.length];
        while (left <= right) {
            leftNum = nums[left] * nums[left];
            rightNum = nums[right] * nums[right];
            if (leftNum <= rightNum) {
                result[n] = rightNum;
                right--;
            }
            if (leftNum > rightNum) {
                result[n] = leftNum;
                left++;
            }
            n--;
        }
        return result;
    }

    /**
     * 长度最小的子数组 实现方法1：滑动窗口 leetcode 209
     *
     * @param target 目标值
     * @param nums   目标数组
     * @return 返回最小子数组长度
     */
    public static int minSubArrayLenCase1(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minSub = MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                sum -= nums[start];
                minSub = Math.min(end - start + 1, minSub);
                start++;
            }
        }
        if (minSub == MAX_VALUE) {
            return 0;
        }
        return minSub;
    }

    /**
     * 螺旋矩阵II 实现方法1：模拟 leetcode 59
     *
     * @param n 矩阵的大小
     * @return 返回螺旋矩阵
     */
    public int[][] generateMatrixCase1(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1; // 记录当前的圈数
        int i, j; // j 代表列, i 代表行;

        while (loop <= n / 2) {

            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列
            // 左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }
}
