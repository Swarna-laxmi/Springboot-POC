package com.sb;

public class SynchronizedTesting extends Thread {
    @Override
    public void run(){
        criticalResource();
    }

    synchronized void criticalResource() {
        String name=Thread.currentThread().getName();
        System.out.println(name+"entered into criticalResource");
        for(int i=0;i<=5;i++)
        {
            System.out.println(name+":"+i);
        }
    }


}
