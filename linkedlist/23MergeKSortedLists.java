package linkedlist;

import java.util.PriorityQueue;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // we will use minheap and implement it by PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list : lists){
            while(list != null){
                minHeap.add(list.val);
                list = list.next;
            }
        }
        // now we have added all elements to min heap
        // so we can start emptying the min heap
        // initialize dummy node and then keep on adding the list elements
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;
        while(!minHeap.isEmpty()){
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        } 
        return dummy.next;
    }
}