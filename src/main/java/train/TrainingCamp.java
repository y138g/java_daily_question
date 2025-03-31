package main.java.train;

import java.util.Stack;

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
}
