package designpattern.strategypattern;

public class UserBLoadService implements IdentityLoadService {
    @Override
    public String doService() {
        //读取数据库等等操作，准备销售部门数据
        prepareDataForSale();
        //销售部门所独有的业务处理
        saleOtherService();
        //返回成功页面
        return "SALE";
    }

    private void saleOtherService() {
        System.out.println("sale other service...");
    }

    private void prepareDataForSale() {
        System.out.println("prepare data for sale...");
    }
}