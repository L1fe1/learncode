package effectivejava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型参数的自动推断
 */
public class GenericsUtils {
    public static <T> List<T> asList(T... array) {
        List<T> tlist = new ArrayList<>();
        for (T t : array) {
            tlist.add(t);
        }
        return tlist;
    }
    public static <T> T newObject(String className) throws Exception {
        Class clz = Class.forName(className);
        return (T) clz.newInstance();
    }
    public static void main(String[] args) {
        //显式指定泛型参数的类型
        System.out.println(GenericsUtils.<String>asList("a","b","c"));
        //隐式指定泛型参数的类型，由编译器推断类型
        System.out.println(GenericsUtils.asList("a","b","c"));
        //编译器会从方法赋值的目标参数来推断类型
        try {
            BasicGenerics bg = GenericsUtils.newObject("BasicGenerics");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}