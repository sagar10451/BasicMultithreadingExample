package org.example;

public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent=true;
        System.out.println("Producer thread calling the notify method");
        notifyAll();

    }
    public synchronized void consumeItem(){
        System.out.println("Consumer Thread inside consumeItem method");

        if(!isItemPresent){
            try{
                System.out.println("consumer Thread is waiting");
                wait();//since it is waiting, it will release all the monitor locks. so when producer comes it will
                //get the lock and produce item.
            }catch(Exception e){
                //some exception handling code here
            }
            System.out.println("consumed the item");

        }
        isItemPresent=false;
    }
}
