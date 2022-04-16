package redis.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);

        RLock lock = redissonClient.getLock("wwww");
        lock.lock();
        lock.unlock();
//        Thread thread1 = new Thread(()-> {
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "获取到锁");
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.unlock();
//        }, "线程1");
//
//        Thread thread2 = new Thread(()->{
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + "获取到锁");
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.unlock();
//        }, "线程2");
//        thread1.start();
//        thread2.start();
    }
}
