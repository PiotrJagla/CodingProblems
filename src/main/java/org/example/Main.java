package org.example;

class MultiThreadThing implements Runnable{



    private int threadNumber;
    public MultiThreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " from thread " + threadNumber);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            MultiThreadThing myThing = new MultiThreadThing(i);
            Thread myThread = new Thread(myThing);
            myThread.setPriority(i + 1);
            myThread.start();


        }
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());




    }
}