package main.java.leetcode;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] ints = sumOfTwoNumbersCase1(nums, target);
        int[] ints1 = sumOfTwoNumbersCase2(nums, target);
        System.out.println(ints[0] + "," + ints[1]);
        System.out.println(ints1[0] + "," + ints1[1]);

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = LetterAnagramGroupingCase1(strs);
        System.out.println(lists);

        int[] nums1 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int i = longestConsecutiveCase1(nums1);
        int i1 = longestConsecutiveCase2(nums1);
        System.out.println(i);
        System.out.println(i1);

        int[] nums2 = {0, 1, 0, 3, 12};
        int[] nums3 = {0, 1, 0, 3, 12};
        moveZeroesCase1(nums2);
        moveZeroesCase2(nums3);
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));

        int[] height = {1, 2, 3, 4, 5, 25, 24, 3, 4};
        int i2 = maxAreaCase1(height);
        int i3 = maxAreaCase2(height);
        System.out.println(i2);
        System.out.println(i3);

        int[] num4 = {-2, 0, 1, 1, 2};
        int[] num5 = {0, 0, 0, 0};
        List<List<Integer>> lists1 = threeSumCase2(num4);
        List<List<Integer>> lists2 = threeSumCase2(num5);
        System.out.println(lists1);
        System.out.println(lists2);
    }

    /**
     * ����֮�� ʵ�ַ���1 leetcode 1
     *
     * @param nums   Ŀ������
     * @param target Ŀ��ֵ
     * @return ���������±�
     */
    public static int[] sumOfTwoNumbersCase1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * ����֮�� ʵ�ַ���2 leetcode 1
     *
     * @param nums   Ŀ������
     * @param target Ŀ��ֵ
     * @return ���������±�
     */
    public static int[] sumOfTwoNumbersCase2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // ������� target - nums[i] ��ֵ���򷵻�����ֵ���±�
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // ���򣬽� nums[i] �����ϣ����
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * ��ĸ��λ�ʷ��� ʵ�ַ���1 leetcode 49
     *
     * @param strs �ַ�������
     * @return ������ĸ��λ�ʷ���
     */
    public static List<List<String>> LetterAnagramGroupingCase1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * ��������� ʵ�ַ���1 leetcode 128
     *
     * @param nums Ŀ������
     * @return ������������г���
     */
    private static int longestConsecutiveCase1(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 1;
        Integer startNum = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (startNum == null) {
                startNum = entry.getKey();
                continue;
            }
            if (startNum + 1 == entry.getKey()) {
                max++;
                startNum = startNum + 1;
            } else {
                list.add(max);
                max = 1;
                startNum = entry.getKey();
            }
        }
        list.add(max);
        list.sort(Collections.reverseOrder());
        return list.get(0);
    }

    /**
     * ��������� ʵ�ַ���2 leetcode 128
     *
     * @param nums Ŀ������
     * @return ������������г���
     */
    private static int longestConsecutiveCase2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    /**
     * �ƶ��� ʵ�ַ���1 leetcode 283
     *
     * @param nums Ŀ������
     */
    private static void moveZeroesCase1(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    /**
     * ��������Ԫ��
     *
     * @param nums  Ŀ������
     * @param left  ��ָ��
     * @param right ��ָ��
     */
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * �ƶ��� ʵ�ַ���2 leetcode 283
     *
     * @param nums Ŀ������
     */
    private static void moveZeroesCase2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
            i++;
        }
        while (left < n) {
            nums[left++] = 0;
        }
    }

    /**
     * ʢ���ˮ������ ʵ�ַ���1 leetcode 11
     *
     * @param height Ŀ������
     * @return ����������
     */
    private static int maxAreaCase1(int[] height) {
        int left = 0, right = height.length - 1;
        List<Integer> arrayList = new ArrayList<>();
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
            arrayList.add(area);
        }
        arrayList.sort(Collections.reverseOrder());
        return arrayList.get(0);
    }

    /**
     * ʢ���ˮ������ ʵ�ַ���2 leetcode 11
     *
     * @param height Ŀ������
     * @return ����������
     */
    private static int maxAreaCase2(int[] height) {
        int left = 0, right = height.length - 1;
        int heightLeft = 0;
        int heightRight = 0;
        int maxArea = 0;
        while (left < right) {
            heightLeft = height[left];
            heightRight = height[right];
            int area = Math.min(heightLeft, heightRight) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[right] > height[left]) {
                do left++; while (left < right && height[left] < heightLeft);
            } else {
                do right--; while (left < right && height[right] < heightRight);
            }
        }
        return maxArea;
    }

    /**
     * ����֮�� ʵ�ַ���1 leetcode 15
     *
     * @param nums Ŀ������
     * @return ��������֮��Ϊ0������
     */
    private static List<List<Integer>> threeSumCase1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < 2) {
            Integer next = set.iterator().next();
            List<List<Integer>> result = new ArrayList<>();
            if (next == 0) {
                result.add(Arrays.asList(0, 0, 0));
            }
            return result;
        }
        // �ȶ������������
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0;
        // �������飬�ӵ�һ����ʼ
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> listSort = new ArrayList<>();
                    listSort.add(nums[i]);
                    listSort.add(nums[left]);
                    listSort.add(nums[right]);
                    listSort.sort(Collections.reverseOrder());
                    result.add(listSort);
                    right--;
                }
                if (sum > 0) {
                    right--;
                    if (nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                if (sum < 0) {
                    left++;
                    if (nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        // ȥ��
        HashSet<List<Integer>> hashSet = new HashSet<>(result);
        return new ArrayList<>(hashSet);
    }

    /**
     * ����֮�� ʵ�ַ���2 leetcode 15
     *
     * @param nums Ŀ������
     * @return ��������֮��Ϊ0������
     */
    private static List<List<Integer>> threeSumCase2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        if (set.size() < 2) {
            Integer next = set.iterator().next();
            List<List<Integer>> result = new ArrayList<>();
            if (next == 0) result.add(Arrays.asList(0, 0, 0));
            return result;
        }
        // �ȶ������������
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0, sign = nums[0];
        // �������飬�ӵ�һ����ʼ
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && sign == nums[i]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> listSort = new ArrayList<>();
                    listSort.add(nums[i]);
                    listSort.add(nums[left]);
                    listSort.add(nums[right]);
                    listSort.sort(Collections.reverseOrder());
                    result.add(listSort);
                    right--;
                }
                if (sum > 0) {
                    right--;
                    if (nums[right] == nums[right + 1]) right--;
                }
                if (sum < 0) {
                    left++;
                    if (nums[left] == nums[left - 1]) left++;
                }
            }
        }
        // ȥ��
        HashSet<List<Integer>> hashSet = new HashSet<>(result);
        return new ArrayList<>(hashSet);
    }
}

