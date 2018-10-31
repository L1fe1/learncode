package designpattern.strategypattern;

/**
 * 只有为值得优化的if-else块使用策略模式才有价值
 */
public class LoginService {

    public String getPageByIdentity(User user){
    
        //一些其他的操作
        doSth();

        //这里开始将if-else逻辑判断委派给策略模式的执行器
        return LoadStrategyExcutor.execute(user);
    }

    private void doSth() {
        System.out.println("do something...");
    }

}