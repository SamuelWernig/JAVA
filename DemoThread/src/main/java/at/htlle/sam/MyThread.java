package at.htlle.sam;

import java.sql.SQLOutput;

public class MyThread extends Thread{

    @Override
    public void run() {
        //custom steps to execute#
        System.out.println("The following thread is running: " + Thread.currentThread().getName());
    }

}

