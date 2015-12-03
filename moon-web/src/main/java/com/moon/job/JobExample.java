package com.moon.job;

import java.util.Date;

public class JobExample {
    private static int counter = 0;


    public void execute() {
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println("(" + counter++ + ")");
    }
}