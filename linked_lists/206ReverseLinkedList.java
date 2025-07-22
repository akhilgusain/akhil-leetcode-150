package linked_lists;

//Definition for singly-linked list
   class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode reverseList(ListNode head) {
        //      1->2->3->4->5
        //      prev        curr     temp
        //      [null]      1        2       3       4       5
        // here we make a new prev and point curr to head
        // the temp will point to next so that we know its reference when we change curr.next to prev
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;   // 1 points to null(prev)
            prev = curr;    // shifting the prev to curr
            curr = temp;    // shifting the curr to temp
        //          prev    curr    temp    
        //   null <- 1   <-   2       3      4       5
        // and so on...
        }
        return prev;
    }
}
