package designpattern.bridgepattern;

//技能接口
public interface Skills {
    void releaseSkills();
}

//隐身技能
class Invisible implements Skills{

    public void releaseSkills(){
        System.out.println("释放隐身技能");
    }
}
//飞行技能
class Volant implements Skills{

    public void releaseSkills(){
        System.out.println("释放飞行技能");
    }
}
//读心术技能
class ReadMind implements Skills{

    public void releaseSkills(){
        System.out.println("释放读心术技能");
    }
}
