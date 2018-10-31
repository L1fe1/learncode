package effectivejava.createanddestoryobject;

/**
 * 避免创建不必要的对象
 * 自动装箱也会引起不必要的性能开销——优先使用基本类型而不是装箱基本类型，当心无意识的自动装箱
 */
public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        Long sum = 0L;
        //long to Long is not a good idea.
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}