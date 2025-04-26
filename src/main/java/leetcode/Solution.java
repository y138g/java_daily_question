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

    /**
     * ����ˮ ʵ�ַ���1������ջ leetcode 42
     *
     * @param height Ŀ������
     * @return ���ؽ���ˮ�����
     */
    private static int trapCase1(int[] height) {
        // ����һ��ջ
        Stack<Integer> stack = new Stack<>();
        // ��ʼ�������
        int area = 0;
        // ��������ջ��ջ�д洢�����±�
        for (int i = 0; i < height.length; i++) {
            // ���ջΪ�գ�ֱ����ջ�������ǰԪ��С��ջ��Ԫ�أ�ֱ����ջ
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
            } else {
                // �����ǰԪ�ش���ջ��Ԫ�أ���ջ��Ԫ�ص��������������
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    Integer popIndex = stack.pop();
                    // ���ջΪ�գ�ֱ�Ӽ���ѭ��
                    if (stack.isEmpty()) {
                        stack.push(i);
                        break;
                    }
                    int topIndex = stack.peek();
                    // ����߶Ȳ�ֵ
                    int diff = Math.min(height[i], height[topIndex]) - height[popIndex];
                    // ������
                    int width = i - topIndex - 1;
                    // �������
                    area += diff * width;
                    // ����ǰԪ����ջ
                }
                stack.push(i);
            }
        }
        return area;
    }

    /**
     * ���ظ��ַ�����Ӵ� ʵ�ַ���1����ϣ��+˫ָ�� leetcode 3
     *
     * @param s Ŀ���ַ���
     * @return ������Ӵ�����
     */
    private static int lengthOfLongestSubstringCase1(String s) {
        char[] strArr = s.toCharArray();
        // ����һ����ϣ��
        HashMap<Character, Integer> hashtable = new HashMap<>();
        // ����һ����Ӵ�����
        int maxLength = 0;
        // ��������ָ��
        int left = 0, right = 0;
        // ������һ��ָ��
        for (left = 0; left < strArr.length; left++) {
            right = left;
            // �����ڶ���ָ��
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
     * ���ظ��ַ�����Ӵ� ʵ�ַ���2�����������Ż������������ǹ�ϣ��+˫ָ�� leetcode 3
     *
     * @param s Ŀ���ַ���
     * @return ������Ӵ�����
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
     * �ҵ��ַ�����������ĸ��λ�� ʵ�ַ���1���������� leetcode 438
     *
     * @param s Ŀ���ַ���
     * @param p Ŀ���ַ���
     * @return ����������ĸ��λ�ʵ���ʼ����
     */
    private static List<Integer> findAnagramsCase1(String s, String p) {
        int[] hashtable = new int[26];
        List<Integer> result = new ArrayList<>();
        boolean sign;

        if (s.length() < p.length()) {
            return result;
        }

        for (int i = 0; i < p.length(); i++) {
            hashtable[p.charAt(i) - 'a']++;     // ������Ҫ��ס�ַ�a��ASCII��ֻҪ���һ�������ֵ�Ϳ�����
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
     * �ҵ��ַ�����������ĸ��λ�� ʵ�ַ���2�����������Ż� leetcode 438
     *
     * @param s Ŀ���ַ���
     * @param p Ŀ���ַ���
     * @return ����������ĸ��λ�ʵ���ʼ����
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
     * ��Ϊ k �������� ʵ�ַ���1:˫ָ�루������ leetcode 560
     *
     * @param nums Ŀ������
     * @param k    Ŀ���ַ���
     * @return ���ظ������к�Ϊk�����������
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
     * ��Ϊ k �������� ʵ�ַ���2:ǰ׺�ͣ������� leetcode 560
     *
     * @param nums Ŀ������
     * @param k    Ŀ���ַ���
     * @return ���ظ������к�Ϊk�����������
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
     * ��Ϊ k �������� ʵ�ַ���3:ǰ׺��+��ϣ���Ż� leetcode 560
     *
     * @param nums Ŀ������
     * @param k    Ŀ���ַ���
     * @return ���ظ������к�Ϊk�����������
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
        // ����ĳ���
        int n = nums.length;
        // ����һ��˫�˶���
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            // �����в�Ϊ��ʱ���ҵ�ǰԪ�ش��ڵ��ڶ�βԪ��ʱ����βԪ�س���
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // ��ǰԪ�����
            deque.offerLast(i);
        }
        // ����һ�����飬���ڴ洢ÿ�����ڵ����ֵ
        int[] ans = new int[n - k + 1];
        // ��һ�����ڵ����ֵ
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // �����в�Ϊ��ʱ���ҵ�ǰԪ�ش��ڵ��ڶ�βԪ��ʱ����βԪ�س���
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // ��ǰԪ�����
            deque.offerLast(i);
            // ������Ԫ�ص��±�С�ڵ��� i - k ʱ������Ԫ�س���
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // ��ǰ���ڵ����ֵ
            ans[i - k + 1] = nums[deque.peek()];
        }
        return ans;
    }

    /**
     * �ַ����� ʵ�ַ���1��̰���㷨 leetcode 455
     *
     * @param g ��������
     * @param s ��������
     * @return ��������ĺ��Ӹ���
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
     * �ڶ����� ʵ�ַ���1��̰���㷨 leetcode 376
     *
     * @param nums Ŀ������
     * @return ���ذڶ����еĳ���
     */
    public int wiggleMaxLength(int[] nums) {
        // ������鳤��С�ڵ���1��ֱ�ӷ������鳤��
        if (nums.length <= 1) return nums.length;
        // ��ǰ��ֵ
        int curDiff = 0;
        // ǰһ����ֵ
        int preDiff = 0;
        // ����������¼��ֵ����
        int count = 1;
        // ��������
        for (int i = 1; i < nums.length; i++) {
            // ���㵱ǰ��ֵ
            curDiff = nums[i] - nums[i - 1];
            // �����ǰ��ֵ��ǰһ����ֵ�����෴�����������1��������ǰһ����ֵ
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        // ���ط�ֵ����
        return count;
    }

    /**
     * ���������� ʵ�ַ���1��̰���㷨 leetcode 53
     *
     * @param nums Ŀ������
     * @return ��������������
     */
    public static int maxSubArray(int[] nums) {
        // ������鳤��Ϊ1����ֱ�ӷ��ظ�Ԫ��
        if (nums.length == 1) return nums[0];
        // ��ʼ������Ϊ��С����
        int sum = Integer.MIN_VALUE;
        // ��ʼ��������Ϊ0
        int count = 0;
        // ���������е�ÿ��Ԫ��
        for (int num : nums) {
            // ����ǰԪ�ؼӵ���������
            count += num;
            // ��������
            sum = Math.max(sum, count);
            // ���������С��0�������ü�����Ϊ0
            if (count < 0) count = 0;
        }
        // ��������
        return sum;
    }

    /**
     * ������Ʊ�����ʱ�� II ʵ�ַ���1��̰���㷨 leetcode 122
     *
     * @param prices ��Ʊ�۸�����
     * @return �����������
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        // ̰�ģ��õ����ǰһ��Աȣ�����0���ռ�
        for (int i = 1; i < prices.length; i++) result = Math.max(prices[i] - prices[i - 1], 0);
        return result;
    }

    /**
     * ��Ծ��Ϸ ʵ�ַ���1��̰���㷨 leetcode 55
     *
     * @param nums Ŀ������
     * @return �����Ƿ�����������һ��Ԫ��
     */
    public boolean canJump(int[] nums) {
        // ������鳤��Ϊ1����˵��ֻ��һ��Ԫ�أ�ֱ�ӷ���true
        if (nums.length == 1) return true;
        // ��ʼ�����Ƿ�Χ
        int cover = 0;
        // ��������
        for (int i = 0; i <= cover; i++) {
            // ���¸��Ƿ�Χ
            cover = Math.max(i + nums[i], cover);
            // ������Ƿ�Χ�Ѿ�����򳬹����鳤�ȼ�1����˵�������������һ��Ԫ�أ�����true
            if (cover >= nums.length - 1) return true;
        }
        // �������������󣬸��Ƿ�Χ��Ȼû�е���򳬹����鳤�ȼ�1����˵���޷��������һ��Ԫ�أ�����false
        return false;
    }

    /**
     * ��Ծ��Ϸ II ʵ�ַ���1��̰���㷨 leetcode 45
     *
     * @param nums Ŀ������
     * @return ������Ծ����
     */
    public int jump(int[] nums) {
        // �ж����������Ƿ�Ϊ�գ����߳���Ϊ0�����߳���Ϊ1������ǣ��򷵻�0
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        // ������Ծ����
        int countJump = 0;
        // ���嵱ǰ���Ƿ�Χ
        int curCover = 0;
        // ������󸲸Ƿ�Χ
        int maxCover = 0;
        // ��������
        for (int i = 0; i < nums.length; i++) {
            // ������󸲸Ƿ�Χ
            maxCover = Math.max(maxCover, i + nums[i]);
            // �����󸲸Ƿ�Χ�Ѿ���������������һ��Ԫ�أ�������ѭ��
            if (maxCover >= nums.length - 1) {
                countJump++;
                break;
            }
            // �����ǰ���Ƿ�Χ������󸲸Ƿ�Χ������µ�ǰ���Ƿ�Χ����������Ծ����
            if (i == curCover) {
                curCover = maxCover;
                countJump++;
            }
        }
        // ������Ծ����
        return countJump;
    }

    /**
     * K ��ȡ������󻯵������ ʵ�ַ���1��̰���㷨 leetcode 1005
     *
     * @param nums Ŀ������
     * @param k    ȡ������
     * @return ������󻯵������
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
     * ����վ ʵ�ַ���1��̰���㷨 leetcode 134
     *
     * @param gas  ����վ����
     * @param cost ����վ����
     * @return ���ؿ�������һȦ�����
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // ��ʼ������������С����
        int sum = 0;
        int min = 0;
        // ��������վ����
        for (int i = 0; i < gas.length; i++) {
            // ���㵱ǰ�����ͺ������Ĳ�ֵ�����ۼӵ���������
            sum += gas[i] - cost[i];
            // ������С����
            min = Math.min(sum, min);
        }
        // ���������С��0��˵���޷�����һȦ������-1
        if (sum < 0) return -1;
        // �����С�������ڵ���0��˵�����Ϊ0
        if (min >= 0) return 0;
        // �Ӻ���ǰ��������վ����
        for (int i = gas.length - 1; i >= 0; i--) {
            // ������С����
            min += gas[i] - cost[i];
            // �����С�������ڵ���0��˵�����Ϊ��ǰ����
            if (min >= 0) return i;
        }
        // ���û���ҵ���㣬����-1
        return -1;
    }

    /**
     * �ַ��ǹ� ʵ�ַ���1��̰���㷨 leetcode 135
     *
     * @param ratings ��������
     * @return ����ÿ�����ӷֵ����ǹ���֮��
     */
    public int candy(int[] ratings) {
        // ����һ�����飬���ڴ洢ÿ�����ӷֵ����ǹ�������ʼֵΪ1
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // �����ұ������飬�����ǰ���ӵ����ֱ�ǰһ�����Ӹߣ���ǰ���ӷֵ����ǹ���Ϊǰһ�����ӷֵ����ǹ�����1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // ���ҵ���������飬�����ǰ���ӵ����ֱȺ�һ�����Ӹߣ�
        // ��ǰ���ӷֵ����ǹ���Ϊǰһ�����ӷֵ����ǹ����ͺ�һ�����ӷֵ����ǹ�����1�еĽϴ�ֵ
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // �������к��ӷֵ����ǹ���֮��
        int sum = 0;
        for (int candy : candies) sum += candy;
        // �������к��ӷֵ����ǹ���֮��
        return sum;
    }

    /**
     * ����ˮ���� ʵ�ַ���1��̰���㷨 leetcode 860
     *
     * @param bills �˵�����
     * @return �����Ƿ�����������
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
     * ��������ؽ����� ʵ�ַ���1��̰���㷨 leetcode 406
     *
     * @param people ��ߺ�λ������
     * @return �����ؽ���Ķ���
     */
    public int[][] reconstructQueue(int[][] people) {
        // ��������ߣ���С
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        // �ٸ���kֵ����
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[list.size()][]);
    }

    /**
     * �����������ļ��������� ʵ�ַ���1��̰���㷨 leetcode 452
     *
     * @param points �������
     * @return �������ٵļ���
     */
    public int findMinArrowShots(int[][] points) {
        // ��points���鰴��ÿ��������ĵ�һ��Ԫ�ؽ�������
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        // ��ʼ����������Ϊ1
        int res = 1;
        // ����points����
        for (int i = 1; i < points.length; i++) {
            // �����ǰ������ĵ�һ��Ԫ�ش���ǰһ��������ĵڶ���Ԫ�أ�˵����Ҫ����һ֧��
            if (points[i][0] > points[i - 1][1]) res++;
                // ���򣬸��µ�ǰ������ĵڶ���Ԫ��Ϊǰһ��������ĵڶ���Ԫ�غ͵�ǰ������ĵڶ���Ԫ�ص���Сֵ
            else points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        }
        // ���ؼ�������
        return res;
    }

    /**
     * ���ص����� ʵ�ַ���1��̰���㷨 leetcode 435
     *
     * @param intervals ��������
     * @return ����ɾ����������
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // ������������򣬰���ÿ��������ĵ�һ��Ԫ�ؽ�������
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // ��ʼ�����Ϊ1
        int res = 1;
        // ��������
        for (int i = 1; i < intervals.length; i++) {
            // �����ǰ������ĵ�һ��Ԫ��С��ǰһ��������ĵڶ���Ԫ�أ�˵�����ص�
            if (intervals[i][0] < intervals[i - 1][1]) {
                // ���µ�ǰ������ĵڶ���Ԫ��Ϊǰһ��������ĵڶ���Ԫ�غ͵�ǰ������ĵڶ���Ԫ�ص���Сֵ
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                // ������һ��ѭ��
                continue;
            }
            // ���û���ص��������1
            res++;
        }
        // ���ؽ��
        return intervals.length - res;
    }

    /**
     * ������ĸ���� ʵ�ַ���1��̰���㷨 leetcode 763
     *
     * @param s �ַ���
     * @return ����ÿ�������ĳ���
     */
    public static List<Integer> partitionLabels(String s) {
        // ����һ���������ڴ洢ÿ�������ĳ���
        List<Integer> list = new LinkedList<>();
        // ����һ�����飬���ڴ洢ÿ���ַ������ֵ�λ��
        int[] edge = new int[26];
        // ���ַ���ת��Ϊ�ַ�����
        char[] chars = s.toCharArray();
        // �����ַ����飬��¼ÿ���ַ������ֵ�λ��
        for (int i = 0; i < s.length(); i++) edge[chars[i] - 'a'] = i;
        // ��ʼ�����������һ�������Ľ���λ��
        int idx = 0;
        int last = -1;
        // �����ַ����飬����ÿ�������ĳ���
        for (int i = 0; i < s.length(); i++) {
            // ������������¼��ǰ�ַ������ֵ�λ��
            idx = Math.max(idx, edge[chars[i] - 'a']);
            // �����ǰ�����������һ�������Ľ���λ�ã��򽫵�ǰ�����ĳ�����ӵ�������
            if (i == idx) {
                list.add(i - last);
                // �������һ�������Ľ���λ��
                last = i;
            }
        }
        // ��������
        return list;
    }
}

