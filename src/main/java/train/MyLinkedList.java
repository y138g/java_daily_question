package main.java.train;

/**
 * 设计链表 实现方法1：单链表 leetcode 707
 */
class MyLinkedList {

    // 链表长度
    int size;
    // 虚拟头节点
    ListNode dummyHead;

    // MyLinkedList() 初始化 MyLinkedList 对象。
    public MyLinkedList() {
        this.size = 0;
        this.dummyHead = new ListNode(0);
    }

    // int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        // 当前节点
        ListNode current = dummyHead;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = dummyHead.next;
        dummyHead.next = newHead;
        size++;
    }

    // void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead.next;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    // void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
    // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
    // 如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        // 当前节点
        ListNode current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        // 当前节点
        ListNode current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
}
