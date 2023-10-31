package top75.linkedlist;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head != null && head.next == null){
            return false;
        }

        HashSet<ListNode> visitedMap = new HashSet<>();
        ListNode currentNode = head;
        while (currentNode != null){
            if (visitedMap.contains(currentNode)){
                return true;
            }
            visitedMap.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    public static void main(String[] args) {
//        ListNode n0 = new ListNode(6);
//        ListNode n1 = new ListNode(5, n0);
//        ListNode n2 = new ListNode(4, n1);
//        ListNode n3 = new ListNode(3, n2);
//        ListNode n4 = new ListNode(2, n3);
//        ListNode n5 = new ListNode(1, n4);
//        n0.next = n5;

        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1, n0);
        n0.next = n1;

        System.out.println(hasCycle(n1));
    }
}
