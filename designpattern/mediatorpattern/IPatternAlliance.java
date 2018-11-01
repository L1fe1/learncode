package designpattern.mediatorpattern;

//模式联盟，中介者接口
public interface IPatternAlliance {
    //加入联盟
    void add(School school);

    //联盟攻击
    void resolveAttack(School activeSide, School passiveSide);

    //联盟防御
    void resolveDefense(School passiveSide);
}
