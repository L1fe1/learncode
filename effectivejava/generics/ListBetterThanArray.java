package effectivejava.generics;

import java.util.List;
import java.util.LinkedList;

/**
 * 数组是协变的（convariant）。相反泛型则是不可变的（invariant）。即如果Sub为Super的子类型，那么数组类型Sub[]就是Super[]的子类型；
 * 数组是具体化的（reified）。因此数组会在运行时才知道并检查他们的元素类型约束。
 * 泛型是通过类型擦除来实现的。因此泛型只在编译时强化他们的类型信息，并在运行时丢弃（或者擦除）他们元素的类型信息。
 * 创建泛型数组是非法的。
 */
public class ListBetterThanArray {
    public static void main(String[] args) {
        //这是被允许的
        Object[] objectArray = new Long[1];
        objectArray[0] = "hello world";//Throws java.lang.ArrayStoreException
        //Won't compile! 不被允许：Type mismatch: cannot convert from LinkedList<Long> to List<Object>
//        List<Object> list = new LinkedList<Long>();
        //Cannot create a generic array of List<String>
//        List<String>[] stringLists = new List<String>[1];
    }
}