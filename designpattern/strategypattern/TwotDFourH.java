package designpattern.strategypattern;

@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class TwotDFourH implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 400;
    }
}
