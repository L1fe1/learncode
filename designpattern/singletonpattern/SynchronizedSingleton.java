package designpattern.singletonpattern;

public class SynchronizedSingleton {

    //一个静态的实例
    private static volatile SynchronizedSingleton synchronizedSingleton;
    //私有化构造函数
    private SynchronizedSingleton(){}
    //给出一个公共的静态方法返回一个单一实例
    public static SynchronizedSingleton getInstance(){
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (synchronizedSingleton == null) {
                    synchronizedSingleton = new SynchronizedSingleton();
                }
            }
        }
        return synchronizedSingleton;
    }

}
