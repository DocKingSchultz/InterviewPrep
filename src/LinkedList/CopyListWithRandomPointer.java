package LinkedList;

//Copy Linked List with Random Pointer
//You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
//
//Create a deep copy of the list.
//
//The deep copy should consist of exactly n new nodes, each including:
//
//The original value val of the copied node
//A next pointer to the new node corresponding to the next pointer of the original node
//A random pointer to the new node corresponding to the random pointer of the original node
//Note: None of the pointers in the new list should point to nodes in the original list.
//
//Return the head of the copied linked list.


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    Map<ListNode, ListNode> linkerMap = new HashMap<>();
    public ListNode copyRandomList(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        while(tmp!=null)
        {
            ListNode deepNode = new ListNode(tmp.val);
            if(prev!=null)prev.next = deepNode;
            prev = deepNode;
            linkerMap.put(tmp, deepNode);
            tmp=tmp.next;
        }
        tmp = head;
        while(tmp!=null)
        {
            var deepCopy = linkerMap.get(tmp);
            deepCopy.random = linkerMap.get(tmp.random);
            tmp=tmp.next;
        }
        return linkerMap.get(head);
    }
}
