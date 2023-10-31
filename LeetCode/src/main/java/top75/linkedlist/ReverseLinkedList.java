package top75.linkedlist;

public class ReverseLinkedList {

    public static ListNode reverseListNonRecursive(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode previousNode = null;

        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static void printNode(ListNode head){
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(6);
        ListNode n1 = new ListNode(5, n0);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(2, n3);
        ListNode n5 = new ListNode(1, n4);

        System.out.println("Linked List Print ==========================");
        printNode(n5);

        System.out.println("Linked List Reverse Non Recursive Print ==========================");
        ListNode output = reverseListNonRecursive(n5);

        printNode(output);
    }
}
