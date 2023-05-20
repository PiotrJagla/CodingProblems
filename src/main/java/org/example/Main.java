package org.example;

class MultiThreadThing extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        MultiThreadThing myThing = new MultiThreadThing();
        MultiThreadThing myThing2 = new MultiThreadThing();


        myThing.start();
        myThing2.run();

    }
}