package effectivejava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型的目的：为了避免转型，使得编译器能够在编译期就发现转型错误而不用等到运行时。
 * 带有通配符的上下界：? extends T和? super T
 * 当你需要从一个数据结构中获取数据时(get), 那么就使用? extends T. 
 * 如果你需要存储数据(put)到一个数据结构时，那么就使用? super T. 
 * 如果你又想存储数据，又想获取数据，那么就不要使用通配符? . 即直接使用具体泛型T。
 */
public class BasicGenerics {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        // intList.add("abc");//编译期错误,不能存放String对象到intList中
        Integer i = intList.get(0);
        List<? extends Number> numberList = new ArrayList<>();
        // numberList.add(1);//compile error
        // numberList.add(3.14);//compile error
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
//        List<Number> nums = ints; // compile-time error
//        nums.add(3.14);
        assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
    }
}