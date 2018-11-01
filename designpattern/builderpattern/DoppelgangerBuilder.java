package designpattern.builderpattern;

// 分身制造者接口
public interface DoppelgangerBuilder {

    void createDoppelganger(String name);

    void buildBody();

    void buildHead();

    void buildLeftArm();

    void buildLeftHand();

    void buildRightArm();

    void buildRightHand();

    void buildLeftLeg();

    void buildLeftFoot();

    void buildRightLeg();

    void buildRightFoot();

    Doppelganger getDoppelganger();

}
