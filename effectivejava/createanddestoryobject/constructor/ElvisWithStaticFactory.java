/**
 * 用私有构造器或者枚举类型强化Singleton属性
 * 使类成为Singleton会使它的客户端测试变得十分困难，因为无法给Singleton替换模拟实现，除非它实现一个充当其类型的接口。
 * Singleton with static factory
 */
public class ElvisWithStaticFactory {
    private static final ElvisWithStaticFactory INSTANCE = new ElvisWithStaticFactory();
    private ElvisWithStaticFactory() { }
    public static ElvisWithStaticFactory getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        ElvisWithStaticFactory elvis = ElvisWithStaticFactory.getInstance();
        elvis.leaveTheBuilding();
    }
}