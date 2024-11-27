package LinkedList;

//Reverse Linked List
//Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
//
//Example 1:

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode tmp = curr.next;
            curr.next = prev;
            curr = tmp;
            prev = curr;
        }
        return curr;
    }
}
