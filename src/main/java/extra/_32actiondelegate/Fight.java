package extra._32actiondelegate;

public class Fight implements Action{

    private String target;
    public Fight(String target) {
        this.target = target; // this may be enemy
    }

    @Override
    public void doAction() {
        System.out.println("I am Fighting to " + target);
    }
}
