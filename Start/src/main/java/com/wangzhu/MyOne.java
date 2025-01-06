package com.wangzhu;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wangzhu on 2024/12/5 11:25.
 **/
public class MyOne {

    // 多线程
    // 5个生产者 5个消费者
    // 生产者随机数 队列共享数据


     LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1000);

     void produce() {
        try {
            int a = new Random().nextInt(1000);
            queue.put(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     void consume() {
        try {
            int a = queue.take();
            System.out.println(Thread.currentThread() + " " + a);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyOne().handle();
    }

    void handle(){
        for(int i = 0;i < 5;i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    int j = 0;
                    while(true){
//                        j++;
                        produce();
                        try {
                            Thread.sleep(10);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        for(int i = 0;i < 5;i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        consume();
                    }
                }
            }).start();
        }


    }
}
