package designpattern.commandpattern;

public class Bug implements Task{

    private Programmer programmer;

    public Bug(Programmer programmer) {
        super();
        this.programmer = programmer;
    }

    @Override
    public void handle() {
        programmer.handleBug();
    }

    @Override
    public String toString() {
        return "Bug [programmer=" + programmer.getName() + "]";
    }
}
