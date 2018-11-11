package top.bingoxin.practice;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class MyThread2 implements Runnable{
    public static int ticket = 10;
    private String name;
    public MyThread2(String str){
        name = str;
    }
    @Override
    public void run() {
        for(int i = 10;i > 0; --i){
            System.out.println(name+"还剩"+ticket--+"张票");
        }
    }
}

class MyThread1 extends Thread{
    private int ticket = 10;
    private String yellow;
    public MyThread1(String str){
        yellow = str;
    }
    @Override
    public void run() {
        for(int i = 10;i > 0;--i){
            System.out.println(yellow+"还剩"+ticket--+"张票");
        }
    }
}


class MyThread implements Callable<String>{
    private static int ticket = 10;

    @Override
    public String call() {
       for(int i = 10;i > 0; --i){
           System.out.println("还剩"+ticket--+"张票");
       }
       return "票卖完了";
    }
}

public class TestThreads {
    public static void main(String[] args) throws InterruptedException,Exception{
        MyThread2 myThread1 = new MyThread2("黄牛A");
        MyThread2 myThread2 = new MyThread2("黄牛B");
        MyThread2 myThread3 = new MyThread2("黄牛C");
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread3);
        thread1.start();
        thread2.start();
        thread3.start();
//        Thread MyThread1 = new MyThread1("黄牛A");
//        Thread MyThread2 = new MyThread1("黄牛B");
//        Thread MyThread3 = new MyThread1("黄牛C");
//        MyThread1.start();
//        MyThread2.start();
//        MyThread3.start();
        
//        MyThread myThread = new MyThread();
//        FutureTask<String> futureTask = new FutureTask<>(myThread);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        System.out.println(futureTask.get());
    }
}
