package concurrent;

import com.sun.corba.se.spi.monitoring.MonitoredAttribute;
import com.sun.corba.se.spi.monitoring.MonitoredObject;

import java.util.Collection;

/**
 * 线程的通信：wait(), notify()
 */
public class MyWaitNotify {
    MonitoredObject monitor = new MonitoredObject() {
        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public void addChild(MonitoredObject m) {

        }

        @Override
        public void removeChild(String name) {

        }

        @Override
        public MonitoredObject getChild(String name) {
            return null;
        }

        @Override
        public Collection getChildren() {
            return null;
        }

        @Override
        public void setParent(MonitoredObject m) {

        }

        @Override
        public MonitoredObject getParent() {
            return null;
        }

        @Override
        public void addAttribute(MonitoredAttribute value) {

        }

        @Override
        public void removeAttribute(String name) {

        }

        @Override
        public MonitoredAttribute getAttribute(String name) {
            return null;
        }

        @Override
        public Collection getAttributes() {
            return null;
        }

        @Override
        public void clearState() {

        }
    };
    boolean wasSignaled = false;

    public void doWait() {
        synchronized(monitor){
            while (!wasSignaled){  //用while代替if防止假唤醒
                try {
                    monitor.wait();  //wait(),notify(),notifyAll()必须位于同步块内
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignaled = false;
        }
    }
    
    public void doNotify() {
        synchronized(monitor){
            wasSignaled = true;
            monitor.notify();  //notity后并不意味着等待线程立即可以继续执行,而只是可以有机会再次抢夺锁
        }
    }

}