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

        int[] height1 = {4, 2, 0, 3, 2, 5};
        int[] height2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int i4 = trapCase1(height1);
        int i5 = trapCase1(height2);
        System.out.println(i4);
        System.out.println(i5);

        String s = "dvdf";
        int i6 = lengthOfLongestSubstringCase1(s);
        int i7 = lengthOfLongestSubstringCase2(s);
        System.out.println(i6);
        System.out.println(i7);

        String s1 = "abab", p = "ab";
        List<Integer> anagramsCase1 = findAnagramsCase2(s1, p);
        System.out.println(anagramsCase1);

//        nums = [1,1,1], k = 2
        int[] nums4 = {1, 2, 3};
        int[] nums5 = {3, 5, 2, -2, 4, 1};
        int k = 3;
        int i8 = subarraySumCase1(nums4, k);
        int i9 = subarraySumCase2(nums4, k);
        int i10 = subarraySumCase3(nums4, k);
        System.out.println(i8);
        System.out.println(i9);
        System.out.println(i10);

        int[] nums6 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] ints2 = maxSlidingWindowCase1(nums6, k1);
        System.out.println(Arrays.toString(ints2));

        int[] nums7 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums7));

        String s3 = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s3));
    }

    /**
     * 两数之和 实现方法1 leetcode 1
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回数组下标
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
     * 两数之和 实现方法2 leetcode 1
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回数组下标
     */
    public static int[] sumOfTwoNumbersCase2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // 如果存在 target - nums[i] 的值，则返回两个值的下标
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            // 否则，将 nums[i] 放入哈希表中
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 字母异位词分组 实现方法1 leetcode 49
     *
     * @param strs 字符串数组
     * @return 返回字母异位词分组
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
     * 最长连续序列 实现方法1 leetcode 128
     *
     * @param nums 目标数组
     * @return 返回最长连续序列长度
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
     * 最长连续序列 实现方法2 leetcode 128
     *
     * @param nums 目标数组
     * @return 返回最长连续序列长度
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
     * 移动零 实现方法1 leetcode 283
     *
     * @param nums 目标数组
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
     * 交换数组元素
     *
     * @param nums  目标数组
     * @param left  左指针
     * @param right 右指针
     */
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 移动零 实现方法2 leetcode 283
     *
     * @param nums 目标数组
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
     * 盛最多水的容器 实现方法1 leetcode 11
     *
     * @param height 目标数组
     * @return 返回最大面积
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
     * 盛最多水的容器 实现方法2 leetcode 11
     *
     * @param height 目标数组
     * @return 返回最大面积
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
     * 三数之和 实现方法1 leetcode 15
     *
     * @param nums 目标数组
     * @return 返回三数之和为0的数组
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
        // 先对数组进行排序
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0;
        // 遍历数组，从第一个开始
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
        // 去重
        HashSet<List<Integer>> hashSet = new HashSet<>(result);
        return new ArrayList<>(hashSet);
    }

    /**
     * 三数之和 实现方法2 leetcode 15
     *
     * @param nums 目标数组
     * @return 返回三数之和为0的数组
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
        // 先对数组进行排序
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0, sign = nums[0];
        // 遍历数组，从第一个开始
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
        // 去重
        HashSet<List<Integer>> hashSet = new HashSet<>(result);
        return new ArrayList<>(hashSet);
    }

    /**
     * 接雨水 实现方法1：单调栈 leetcode 42
     *
     * @param height 目标数组
     * @return 返回接雨水的面积
     */
    private static int trapCase1(int[] height) {
        // 定义一个栈
        Stack<Integer> stack = new Stack<>();
        // 初始化总面积
        int area = 0;
        // 单调递增栈，栈中存储的是下标
        for (int i = 0; i < height.length; i++) {
            // 如果栈为空，直接入栈；如果当前元素小于栈顶元素，直接入栈
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
            } else {
                // 如果当前元素大于栈顶元素，将栈顶元素弹出，并计算面积
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    Integer popIndex = stack.pop();
                    // 如果栈为空，直接继续循环
                    if (stack.isEmpty()) {
                        stack.push(i);
                        break;
                    }
                    int topIndex = stack.peek();
                    // 计算高度差值
                    int diff = Math.min(height[i], height[topIndex]) - height[popIndex];
                    // 计算宽度
                    int width = i - topIndex - 1;
                    // 计算面积
                    area += diff * width;
                    // 将当前元素入栈
                }
                stack.push(i);
            }
        }
        return area;
    }

    /**
     * 无重复字符的最长子串 实现方法1：哈希表+双指针 leetcode 3
     *
     * @param s 目标字符串
     * @return 返回最长子串长度
     */
    private static int lengthOfLongestSubstringCase1(String s) {
        char[] strArr = s.toCharArray();
        // 定义一个哈希表
        HashMap<Character, Integer> hashtable = new HashMap<>();
        // 定义一个最长子串长度
        int maxLength = 0;
        // 定义两个指针
        int left = 0, right = 0;
        // 遍历第一个指针
        for (left = 0; left < strArr.length; left++) {
            right = left;
            // 遍历第二个指针
            while (right < strArr.length) {
                if (hashtable.containsKey(strArr[right])) {
                    break;
                }
                hashtable.put(strArr[right], 1);
                right++;
            }
            maxLength = Math.max(maxLength, hashtable.size());
            hashtable.clear();
        }
        return maxLength;
    }

    /**
     * 无重复字符的最长子串 实现方法2：滑动窗口优化，本质依旧是哈希表+双指针 leetcode 3
     *
     * @param s 目标字符串
     * @return 返回最长子串长度
     */
    private static int lengthOfLongestSubstringCase2(String s) {
        char[] strArr = s.toCharArray();
        int left = 0, right = 0;
        int maxLength = 0;
        HashMap<Character, Integer> hashtable = new HashMap<>();
        for (left = 0; left < strArr.length; left++) {
            for (; right < strArr.length; right++) {
                if (hashtable.containsKey(strArr[right])) break;
                hashtable.put(strArr[right], 1);
            }
            maxLength = Math.max(maxLength, hashtable.size());
            hashtable.remove(strArr[left]);
        }
        return maxLength;
    }

    /**
     * 找到字符串中所有字母异位词 实现方法1：滑动窗口 leetcode 438
     *
     * @param s 目标字符串
     * @param p 目标字符串
     * @return 返回所有字母异位词的起始索引
     */
    private static List<Integer> findAnagramsCase1(String s, String p) {
        int[] hashtable = new int[26];
        List<Integer> result = new ArrayList<>();
        boolean sign;

        if (s.length() < p.length()) {
            return result;
        }

        for (int i = 0; i < p.length(); i++) {
            hashtable[p.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            sign = true;
            int[] record = new int[26];
            System.arraycopy(hashtable, 0, record, 0, hashtable.length);
            for (int j = i; j < i + p.length(); j++) {
                record[s.charAt(j) - 'a']--;
            }
            for (int count : record) {
                if (count != 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 找到字符串中所有字母异位词 实现方法2：滑动窗口优化 leetcode 438
     *
     * @param s 目标字符串
     * @param p 目标字符串
     * @return 返回所有字母异位词的起始索引
     */
    private static List<Integer> findAnagramsCase2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    /**
     * 和为 k 的子数组 实现方法1:双指针（暴力） leetcode 560
     *
     * @param nums 目标数组
     * @param k    目标字符串
     * @return 返回该数组中和为k的子数组个数
     */
    private static int subarraySumCase1(int[] nums, int k) {
        int result = 0;
        int right;
        int sum = 0;
        for (int left = 0; left < nums.length; left++) {
            if (nums[left] == k) {
                result++;
                continue;
            }
            right = left + 1;
            sum = nums[left];
            while (right < nums.length) {
                sum += nums[right];
                if (sum == k) {
                    result++;
                }
                right++;
            }
        }
        return result;
    }

    /**
     * 和为 k 的子数组 实现方法2:前缀和（暴力） leetcode 560
     *
     * @param nums 目标数组
     * @param k    目标字符串
     * @return 返回该数组中和为k的子数组个数
     */
    private static int subarraySumCase2(int[] nums, int k) {
        int n = nums.length;
        int[] prenums = new int[n + 1];
        prenums[0] = 0;
        for (int i = 0; i < n; i++) {
            prenums[i + 1] = nums[i] + prenums[i];
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j < n; j++) {
                if (prenums[j + 1] - prenums[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 和为 k 的子数组 实现方法3:前缀和+哈希表优化 leetcode 560
     *
     * @param nums 目标数组
     * @param k    目标字符串
     * @return 返回该数组中和为k的子数组个数
     */
    private static int subarraySumCase3(int[] nums, int k) {
        int result = 0, prenum = 0;
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        hashtable.put(0, 1);
        for (int num : nums) {
            prenum += num;
            if (hashtable.containsKey(prenum - k)) {
                result += hashtable.get(prenum - k);
            }
            hashtable.put(prenum, hashtable.getOrDefault(prenum, 0) + 1);
        }
        return result;
    }

    private static int[] maxSlidingWindowCase1(int[] nums, int k) {
        // 数组的长度
        int n = nums.length;
        // 定义一个双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            // 当队列不为空时，且当前元素大于等于队尾元素时，队尾元素出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 当前元素入队
            deque.offerLast(i);
        }
        // 定义一个数组，用于存储每个窗口的最大值
        int[] ans = new int[n - k + 1];
        // 第一个窗口的最大值
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 当队列不为空时，且当前元素大于等于队尾元素时，队尾元素出队
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 当前元素入队
            deque.offerLast(i);
            // 当队首元素的下标小于等于 i - k 时，队首元素出队
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 当前窗口的最大值
            ans[i - k + 1] = nums[deque.peek()];
        }
        return ans;
    }

    /**
     * 分发饼干 实现方法1：贪心算法 leetcode 455
     *
     * @param g 孩子数组
     * @param s 饼干数组
     * @return 返回满足的孩子个数
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0, count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    /**
     * 摆动序列 实现方法1：贪心算法 leetcode 376
     *
     * @param nums 目标数组
     * @return 返回摆动序列的长度
     */
    public int wiggleMaxLength(int[] nums) {
        // 如果数组长度小于等于1，直接返回数组长度
        if (nums.length <= 1) return nums.length;
        // 当前差值
        int curDiff = 0;
        // 前一个差值
        int preDiff = 0;
        // 计数器，记录峰值个数
        int count = 1;
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 计算当前差值
            curDiff = nums[i] - nums[i - 1];
            // 如果当前差值和前一个差值符号相反，则计数器加1，并更新前一个差值
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        // 返回峰值个数
        return count;
    }

    /**
     * 最大子数组和 实现方法1：贪心算法 leetcode 53
     *
     * @param nums 目标数组
     * @return 返回最大子数组和
     */
    public static int maxSubArray(int[] nums) {
        // 如果数组长度为1，则直接返回该元素
        if (nums.length == 1) return nums[0];
        // 初始化最大和为最小整数
        int sum = Integer.MIN_VALUE;
        // 初始化计数器为0
        int count = 0;
        // 遍历数组中的每个元素
        for (int num : nums) {
            // 将当前元素加到计数器上
            count += num;
            // 更新最大和
            sum = Math.max(sum, count);
            // 如果计数器小于0，则重置计数器为0
            if (count < 0) count = 0;
        }
        // 返回最大和
        return sum;
    }

    /**
     * 买卖股票的最佳时机 II 实现方法1：贪心算法 leetcode 122
     *
     * @param prices 股票价格数组
     * @return 返回最大利润
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        // 贪心，拿当天跟前一天对比，大于0就收集
        for (int i = 1; i < prices.length; i++) result = Math.max(prices[i] - prices[i - 1], 0);
        return result;
    }

    /**
     * 跳跃游戏 实现方法1：贪心算法 leetcode 55
     *
     * @param nums 目标数组
     * @return 返回是否可以跳到最后一个元素
     */
    public boolean canJump(int[] nums) {
        // 如果数组长度为1，则说明只有一个元素，直接返回true
        if (nums.length == 1) return true;
        // 初始化覆盖范围
        int cover = 0;
        // 遍历数组
        for (int i = 0; i <= cover; i++) {
            // 更新覆盖范围
            cover = Math.max(i + nums[i], cover);
            // 如果覆盖范围已经到达或超过数组长度减1，则说明可以跳到最后一个元素，返回true
            if (cover >= nums.length - 1) return true;
        }
        // 如果遍历完数组后，覆盖范围仍然没有到达或超过数组长度减1，则说明无法跳到最后一个元素，返回false
        return false;
    }

    /**
     * 跳跃游戏 II 实现方法1：贪心算法 leetcode 45
     *
     * @param nums 目标数组
     * @return 返回跳跃次数
     */
    public int jump(int[] nums) {
        // 判断输入数组是否为空，或者长度为0，或者长度为1，如果是，则返回0
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        // 定义跳跃次数
        int countJump = 0;
        // 定义当前覆盖范围
        int curCover = 0;
        // 定义最大覆盖范围
        int maxCover = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 更新最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 如果最大覆盖范围已经覆盖了数组的最后一个元素，则跳出循环
            if (maxCover >= nums.length - 1) {
                countJump++;
                break;
            }
            // 如果当前覆盖范围等于最大覆盖范围，则更新当前覆盖范围，并增加跳跃次数
            if (i == curCover) {
                curCover = maxCover;
                countJump++;
            }
        }
        // 返回跳跃次数
        return countJump;
    }

    /**
     * K 次取反后最大化的数组和 实现方法1：贪心算法 leetcode 1005
     *
     * @param nums 目标数组
     * @param k    取反次数
     * @return 返回最大化的数组和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = 0;
        Arrays.sort(nums);
        if (k > nums.length) {
            n = k - nums.length;
            k = nums.length;
        }
        for (int i = 0; i < k; i++) {
            if (nums[i] == 0) break;
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                continue;
            }
            if (nums[i] > 0) {
                Arrays.sort(nums);
                if ((k - i) % 2 == 0) break;
                nums[0] = -nums[0];
            }
        }
        if (n % 2 != 0) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

    /**
     * 加油站 实现方法1：贪心算法 leetcode 134
     *
     * @param gas  加油站数组
     * @param cost 耗油站数组
     * @return 返回可以跑完一圈的起点
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 初始化总油量和最小油量
        int sum = 0;
        int min = 0;
        // 遍历加油站数组
        for (int i = 0; i < gas.length; i++) {
            // 计算当前油量和耗油量的差值，并累加到总油量中
            sum += gas[i] - cost[i];
            // 更新最小油量
            min = Math.min(sum, min);
        }
        // 如果总油量小于0，说明无法跑完一圈，返回-1
        if (sum < 0) return -1;
        // 如果最小油量大于等于0，说明起点为0
        if (min >= 0) return 0;
        // 从后往前遍历加油站数组
        for (int i = gas.length - 1; i >= 0; i--) {
            // 更新最小油量
            min += gas[i] - cost[i];
            // 如果最小油量大于等于0，说明起点为当前索引
            if (min >= 0) return i;
        }
        // 如果没有找到起点，返回-1
        return -1;
    }

    /**
     * 分发糖果 实现方法1：贪心算法 leetcode 135
     *
     * @param ratings 评分数组
     * @return 返回每个孩子分到的糖果数之和
     */
    public int candy(int[] ratings) {
        // 创建一个数组，用于存储每个孩子分到的糖果数，初始值为1
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // 从左到右遍历数组，如果当前孩子的评分比前一个孩子高，则当前孩子分到的糖果数为前一个孩子分到的糖果数加1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // 从右到左遍历数组，如果当前孩子的评分比后一个孩子高，
        // 则当前孩子分到的糖果数为前一个孩子分到的糖果数和后一个孩子分到的糖果数加1中的较大值
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // 计算所有孩子分到的糖果数之和
        int sum = 0;
        for (int candy : candies) sum += candy;
        // 返回所有孩子分到的糖果数之和
        return sum;
    }

    /**
     * 柠檬水找零 实现方法1：贪心算法 leetcode 860
     *
     * @param bills 账单数组
     * @return 返回是否可以完成找零
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten == 0 && five >= 3) five -= 3;
                else return false;
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }

    /**
     * 根据身高重建队列 实现方法1：贪心算法 leetcode 406
     *
     * @param people 身高和位置数组
     * @return 返回重建后的队列
     */
    public int[][] reconstructQueue(int[][] people) {
        // 先排序身高，大到小
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        // 再根据k值插入
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 用最少数量的箭引爆气球 实现方法1：贪心算法 leetcode 452
     *
     * @param points 气球队列
     * @return 返回最少的箭数
     */
    public int findMinArrowShots(int[][] points) {
        // 对points数组按照每个子数组的第一个元素进行排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        // 初始化箭的数量为1
        int res = 1;
        // 遍历points数组
        for (int i = 1; i < points.length; i++) {
            // 如果当前子数组的第一个元素大于前一个子数组的第二个元素，说明需要增加一支箭
            if (points[i][0] > points[i - 1][1]) res++;
                // 否则，更新当前子数组的第二个元素为前一个子数组的第二个元素和当前子数组的第二个元素的最小值
            else points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        }
        // 返回箭的数量
        return res;
    }

    /**
     * 无重叠区间 实现方法1：贪心算法 leetcode 435
     *
     * @param intervals 区间数组
     * @return 返回删除的区间数
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 对数组进行排序，按照每个子数组的第一个元素进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 初始化结果为1
        int res = 1;
        // 遍历数组
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前子数组的第一个元素小于前一个子数组的第二个元素，说明有重叠
            if (intervals[i][0] < intervals[i - 1][1]) {
                // 更新当前子数组的第二个元素为前一个子数组的第二个元素和当前子数组的第二个元素的最小值
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                // 继续下一次循环
                continue;
            }
            // 如果没有重叠，结果加1
            res++;
        }
        // 返回结果
        return intervals.length - res;
    }

    /**
     * 划分字母区间 实现方法1：贪心算法 leetcode 763
     *
     * @param s 字符串
     * @return 返回每个分区的长度
     */
    public static List<Integer> partitionLabels(String s) {
        // 创建一个链表，用于存储每个分区的长度
        List<Integer> list = new LinkedList<>();
        // 创建一个数组，用于存储每个字符最后出现的位置
        int[] edge = new int[26];
        // 将字符串转换为字符数组
        char[] chars = s.toCharArray();
        // 遍历字符数组，记录每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) edge[chars[i] - 'a'] = i;
        // 初始化索引和最后一个分区的结束位置
        int idx = 0;
        int last = -1;
        // 遍历字符数组，计算每个分区的长度
        for (int i = 0; i < s.length(); i++) {
            // 更新索引，记录当前字符最后出现的位置
            idx = Math.max(idx, edge[chars[i] - 'a']);
            // 如果当前索引等于最后一个分区的结束位置，则将当前分区的长度添加到链表中
            if (i == idx) {
                list.add(i - last);
                // 更新最后一个分区的结束位置
                last = i;
            }
        }
        // 返回链表
        return list;
    }
}

