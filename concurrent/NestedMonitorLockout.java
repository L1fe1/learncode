package concurrent;

import javax.management.monitor.Monitor;

/**
 * 嵌套管程锁死
 * 死锁中,两个线程都在等待对方释放锁. 
 * 嵌套管程锁死中,线程1持有锁A, 同时等待从线程2发来的信号,线程2需要锁A来发信号给线程1
 */
public class NestedMonitorLockout {
    private Monitor monitor = new Monitor() {
        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }
    };
    private boolean locked;

    public void lock() {
        synchronized (this){
            while (locked){
                synchronized(monitor){
                    //进入休眠时,只释放了monitor锁,没有释放this锁
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            locked = true;
        }
    }

    public void unlock(){
        //因为this被占用, 无法进入同步块唤醒已睡眠的线程
        synchronized(this){
            locked = false;
            synchronized(monitor){
                monitor.notify();
            }
        }
    }
}