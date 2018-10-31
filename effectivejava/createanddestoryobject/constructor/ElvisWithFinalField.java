/**
 * 用私有构造器或者枚举类型强化Singleton属性
 * Singleton with public final field
 */
public class ElvisWithFinalField {
    public static final ElvisWithFinalField INSTANCE = new ElvisWithFinalField();
    private ElvisWithFinalField() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        ElvisWithFinalField elvis = ElvisWithFinalField.INSTANCE;
        elvis.leaveTheBuilding();
    }
}