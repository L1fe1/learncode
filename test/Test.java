package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("a","aaa");
        System.out.println(map.containsKey("a")); //输出true 如果这个map集合中有这个key就返回true
        System.out.println(map.containsKey(null)); //输出false 没有就返回false
        System.out.println(map.get(null));
    }
}
