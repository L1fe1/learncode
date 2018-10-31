package designpattern.strategypattern;

public class UserALoadService implements IdentityLoadService {
    @Override
    public String doService() {
        //读取数据库等等操作，准备人事部门数据
        prepareDataForHR();
        //人事部门所独有的业务处理
        hrOtherService();
        //返回成功页面
        return "HR";
    }

    private void hrOtherService() {
        System.out.println("hr other service...");
    }

    private void prepareDataForHR() {
        System.out.println("prepare data for hr...");
    }
}