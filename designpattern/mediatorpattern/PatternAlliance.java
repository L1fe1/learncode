package designpattern.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

//模式联盟，中介者
public class PatternAlliance implements IPatternAlliance{

    private List<School> schoolList;

    public PatternAlliance() {
        super();
        schoolList = new ArrayList<School>();
    }

    @Override
    public void add(School school) {
        schoolList.add(school);
    }

    @Override
    public void resolveAttack(School activeSide, School passiveSide) {
        if (schoolList.contains(activeSide) && schoolList.contains(passiveSide)) {
            System.out.println("主攻方" + activeSide.getName() + "以及被攻方" + passiveSide.getName() + "都已加入联盟，不允许内讧！");
        }else if (schoolList.contains(activeSide) && !schoolList.contains(passiveSide)) {
            System.out.println("主攻方" + activeSide.getName() + "已加入联盟，被攻方" + passiveSide.getName() + "不在联盟之中，将集体攻打该门派！");
            for (School school : schoolList) {
                school.attack(passiveSide);
            }
        }else {
            System.out.println("主攻方" + activeSide.getName() + "未加入联盟，联盟无权干预此事！");
            activeSide.attack(passiveSide);
        }
    }

    @Override
    public void resolveDefense(School passiveSide) {
        if (schoolList.contains(passiveSide)) {
            System.out.println("被攻方" + passiveSide.getName() + "已加入联盟，联盟将齐力防御！");
            for (School school : schoolList) {
                school.defense();
            }
        }else {
            System.out.println("被攻方" + passiveSide.getName() + "未加入联盟，联盟不给予防御帮助！");
            passiveSide.defense();
        }
    }
}
