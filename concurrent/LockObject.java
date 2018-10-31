package concurrent;

public class LockObject {
    private boolean isNotified;  //使用成员变量记住信号,防止信号丢失(带状态的锁)
    
    public synchronized void doWait() throws InterruptedException{
        while(!isNotified){
            this.wait();
        }
        isNotified = false;
    }
    
    public synchronized void doNotify(){
        this.isNotified = true;
        this.notify();
    }
    
    @Override
    public boolean equals(Object o){
        return this == o;
    }

}