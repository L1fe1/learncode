package designpattern.strategypattern;

@OnceValidRegion(@ValidRegion(min=1000,max=2000,order=40))
public class OneTDTwoH implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 200;
    }
}
