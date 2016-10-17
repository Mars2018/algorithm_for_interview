package concurrent_practice;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Runnable， Callable，Future， Executor学习
 * Created by MarsWang on 2016/9/22.
 */
public class MyThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int count = 5;
        Thread t1 = new Thread(new MyThread(count),"MyThread-");
        Thread t2 = new Thread(new MyRunnable(count),"MyRunnable-");
        Thread t22 = new Thread(new MyRunnable(count),"MyRunnable-");
        FutureTask<Integer> task = new FutureTask<Integer>(new MyCallable(count));
        Thread t3 = new Thread(task, "MyCallable-");
//        t1.start();
//        t2.start();
//        t3.start();
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
        for(;;)
        if (task.isDone()){
            System.out.println("FutureTask is Done: " + task.get());
            break;
        }
    }


}

class MyThread extends Thread{
    private int count;
    public MyThread(int count){
        this.count = count;
    }

    public void run() {
        for (int i = 1; i < count + 1; ++i) {
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyRunnable implements Runnable{
    private int count;
    public MyRunnable(int count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i = 1; i < count+1; ++i){
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyCallable implements Callable<Integer>{

    private int count;
    public MyCallable(int count){
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i < count+1; ++i){
            try {
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
        return count+1;
    }
}