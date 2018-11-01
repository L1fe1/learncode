package designpattern.commandpattern;

public class Problem implements Task{

    private Programmer programmer;

    public Problem(Programmer programmer) {
        super();
        this.programmer = programmer;
    }

    @Override
    public void handle() {
        programmer.handleProblem();
    }

    public String toString() {
        return "Problem [programmer=" + programmer.getName() + "]";
    }

}
