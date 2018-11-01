package designpattern.adapterpattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;

//我们扩展BaseEntity,适配出来一个可观察的实体基类
public class BaseObservableEntity extends BaseEntity{

    private Observable observable = new Observable();

    public synchronized void addObserver(Observer o) {
        observable.addObserver(o);
    }

    public synchronized void deleteObserver(Observer o) {
        observable.deleteObserver(o);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public void notifyObservers(Object arg) {
        observable.notifyObservers(arg);
    }

    public synchronized void deleteObservers() {
        observable.deleteObservers();
    }

    protected synchronized void setChanged() {
        Class<?> clazz = observable.getClass();
        try {
            Method method = clazz.getDeclaredMethod("setChanged");
            method.setAccessible(true);
            try {
                method.invoke(observable,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    protected synchronized void clearChanged() {
        Class<?> clazz = observable.getClass();
        try {
            Method method = clazz.getDeclaredMethod("clearChanged");
            method.setAccessible(true);
            try {
                method.invoke(observable,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean hasChanged() {
        return observable.hasChanged();
    }

    public synchronized int countObservers() {
        return observable.countObservers();
    }

}
