package com.sb;



public class Main {

    public static void main(String[] args) {
        System.out.println("Main Method Called");
        SynchronizedTesting obj=new SynchronizedTesting();
        Thread t1= new Thread(obj);
        Thread t2=new Thread(obj);
        Thread t3=new Thread(obj);
        t1.setName("Swarna-Thread");
        t2.setName("Gyan-Thread");
        t3.setName("Our-Thread");
        t1.start();
        t2.start();
        t3.start();
    }
}