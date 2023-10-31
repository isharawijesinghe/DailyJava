package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Worker extends Thread {

    CountDownLatch countdownLatch;

    List<String> captureList;


    public Worker(CountDownLatch countdownLatch, List<String> captureList){
        this.countdownLatch = countdownLatch;
        this.captureList = captureList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countdownLatch.countDown();
        captureList.add("Add " + Thread.currentThread().getName());
        System.out.println("====== Worker resuming running " + Thread.currentThread().getName());
    }
}

public class CountdownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch countdownLatch = new CountDownLatch(4);
        List<String> captureList = new ArrayList<>();

        Worker w1 = new Worker(countdownLatch, captureList);
        Worker w2 = new Worker(countdownLatch, captureList);
        Worker w3 = new Worker(countdownLatch, captureList);
        Worker w4 = new Worker(countdownLatch, captureList);


        w1.start();
        w2.start();
        w3.start();
        w4.start();

        try {
            countdownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Output of worker threads ");


    }

}
