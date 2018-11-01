package designpattern.adapterpattern;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class HashMapObserverAdapter<K, V> extends HashMap<K, V> implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        //被观察者变化时，清空Map
        super.clear();
    }
}
