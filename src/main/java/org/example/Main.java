package org.example;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResourceObj= new SharedResource();

        //we have created threads using lambda expression
        //since both threads are using same object, we have to use synchronization.
        //producer thread will wait for 3 seconds, which makes sure that consumer thread goes first.
        //consumer thread will try to consume, but since item it not present it has to wait for 3 sec.
        //then producer thread will go and produce the item and notify all
        //then consumer thread will consume the item.
        Thread produceThread = new Thread(()-> {
            try{
                Thread.sleep(3000);
            }catch(Exception e){
                //exception handling code
            }
            sharedResourceObj.addItem();
        }
        );

        Thread consumerThread = new Thread(()->{sharedResourceObj.consumeItem();});

        produceThread.start();
        consumerThread.start();


    }
}
