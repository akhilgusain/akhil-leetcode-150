package linked_lists;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1,2,3,4,5 and n = 2
        // i.e we have to remove 4 from list
        ListNode fast = head, slow = head;
        // we will first give fast pointer the advantage to advance
        for(int i = 0; i < n; i++){
            fast = fast.next;
        } 
        // edge case is if fast has reached end then that means n is the total size and hence we 
        // just need to remove the head
        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; //eliminate next to slow i.e the element to be removed
        return head;
    }
}
