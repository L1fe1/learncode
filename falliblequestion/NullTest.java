/**
 * 类变量和类方法的使用，仅仅依赖引用的类型。即使引用为null，仍然可以调用。
 */
public class NullTest {
    public static int getInt() {
        return 1;
    }
    public static void main(String[] args) {
        NullTest myNullTest = null;
        System.out.println(myNullTest.getInt());
    }
}