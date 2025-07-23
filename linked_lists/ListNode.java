package linked_lists;
/**
 * Definition for singly-linked list.*/
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        // we have to find mid point of list and reverse from that list
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid point is slow variable ListNode
        // Now reversing the linked list by prev,curr and temp variable as previously done
        ListNode prev = null, curr = slow, temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode first = head, second = prev;
        while(second.next != null){
            temp = first.next;
            first.next = second;
            first = temp; // since we have to do the operation on the temp now
            temp = second.next;
            second.next = first;
            second = temp;
        }
        // example
        // for 1,2,3,4
        // first = 1,2->null
        // second = 4,3->null

        //temp = first.next;           // temp = 2
        //first.next = second;        // 1 -> 4
        //first = temp;               // first = 2

        //temp = second.next;         // temp = 3
        //second.next = first;        // 4 -> 2
        //second = temp;              // second = 3

        // now second.next == null so we break from loop
        // result is 1,4,2,3 since 2->3 link was never broken
    }
}