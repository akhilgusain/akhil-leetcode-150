package linkedlist;

 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        // ex : 1,2,3,4 ==> 2,1,4,3
        //      1  <-  2      and  3,4
        //  p   c      second      npn    

        while(curr != null && curr.next != null){
            ListNode npn = curr.next.next; // to avoid losing the node, nextpairnode
            ListNode second = curr.next; // naming it as npn
            // starting the swap
            second.next = curr; // make first swap
            curr.next = npn; // second step i.e curr.next = next pointing node
            prev.next = second;

            prev = curr;
            curr = npn;
        }
        return dummy.next;


    }
}