/**
 * 用私有构造器或者枚举类型强化Singleton属性
 * 私有的构造方法也会被享有特权的客户端借助AccessibleObject.setAccessible方法，通过反射机制调用私有构造器。
 * 序列化Singleton类使用implement Serializable是不够的，为了维护并保证Singleton，
 * 必须声明所有实例域都是瞬时（transient）的，并提供一个readResolve方法，否则每次反序列化一个序列化的实例时，都会创建一个新的实例。
 * Enum singleton - the preferred approach
 */
public enum ElvisWithEnum {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        ElvisWithEnum elvis = ElvisWithEnum.INSTANCE;
        elvis.leaveTheBuilding();
    }
}