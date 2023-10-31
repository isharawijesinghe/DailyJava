package top75.linkedlist;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = null;
        ListNode list1CurrentNode = list1;
        ListNode list2CurrentNode = list2;
        while (list1CurrentNode != null && list2CurrentNode != null){
            if (list1CurrentNode.val <= list2CurrentNode.val){
                listNode = addNode(list1CurrentNode, listNode);
                list1CurrentNode = list1CurrentNode.next;
            } else {
                listNode = addNode(list2CurrentNode, listNode);
                list2CurrentNode = list2CurrentNode.next;
            }
        }

        while (list1CurrentNode != null){
            listNode = addNode(list1CurrentNode, listNode);
            list1CurrentNode = list1CurrentNode.next;
        }

        while (list2CurrentNode != null){
            listNode= addNode(list2CurrentNode, listNode);
            list2CurrentNode = list2CurrentNode.next;
        }

        return listNode;
    }

    public ListNode addNode(ListNode node, ListNode createdNode){
        ListNode newNode = new ListNode(node.val);
        if (createdNode == null){
            createdNode = newNode;
        }else {
            ListNode currentNode = createdNode;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return createdNode;
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
        ListNode c1_1 = new ListNode(20);
        ListNode c1_2 = new ListNode(10, c1_1);
        ListNode c1_3 = new ListNode(6, c1_2);
        ListNode c1_4 = new ListNode(4, c1_3);
        ListNode c1_5 = new ListNode(1, c1_4);
        ListNode c1_6 = new ListNode(1, c1_5);

        ListNode c2_1 = new ListNode(6);
        ListNode c2_2 = new ListNode(5, c2_1);
        ListNode c2_3 = new ListNode(4, c2_2);
        ListNode c2_4 = new ListNode(3, c2_3);
        ListNode c2_5 = new ListNode(2, c2_4);
        ListNode c2_6 = new ListNode(1, c2_5);

        System.out.println("List Node 1 ===================");
        printNode(c1_6);

        System.out.println("List Node 2 ===================");
        printNode(c2_6);

        System.out.println("Two Node After Merge ===================");
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode mergeListNode = mergeTwoLists.mergeTwoLists(c1_6, c2_6);
        printNode(mergeListNode);
    }



}
