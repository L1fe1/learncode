package effectivejava.generics;

import java.util.Iterator;
import java.util.List;

/**
 * PECS 表示：producer-extends, consumer-super
 * 所有的comparable和comparator都是消费者。
 * 
 */
public class RestrictWildcards {
    public static <T extends Comparable<? super T>> T max(
        List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }
    // 生产者——产生泛型对象所以入栈时继承泛型E
    // Wildcard type for parameter that serves as an E producer
//    public void pushAll(Iterable<? extends E> src) {
//        for (E e : src)
//            push(e);
//    }
    // 消费者——使用泛型对象所以使用时为E的超类
    // Wildcard type for parameter that serves as an E consumer
//    public void popAll(Collection<? super E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }
}