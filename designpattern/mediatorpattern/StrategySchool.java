package designpattern.mediatorpattern;

public class StrategySchool extends School{

    public StrategySchool(IPatternAlliance patternAlliance) {
        super(patternAlliance);
    }

    @Override
    public String getName() {
        return "策略宫";
    }

}
