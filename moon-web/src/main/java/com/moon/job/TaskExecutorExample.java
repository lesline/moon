package com.moon.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TaskExecutorExample {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static int counter = 0;


    @Autowired
    TaskExecutor taskExecutor;

    public void execute() throws InterruptedException {
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println("(" + counter++ + ")");


        FutureTask<Void> task1 = getTask("1");
        FutureTask<Void> task2 = getTask("2");
        taskExecutor.execute(task1);
        taskExecutor.execute(task2);


    }

    private FutureTask<Void> getTask(final String name) {
        return new FutureTask<Void>(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    try {
                        System.out.println("---------------------"+name);
                    } catch (Exception e) {
                        logger.error("并发调用失败", e);
                    }
                    return null;
                }
            });
    }


}