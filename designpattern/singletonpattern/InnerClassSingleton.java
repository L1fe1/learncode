package designpattern.singletonpattern;

public class InnerClassSingleton {

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return SingletonInstance.instance;
    }

    private static class SingletonInstance{

        static InnerClassSingleton instance = new InnerClassSingleton();

    }

}
