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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // we will have a dummy node so that we can return head of merged linked list
        ListNode dummy = new ListNode(); // dummy node is used to store the reference so that we can use it 
        ListNode finalList = dummy;

        while(list1 != null && list2 != null){ // if either of them is null we break out of loop
            if(list1.val < list2.val){ // if list1 value is less then add to final list
                finalList.next = list1;
                list1 = list1.next;
            }
            else{
                finalList.next = list2;
                list2 = list2.next;
            }
            finalList = finalList.next;
        }
        
        // in the end check if list1 is null then list will be added and vice versa
        finalList.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
