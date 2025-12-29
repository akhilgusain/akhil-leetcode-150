package linkedlist;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        // use 2 pointer, i.e one slow and one fast
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // start iteration by moving slow one step and fast two steps
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // they will surely meet if the linkedlist is cyclic
                return true;
            }
        }
        return false;
    }
}
