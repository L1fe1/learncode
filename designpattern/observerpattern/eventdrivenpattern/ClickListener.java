package designpattern.observerpattern.eventdrivenpattern;

import java.util.EventListener;

//点击监听器
public interface ClickListener extends EventListener {
    void click(ClickEvent clickEvent);
}
