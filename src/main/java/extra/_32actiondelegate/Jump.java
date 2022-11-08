package extra._32actiondelegate;

import extra._32actiondelegate.Action;

public class Jump implements Action {
    @Override
    public void doAction() {
        System.out.println("I am jumping");
    }
}
