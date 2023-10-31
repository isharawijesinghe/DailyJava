package datastructures;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        // creating an instance of PriorityQueue in Java
        // Its better to define initial capacity because
        // its backed by array
        // Define PriorityQueue with initial capacity
        PriorityQueue pq = new PriorityQueue<Integer>(10);

        // adding numbers into PriorityQueue in arbitrary order
        pq.add(3);
        pq.add(7);
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        // Now, let's if PriorityQueue keeps the smallest
        // element in head or not. Let's use peek  method
        // to check that, peek() returns the head of the
        // queue

        Integer head = (Integer) pq.peek();
        System.out.println("Size Of Non Comparator PriorityQueue : " + pq.size());
        System.out.println("Head Of Non Comparator PriorityQueue : " + head); // 1

        // Now, let's remove the head and see what comes
        // next, you can use poll() method to remove
        // element from head

        head = (Integer) pq.poll(); // 1
        head = (Integer) pq.peek();

        System.out.println("Current Value of Non Comparator head : " + head);
        System.out.println("Size Of Non Comparator PriorityQueue : " + pq.size());


        // Iterating over PriorityQueue, iterator returned
        // by PriorityQueue doesn't guarantee any order
        Iterator<Integer> itr = pq.iterator();
        System.out.println("Iterating Over Non Comparator PriorityQueue");

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("========= End Non Comparator PriorityQueue =========");

        // Define PriorityQueue with initial capacity
        // Plus Add Comparator to Sort Priority Queue in Descending Order
        PriorityQueue pq1 = new PriorityQueue<Integer>(10, (a1, a2) -> a2-a1);

        // adding numbers into PriorityQueue in arbitrary order
        pq1.add(3);
        pq1.add(700);
        pq1.add(2);
        pq1.add(44);
        pq1.add(61);
        pq1.add(1);

        Integer head1 = (Integer) pq1.peek();
        System.out.println("Size Of Comparator PriorityQueue : " + pq1.size());
        System.out.println("Head Of Comparator PriorityQueue : " + head1); // 1

    }

}
