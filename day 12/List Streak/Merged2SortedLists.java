public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Link the current node to the smaller value node from list1
                current.next = list1;
                list1 = list1.next;
            } else {
                // Link the current node to the smaller value node from list2
                current.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer forward
            current = current.next;
        }
        
        // If one of the lists is exhausted, link to the remaining list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next; // The merged list starts from the next node of the dummy
    }
}



// 1- use a dummy node to simplify handling the head of the merged list.

// 2- iterate through both input lists simultaneously, comparing the values of the current nodes from list1 and list2.

// 3- link the smaller node to the merged list and advance the pointer for that list.

// 4- move the current pointer forward in the merged list.

// After the loop, if one of the input lists is exhausted, we link the remaining list to the merged list.