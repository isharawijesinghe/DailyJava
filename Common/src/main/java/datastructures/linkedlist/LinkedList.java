package datastructures.linkedlist;

public class LinkedList<T> {

    Node head;


    public void addNode(T data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else {
            Node currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    /**
     * To delete a node from the linked list, do following steps.
     *
     * 1. Search the key for its first occurrence in the list
     * 2. Now, Any of the 3 conditions can be there:
     *
     *
     * Case 1: The key is found at the head
     * In this case, Change the head of the node to the next node of the current head.
     * Free the memory of the replaced head node.
     *
     *
     * Case 2: The key is found in the middle or last, except at the head
     * In this case, Find the previous node of the node to be deleted.
     * Change the next the previous node to the next node of the current node.
     * Free the memory of the replaced node.
     *
     *
     * Case 3: The key is not found in the list
     * In this case, No operation needs to be done.
     * **/
    public void deleteNodeByKey(T data){
        if (head != null && head.data == data){
            head = head.next;
        } else {
            Node currentNode = head;
            while (currentNode.next != null){
                if (currentNode.next.data == data){
                    currentNode.next = currentNode.next.next;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * The steps to do it are as follows:
     *
     * 1. Traverse the list by counting the index of the nodes
     * 2. For each index, match the index to be same as position
     * 3. Now, Any of the 3 conditions can be there:
     *
     *
     * Case 1: The position is 0, i.e. the head is to be deleted
     * In this case, Change the head of the node to the next node of current head.
     * Free the memory of replaced head node.
     *
     *
     * Case 2: The position is greater than 0 but less than the size of the list, i.e. in the middle or last, except at head
     * In this case, Find previous node of the node to be deleted.
     * Change the next of previous node to the next node of current node.
     * Free the memory of replaced node.
     *
     *
     * Case 3: The position is greater than the size of the list, i.e. position not found in the list
     * In this case, No operation needs to be done.
     *
     * **/
    public void deleteAtPosition(int indexAt){
        if (indexAt == 0){
            head = head.next;
        } else {
            int currentIndex = 1;
            Node currentNode = head;
            while (currentNode.next != null){
                if (currentIndex == indexAt){
                    currentNode.next = currentNode.next.next;
                    break;
                }
                currentNode = currentNode.next;
                currentIndex++;
            }
        }
    }

    public void reverseLinkedList(){
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = null;
        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;


    }

    public void reverseRecursively(){
        reverseRecursively(head);
    }

    private Node reverseRecursively(Node node){
        Node newHead;

        //base case - tail of original linked list
        if((node.next == null)){
            head = node;
            return node;
        }
        newHead = reverseRecursively(node.next);

        //reverse the link e.g. C->D->null will be null
        node.next.next = node;
        node.next = null;
        return newHead;
    }


    public void printNode(){
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }



}
