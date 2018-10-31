package designpattern.strategypattern;

@TotalValidRegion(@ValidRegion(min=2000,max=3000,order=99))
public class SuperVip implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }
}
