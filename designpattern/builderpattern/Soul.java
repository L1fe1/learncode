package designpattern.builderpattern;

//灵魂类，指挥者
public class Soul {

    public Doppelganger createDoppelganger(DoppelgangerBuilder doppelgangerBuilder,String name){
        doppelgangerBuilder.createDoppelganger(name);
        doppelgangerBuilder.buildBody();
        doppelgangerBuilder.buildHead();
        doppelgangerBuilder.buildLeftArm();
        doppelgangerBuilder.buildLeftHand();
        doppelgangerBuilder.buildRightArm();
        doppelgangerBuilder.buildRightHand();
        doppelgangerBuilder.buildLeftLeg();
        doppelgangerBuilder.buildLeftFoot();
        doppelgangerBuilder.buildRightLeg();
        doppelgangerBuilder.buildRightFoot();
        return doppelgangerBuilder.getDoppelganger();
    }

}
