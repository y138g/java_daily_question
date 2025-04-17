package main.java.train;

import main.java.tree.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;

public class TrainingCamp {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur;
        cur = head;
        for (int i = 2; i <= 4; i++) {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = newNode;
        }
        ListNode curNode = swapPairsCase2(head);
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }

        System.out.println("null");


        int n = 19;
        System.out.println(isHappy(n));

        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstructCase1(ransomNote, magazine));

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));

        System.out.println("---------------");
        String s1 = "  hello     world    ";
        System.out.println(reverseWords(s1));

        System.out.println("---------------");
        String s2 = "]";
        System.out.println(isValid(s2));

        System.out.println("---------------");
        String s3 = "abbaca";
        System.out.println(removeDuplicates(s3));

        System.out.println("---------------");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

        //root = [3,9,20,null,null,15,7]
        System.out.println("---------------");
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root2));

        System.out.println("---------------");
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(4);
        root3.right.left = new TreeNode(4);
        System.out.println(countNodes(root3));

        System.out.println("---------------");
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 6, q = 7, 预期：5
        TreeNode root4 = new TreeNode(3);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(1);
        root4.left.left = new TreeNode(6);
        root4.left.right = new TreeNode(2);
        root4.right.left = new TreeNode(0);
        root4.right.right = new TreeNode(8);
        root4.left.right.left = new TreeNode(7);
        root4.left.right.right = new TreeNode(4);
        System.out.println(lowestCommonAncestor(root4, root4.left.left, root4.left.right.left).val);

        System.out.println("---------------");
        TreeNode root5 = new TreeNode(8);
        root5.left = new TreeNode(3);
        root5.right = new TreeNode(10);
        root5.left.left = new TreeNode(1);
        root5.left.right = new TreeNode(6);
        root5.left.right.left = new TreeNode(4);
        root5.left.right.right = new TreeNode(7);
        root5.right.right = new TreeNode(14);
        root5.right.left = new TreeNode(10);
        System.out.println(lowestCommonAncestorToBalanceTree(root5, root5.left.left, root5.left.right.right).val);

        System.out.println("---------------");
        TreeNode root6 = new TreeNode(8);
        root6.left = new TreeNode(4);
        root6.right = new TreeNode(10);
        root6.left.left = new TreeNode(2);
        root6.left.right = new TreeNode(6);
        root6.left.right.left = new TreeNode(5);
        root6.left.right.right = new TreeNode(7);
        root6.left.left.left = new TreeNode(1);
        root6.left.left.right = new TreeNode(3);
        root6.right.left = new TreeNode(9);
        root6.right.right = new TreeNode(11);
        trimBST(root6, 3, 9);
    }


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

    /**
     * 移除链表元素 实现方法1：设置虚拟头节点 leetcode 203
     *
     * @param head 链表头节点
     * @param val  目标值
     * @return 返回移除元素后的链表
     */
    public ListNode removeElementsCase(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 设置当前节点
        ListNode curNode = dummyNode;

        // 遍历链表
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
                continue;
            }
            curNode = curNode.next;
        }
        return dummyNode.next;
    }

    /**
     * 反转链表 实现方法1：双指针 leetcode 206
     *
     * @param head 链表头节点
     * @return 返回反转后的链表
     */
    public ListNode reverseListCase1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 反转链表 实现方法2：递归 leetcode 206
     *
     * @param head 链表头节点
     * @return 返回反转后的链表
     */
    public ListNode reverseListCase2(ListNode head) {
        return reverse(null, head);
    }

    /**
     * 反转链表递归法
     *
     * @param prev 前一个节点
     * @param cur  当前节点
     * @return 返回反转后的链表
     */
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);
    }

    /**
     * 两两交换链表中的节点 实现方法1：循环 leetcode 24
     *
     * @param head 链表头节点
     * @return 返回交换后的链表
     */
    public ListNode swapPairsCase1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        ListNode firstNode = curNode.next;
        ListNode secondNode = curNode.next.next;
        ListNode temp = secondNode.next;

        while (true) {
            curNode.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            curNode = firstNode;
            if (curNode.next == null || curNode.next.next == null) {
                break;
            }
            firstNode = curNode.next;
            secondNode = curNode.next.next;
            temp = secondNode.next;
        }
        return dummyNode.next;
    }

    /**
     * 两两交换链表中的节点 实现方法2：递归 leetcode 24
     *
     * @param head 链表头节点
     * @return 返回交换后的链表
     */
    public static ListNode swapPairsCase2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairsCase2(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }

    /**
     * 删除链表的倒数第N个节点 实现方法1：栈 leetcode 19
     *
     * @param head 链表头节点
     * @param n    倒数第n个节点
     * @return 返回删除倒数第n个节点后的链表
     */
    public ListNode removeNthFromEndCase1(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        // 虚拟头节点的目的是防止空栈异常
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummyNode.next;
    }

    /**
     * 删除链表的倒数第N个节点 实现方法2：双指针 leetcode 19
     *
     * @param head 链表头节点
     * @param n    倒数第n个节点
     * @return 返回删除倒数第n个节点后的链表
     */
    public ListNode removeNthFromEndCase2(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 后续只需要删除 slow 的下一个节点
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    /**
     * 删除链表的倒数第N个节点 实现方法3：递归 leetcode 19
     *
     * @param head 链表头节点
     * @param n    倒数第n个节点
     * @return 返回删除倒数第n个节点后的链表
     */
    public ListNode removeNthFromEndCase3(ListNode head, int n) {
        // 创建一个新的哑节点，指向原链表头
        ListNode s = new ListNode(-1, head);
        // 递归调用remove方法，从哑节点开始进行删除操作
        remove(s, n);
        // 返回新链表的头（去掉可能的哑节点）
        return s.next;
    }

    /**
     * 递归删除倒数第n个节点
     *
     * @param p 当前节点
     * @param n 倒数第n个节点
     * @return 返回当前节点的总深度
     */
    private static int remove(ListNode p, int n) {
        // 递归结束条件：如果当前节点为空，返回0
        if (p == null) {
            return 0;
        }
        // 递归深入到下一个节点
        int net = remove(p.next, n);
        // 如果当前节点是倒数第n个节点，进行删除操作
        if (net == n) {
            p.next = p.next.next;
        }
        // 返回当前节点的总深度
        return net + 1;
    }

    /**
     * 链表相交 实现方法1：双指针 leetcode 面试题 02.07
     *
     * @param headA 链表A头节点
     * @param headB 链表B头节点
     * @return 返回相交节点
     */
    public ListNode getIntersectionNodeCase1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headA : curA.next;
            curB = curB == null ? headB : curB.next;
        }
        return curA;
    }

    /**
     * 环形链表II 实现方法1：快慢指针 leetcode 142
     *
     * @param head 链表头节点
     * @return 返回环形链表的入口节点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        do {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }

    /**
     * 有效的字母异位词 实现方法1：哈希表 leetcode 242
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 返回是否是异位词
     */
    public boolean isAnagramCase1(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        int[] record = new int[26];
        // 把 s 中的字符都记录下来
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        // 把 t 中的字符都减去
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int r : record) {
            if (r != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 两个数组的交集 实现方法1：哈希表 leetcode 349
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回交集
     */
    public int[] intersectionCase1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> reset = new HashSet<>();
        // 将 nums1 内的元素放入哈希表
        for (int i : nums1) {
            set.add(i);
        }
        // 在 set 哈希表中找 num2 中的元素，如果有则写入 reset 哈希表
        for (int i : nums2) {
            if (set.contains(i)) {
                reset.add(i);
            }
        }
        // reset 哈希表转为数组
        return reset.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 快乐数 实现方法1：哈希表 leetcode 202
     *
     * @param n 数字
     * @return 返回是否是快乐数
     */
    public static boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    /**
     * 获取下一个数
     *
     * @param n 数字
     * @return 返回下一个数
     */
    private static int getNextNum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }

    /**
     * 四数相加II 实现方法1：哈希表 leetcode 454
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param nums3 数组3
     * @param nums4 数组4
     * @return 返回四数相加为 0 的次数
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            for (int i : nums2) {
                map.put(k + i, map.getOrDefault(k + i, 0) + 1);
            }
        }

        for (int j : nums3)
            for (int k : nums4) {
                count += map.getOrDefault(-j - k, 0);
            }
        return count;
    }


    /**
     * 赎金信 实现方法1：哈希表 leetcode 383
     *
     * @param ransomNote 赎金信
     * @param magazine   杂志
     * @return 返回是否可以构成
     */
    public static boolean canConstructCase1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : magazine.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : ransomNote.split("")) {
            if (map.getOrDefault(str, 0) != 0) {
                map.put(str, map.getOrDefault(str, 0) - 1);
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 赎金信 实现方法2：数组 leetcode 383
     *
     * @param ransomNote 赎金信
     * @param magazine   杂志
     * @return 返回是否可以构成
     */
    public static boolean canConstructCase2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
        }
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 三数之和 实现方法1：双指针 leetcode 15
     *
     * @param nums 数组
     * @return 返回三数之和为 0 的三元组
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果第一个元素大于零，不可能凑成三元组
            if (nums[i] > 0) {
                return result;
            }
            // 三元组元素a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                // 三元组元素b去重
                if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                    continue;
                }

                int c = -nums[i] - nums[j];
                if (set.contains(c)) {
                    result.add(Arrays.asList(nums[i], nums[j], c));
                    set.remove(c); // 三元组元素c去重
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }

    /**
     * 反转字符串 实现方法1：双指针 leetcode 344
     *
     * @param s 字符串
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 反转字符串II 实现方法1：双指针 leetcode 541
     *
     * @param s 字符串
     * @param k 每隔 k 个字符反转
     * @return 返回反转后的字符串
     */
    public static String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuilder temp = new StringBuilder();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = Math.min(start + k, length);
            int secondK = Math.min(start + (2 * k), length);

            //无论start所处位置，至少会反转一次
            temp.append(s, start, firstK);
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s, firstK, secondK);
            }
            start += (2 * k);
        }
        return res.toString();
    }

    /**
     * 反转字符串中的单词 实现方法1：双指针 leetcode 151
     *
     * @param s 字符串
     * @return 返回反转后的字符串
     */
    public static String reverseWords(String s) {
        int slow = 0;
        char[] chars = s.toCharArray();
        for (int fast = 0; fast < s.length(); fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0 && chars[fast - 1] == ' ') {
                    chars[slow] = ' ';
                    slow++;
                }
                chars[slow] = chars[fast];
                slow++;
            }
        }
        chars = Arrays.copyOf(chars, slow);

        reverse(chars, 0, chars.length - 1);

        int start = 0;
        //end <= s.length() 这里的 = ，是为了让 end 永远指向单词末尾后一个位置，这样 reverse 的实参更好设置
        for (int end = 0; end <= chars.length; end++) {
            // end 每次到单词末尾后的空格或串尾,开始反转单词
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        return new String(chars);
    }

    /**
     * 反转字符串
     *
     * @param chars 字符串
     * @param left  左闭
     * @param right 右闭
     */
    private static void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            System.out.println("set a wrong right");
            return;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 有效的括号 实现方法1：栈 leetcode 20
     *
     * @param s 字符串
     * @return 返回是否有效
     */
    public static boolean isValid(String s) {
        Deque<String> stack = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                stack.push(")");
                continue;
            }
            if (ch == '[') {
                stack.push("]");
                continue;
            }
            if (ch == '{') {
                stack.push("}");
                continue;
            }
            if (stack.isEmpty()) return false;
            String pop = stack.pop();
            if (!pop.equals(String.valueOf(ch))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 删除字符串中的所有相邻重复项 实现方法1：栈 leetcode 1047
     *
     * @param s 字符串
     * @return 返回删除后的字符串
     */
    public static String removeDuplicates(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 为空直接压入栈
            if (stack.isEmpty() || !stack.peek().equals(String.valueOf(ch))) {
                stack.push(String.valueOf(ch));
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals(String.valueOf(ch))) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            sb.append(pop);
        }
        sb.reverse();
        return sb.toString();
    }

    /**
     * 逆波兰表达式求值 实现方法1：栈 leetcode 150
     *
     * @param tokens 表达式
     * @return 返回结果
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n;
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
                continue;
            }
            if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if ("/".equals(token)) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2 / pop1);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    /**
     * 二叉树的前序遍历 实现方法1：递归 leetcode 144
     *
     * @param root 二叉树
     * @return 返回前序遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 定义数组接受返回值
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    /**
     * 前序遍历递归
     *
     * @param root   二叉树中间节点
     * @param result 返回值
     */
    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    /**
     * 二叉树的后序遍历 实现方法1：递归 leetcode 145
     *
     * @param root 二叉树
     * @return 返回后序遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    /**
     * 后序遍历递归
     *
     * @param root   二叉树中间节点
     * @param result 返回值
     */
    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    /**
     * 二叉树的中序遍历 实现方法1：递归 leetcode 94
     *
     * @param root 二叉树
     * @return 返回中序遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * 中序遍历递归
     *
     * @param root   二叉树中间节点
     * @param result 返回值
     */
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    /**
     * 翻转二叉树 实现方法1：递归 leetcode 226
     *
     * @param root 二叉树
     * @return 返回翻转后的二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        invert(root);
        return root;
    }

    /**
     * 翻转二叉树
     *
     * @param root 二叉树中间节点
     */
    private void invert(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 对称二叉树 实现方法1：递归 leetcode 101
     *
     * @param root 二叉树
     * @return 返回是否对称
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetric(root.left, root.right);
    }

    /**
     * 对称二叉树递归
     *
     * @param left  左子树
     * @param right 右子树
     * @return 返回是否对称
     */
    private static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        boolean symmetric1 = symmetric(left.left, right.right);
        boolean symmetric2 = symmetric(left.right, right.left);
        return symmetric1 && symmetric2;
    }

    /**
     * 二叉树的最大深度 实现方法1：后序遍历递归 leetcode 104
     *
     * @param root 二叉树
     * @return 返回最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 二叉树的最小深度 实现方法1：后序遍历递归 leetcode 111
     *
     * @param root 二叉树
     * @return 返回最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);
    }

    /**
     * 平衡二叉树 实现方法1：后序遍历递归 leetcode 110
     *
     * @param root 二叉树
     * @return 返回是否平衡
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * 递归返回高度差
     *
     * @param root 二叉树
     * @return 返回高度差
     */
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if ((leftHeight == -1 || rightHeight == -1) || (Math.abs(leftHeight - rightHeight) > 1)) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * 二叉树的所有路径 实现方法1：前序遍历+递归+回溯 leetcode 257
     *
     * @param root 二叉树
     * @return 返回所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    /**
     * 前序遍历+递归+回溯
     *
     * @param root   二叉树中间节点
     * @param paths  路径
     * @param result 返回值
     */
    private void traversal(TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, result);
            // 回溯
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, result);
            // 回溯
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * 左叶子之和 实现方法1：前序遍历+递归 leetcode 404
     *
     * @param root 二叉树
     * @return 返回左叶子之和
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 左节点
        int leftValue = sumOfLeftLeaves(root.left);
        // 右节点
        int rightValue = sumOfLeftLeaves(root.right);
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        return midValue + leftValue + rightValue;
    }

    /**
     * 完全二叉树的节点个数 实现方法1：递归 leetcode 222
     *
     * @param root 二叉树
     * @return 返回节点个数
     */
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 最大二叉树 实现方法1：递归 leetcode 654
     *
     * @param nums 目标数组
     * @return 二叉树
     */
    public TreeNode constructMaximumBinaryTreeCase1(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    /**
     * 构造二叉树：前序遍历
     *
     * @param nums       目标数组
     * @param liftIndex  左指针
     * @param rightIndex 右指针
     * @return 二叉树
     */
    private TreeNode constructMaximumBinaryTree(int[] nums, int liftIndex, int rightIndex) {
        // 数组没有元素
        if (rightIndex - liftIndex < 1) return null;
        // 数组只有一个元素
        if (rightIndex - liftIndex == 1) return new TreeNode(nums[liftIndex]);
        int maxIndex = liftIndex;
        int maxVal = nums[maxIndex];
        for (int i = liftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(nums, liftIndex, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, rightIndex);
        return root;
    }

    /**
     * 合并二叉树 实现方法1：递归 leetcode 617
     *
     * @param root1 二叉树1
     * @param root2 二叉树2
     * @return 合并后的二叉树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 二叉搜索树中的搜索 实现方法1：递归 leetcode 700
     *
     * @param root 二叉搜索树
     * @param val  要查找的值
     * @return 查找节点的子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    /**
     * 验证二叉搜索树 实现方法1：中序遍历 leetcode 98
     *
     * @param root 二叉树
     * @return 是否是二叉搜索树
     */
    public boolean isValidBSTCase1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderBST(root, result);
        return IntStream.range(1, result.size()).noneMatch(i -> result.get(i) <= result.get(i - 1));
    }

    /**
     * 中序遍历
     *
     * @param root   二叉树
     * @param result 结果集
     */
    private void inorderBST(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderBST(root.left, result);
        result.add(root.val);
        inorderBST(root.right, result);
    }

    /**
     * 验证二叉搜索树 实现方法2：递归 leetcode 98
     *
     * @param root 二叉树
     * @return 是否是二叉搜索树
     */
    public boolean isValidBSTCase2(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归验证
     *
     * @param root 二叉树
     * @param min  最小值
     * @param max  最大值
     * @return 子树是否为二叉搜索树
     */
    private boolean validBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

    /**
     * 二叉树的最近公共祖先 实现方法1：后序遍历+递归 leetcode 236
     *
     * @param root 二叉树
     * @param p    节点p
     * @param q    节点q
     * @return 最近公共祖先节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        // 后序遍历 左->右->中
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return root;
    }

    /**
     * 二叉搜索树的最近公共祖先 实现方法1：递归 leetcode 235
     *
     * @param root 二叉搜索树
     * @param p    节点p
     * @param q    节点q
     * @return 最近公共祖先节点
     */
    public static TreeNode lowestCommonAncestorToBalanceTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorToBalanceTree(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorToBalanceTree(root.right, p, q);
        return root;
    }

    /**
     * 二叉搜索树中的插入操作 实现方法1：递归 leetcode 701
     *
     * @param root 二叉搜索树
     * @param val  要插入的值
     * @return 插入后的二叉搜索树
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        return root;
    }

    /**
     * 二叉搜索树中的删除操作 实现方法1：递归 leetcode 450
     *
     * @param root 二叉搜索树
     * @param key  要删除的值
     * @return 删除后的二叉搜索树
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode cur = root.right;
            while (cur.left != null) cur = cur.left;
            cur.left = root.left;
            root = root.right;
            return root;
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }

    /**
     * 修剪二叉搜索树 实现方法1:递归 leetcode 669
     *
     * @param root 二叉搜索树
     * @param low  修剪范围下限
     * @param high 修剪范围上限
     * @return 修剪后的二叉搜索树
     */
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
