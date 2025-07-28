package linked_lists;

// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // make a dummy node for traversing
        ListNode res = dummy; // res is used at last just for returning the list
        int total = 0, carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            total = carry; // include carry in total sum

            if(l1 != null){ // check if l1 has element then add it and go forward
                total += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // similar to l1
                total += l2.val;
                l2 = l2.next;
            }
             
            int value = total % 10; // since we just have to store single digit so store last digit
            carry = total / 10; // carry is either 0 or 1

            // assign the result and move next
            dummy.next = new ListNode(value); 
            dummy = dummy.next;

        }
        return res.next;
    }
}
