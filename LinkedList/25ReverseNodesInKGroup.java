package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head; // the iterative main node
        ListNode ktail = null; // its the tail of the group
        ListNode newHead = null; // head after reversing the group

        while (head != null) {
            int count = 0;
            ptr = head;

            // Check if we have k nodes ahead
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            // If we got k nodes, then reverse them
            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);

                // New head for the first group
                if (newHead == null) {
                    newHead = revHead;
                }

                // Connect with previous tail
                if (ktail != null) {
                    ktail.next = revHead;
                }

                // Move ktail to the end of the reversed section
                ktail = head; //since head becomes tail

                // Move head to the next section
                head = ptr;
            } else {
                // If remaining nodes are less than k, connect directly
                if (ktail != null) {
                    ktail.next = head;
                }
                break;
            }
        }

        return newHead == null ? head : newHead;
    }

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }

        return newHead;
    }
}

