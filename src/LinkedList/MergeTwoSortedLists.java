package LinkedList;


//Merge Two Sorted Linked Lists
//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
//
//        The new list should be made up of nodes from list1 and list2.

import java.util.List;



public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Create dummy node as a start of the merged list :
        ListNode dummy = new ListNode(-1);
        var current = dummy;
        // Imamo current Node, koji pocinje od korena, i pokazuje uvek na najmanji elemtn do sada umerdzovan
        // iteriramo sa posebnim pointerima po obe liste i u slucaju manjeg noda, povezujemo u current i prelazimo na sledeci u toj listi
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                current.next=list1;
                list1 = list1.next;
            }
            else
            {
                current.next=list2;
                list2 = list2.next;
            }
            current=current.next;
        }
        // Sada smo dosli do rkaja jedne od liste, i treba da povezemo na drugu
        current.next = list1==null?list2:list1;
        return dummy;
    }
}
