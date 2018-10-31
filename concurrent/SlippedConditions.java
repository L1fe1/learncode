package concurrent;

/**
 * 为避免slipped conditions, 条件的检查和设置必须是原子的, 
 * 也就是在第一个线程检查和设置条件期间,不会有其他线程检查这个条件
 */
public class SlippedConditions {
    private boolean locked;
    
    public void lock() {
        synchronized (this){  //同步块1
            while (locked){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        /* 这里同步块1与同步块2间可能出现slipped conditions:
         * 一个线程(线程A)检查到locked=false跳出同步块1后,即将准备进入同步块2,此时:
         * this锁已被释放. 这时新的线程B调用lock()进入同步块1,检查到locked=false,
         * 因此线程B马上跳出同步块1,进入同步块2,将locked置为true,
         * 接下来线程A才进入同步块2,而此时发现:期间locked已被别人(线程B)修改过了
         */
        synchronized(this){  //同步块2
            locked = true;
        }
    }
    
    public void unlocked() {
        locked = false;
        this.notify();
    }
}