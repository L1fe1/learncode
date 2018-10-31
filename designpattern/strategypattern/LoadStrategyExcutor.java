package designpattern.strategypattern;

/**
* 策略执行类，这里对用户的身份进行判断，然后映射到不同的模式
*/
public class LoadStrategyExcutor {

    public static String execute(User user){

        IdentityLoadService loadStrategy = null;

        switch(user.getIdentityCode()){
            case 1 : loadStrategy = new UserALoadService();
                break;
            case 2 : loadStrategy = new UserBLoadService();
                break;
            case 3 : loadStrategy = new UserCLoadService();
                break;
            default: break;
        }

    return loadStrategy.doService();
    }
}