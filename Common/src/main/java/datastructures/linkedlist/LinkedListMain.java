package datastructures.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        /**
         * Insert data to linked list
         * */

        System.out.println("======== Linked List Insertion Operation =================== ");

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);

        linkedList.printNode();

        System.out.println("======== Linked List Deletion By Key Operation =================== ");

        /**
         * Delete existing data from linked list
         * */

        linkedList.deleteNodeByKey(2);
        linkedList.deleteNodeByKey(3);
        linkedList.deleteNodeByKey(4);

        linkedList.printNode();

        /**
         * Delete non existing data from linked list
         * */


        linkedList.deleteNodeByKey(12);
        linkedList.deleteNodeByKey(13);
        linkedList.deleteNodeByKey(14);

        linkedList.printNode();

        /**
         * Delete head node from linked list
         * */

        linkedList.deleteNodeByKey(1);

        linkedList.printNode();

        System.out.println("======== Linked List Deletion By Position Operation =================== ");

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);

        linkedList.printNode();

        linkedList.deleteAtPosition(10);

        linkedList.printNode();

        linkedList.deleteAtPosition(0);
        linkedList.deleteAtPosition(1);
        linkedList.deleteAtPosition(2);
        linkedList.deleteAtPosition(3);
        linkedList.deleteAtPosition(4);
        linkedList.deleteAtPosition(0);
        linkedList.deleteAtPosition(0);


        linkedList.printNode();

        System.out.println("======== Linked List Reverse Non Recursively Operation =================== ");

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(0);

        linkedList.reverseLinkedList();

        linkedList.printNode();

        linkedList.reverseRecursively();

        linkedList.printNode();
    }

}
