package designpattern.observerpattern.eventdrivenpattern;

import java.util.EventListener;

public interface WriterListener extends EventListener {

    void addNovel(WriterEvent writerEvent);

}
