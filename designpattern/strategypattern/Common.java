package designpattern.strategypattern;

//我们使用嵌套注解，并且制定我们打折的各个策略顺序是99，这算是很靠后的
//因为我们最后打折算出来钱是最多的
@TotalValidRegion(@ValidRegion(max=1000,order=99))//设置普通的在0-1000生效
public class Common implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}
