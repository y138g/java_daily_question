package main.java.train;

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
}
