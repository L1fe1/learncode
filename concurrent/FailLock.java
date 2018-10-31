package concurrent;

import concurrent.LockObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 公平锁
 */
public class FailLock {
    private boolean locked; //锁区是否正处于锁定状态(锁区是否已有其他线程存在尚未离开)
    private Thread lockingThread; //当前在锁区的那个线程
    private List<LockObject> waittingThreads = new ArrayList<LockObject>();
    
    
    public void lock() throws InterruptedException{
        LockObject lockObject = new LockObject();
        boolean isAllowedEnterLockedArea = false;
        
        //线程开始排队,谁先进来,谁先被add进List,也就是排在最前面
        synchronized (this) {
            waittingThreads.add(lockObject);
        }
        
        //若不允许进入锁区,则自旋等待
        while (!isAllowedEnterLockedArea) {
            synchronized (this) {
                /* 当前线程是否允许进入锁区的线程(isAllowedEnterLockedArea)?
                 * 如果锁区没有其他线程(locked=false) 且 排队排在最前面 
                 * 则当前线程是被允许进入锁区的线程
                 */
                isAllowedEnterLockedArea = !locked && waittingThreads.get(0) == lockObject;
                
                /* 若允许进入锁区,则在进入前将"锁区已有线程"的标志置为true,
                 * 并从排队队列中将自己移除 */
                if (isAllowedEnterLockedArea) {
                    locked = true;
                    waittingThreads.remove(lockObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            
            try {
                /* 不被允许进入锁区的线程(isAllowedEnterLockedArea=false)
                 * 使用他排队时使用的lockObject对象作为锁标志的锁睡眠了,
                 * 直到有其他线程调用这个lockObject对象的notify()叫醒他
                 * -----------------------
                 * 这里为什么不直接调用lockObject.wait()方法?
                 * --为了防止信号丢失!
                 * 因为自带的wait()或notify()方法是没有状态的, 
                 * 有可能当前线程(线程A)执行到此处,在还没有进入睡眠时, 
                 * 其他线程unlock,就已经notify了线程A, 
                 * 这时由于线程A不是处于睡眠状态而忽略了notify的信号,
                 * 接着线程A进入睡眠, 因为唤醒它的信号已被忽略,
                 * 那么线程A将永远不会醒来
                 */
                lockObject.doWait();  
            } catch (InterruptedException e) {
                /* 若因出现异常,在等待进入锁区的睡眠中被异常打断,
                 * 则将其从排队队列中踢出 */
                synchronized (this) {
                    waittingThreads.remove(lockObject);
                }
                throw e;
            }
        }
    }
    
    
    public synchronized void unlock(){
        if (this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("当前线程并不是加锁者,解锁失败");
        }
        locked = false;
        lockingThread = null;
        //在离开锁区时,若还有其他线程在排队等待进入锁区,则叫醒排在最前面的那个线程
        if (waittingThreads.size() > 0){
            waittingThreads.get(0).doNotify();
        }
    }

}