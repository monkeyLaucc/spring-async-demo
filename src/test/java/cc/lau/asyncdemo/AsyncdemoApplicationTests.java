package cc.lau.asyncdemo;

import cc.lau.asyncdemo.biz.TaskDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncdemoApplicationTests {

    @Autowired
    private TaskDemo taskDemo;

    @Test
    public void contextLoads() throws InterruptedException {
        long start = System.currentTimeMillis();

        Future<String> task1 = taskDemo.task1();
        Future<String> task2 = taskDemo.task2();
        Future<String> task3 = taskDemo.task3();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部执行完共耗时：" + (end - start));
    }
}