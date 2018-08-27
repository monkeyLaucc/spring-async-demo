package cc.lau.asyncdemo.biz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by cc on 18/8/25
 */
@Component
public class TaskDemo {

    public static Random random = new Random();

    @Async
    public Future<String> task1() throws InterruptedException {
        System.out.println("开始执行任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一执行时间：" + (end - start));
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        System.out.println("开始执行任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二执行时间：" + (end - start));
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        System.out.println("开始执行任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三执行时间：" + (end - start));
        return new AsyncResult<>("任务三完成");
    }

}