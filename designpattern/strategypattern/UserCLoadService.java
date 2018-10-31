package designpattern.strategypattern;

public class UserCLoadService implements IdentityLoadService {
    @Override
    public String doService() {
        //读取数据库等等操作，准备财务部门数据
        prepareDataForFinance();
        //财务部门所独有的业务处理
        financeOtherService();
        //返回成功页面
        return "FINANCE";
    }

    private void financeOtherService() {
        System.out.println("finance other service...");
    }

    private void prepareDataForFinance() {
        System.out.println("prepare data for finance...");
    }
}