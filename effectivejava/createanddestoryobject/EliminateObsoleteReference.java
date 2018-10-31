package effectivejava.createanddestoryobject;

import java.util.EmptyStackException;

/**
 * 消除过期的对象引用
 * 栈的内部容易出现过期引用（obsolete reference），导致JVM无法进行垃圾回收。
 * 在支持垃圾回收的语言中，内存泄漏是很隐蔽的（称这类内存泄漏为“无意识的对象保持（unintentional object retention）”更为恰当。
 * 内存泄漏的另一个常见来源是缓存。
 * 内存泄漏的第三个常见来源是监听器和其他回调。
 */
public class EliminateObsoleteReference {
    private int size;
    private Object elements[];

    //its method could be better
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    //whatch this method
    public Object betterPop(){
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size]=null;//Eliminate obsolete reference
        return result;
    }
}