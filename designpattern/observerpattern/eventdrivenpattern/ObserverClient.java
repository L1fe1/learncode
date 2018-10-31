package designpattern.observerpattern.eventdrivenpattern;

import designpattern.observerpattern.publishsubscribepattern.Reader;
import designpattern.observerpattern.publishsubscribepattern.Writer;

//客户端调用
public class ObserverClient {

    public static void main(String[] args) {
        //假设四个读者，两个作者
        Reader r1 = new Reader("jack");
        Reader r2 = new Reader("coast");
        Reader r3 = new Reader("teaser");
        Reader r4 = new Reader("viper");
        Writer w1 = new Writer("casper");
        Writer w2 = new Writer("de");
        //四人关注了casper
        r1.subscribe("casper");
        r2.subscribe("casper");
        r3.subscribe("casper");
        r4.subscribe("casper");
        //七哥和刘能还关注了de
        r3.subscribe("de");
        r4.subscribe("de");

        //作者发布新书就会通知关注的读者
        //casper写了设计模式
        w1.addNovel("设计模式");
        //de写了JAVA编程思想
        w2.addNovel("JAVA编程思想");
        //jack取消关注casper
        r1.unsubscribe("casper");
        //casper再写书将不会通知jack
        w1.addNovel("观察者模式");
    }

}
