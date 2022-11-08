package extra._32actiondelegate;

import extra._31businessdelegate.BusinessDelegate;

public class Player {

    ActionDelegate actionDelegate;

    public Player(ActionDelegate actionDelegate) {
        this.actionDelegate = actionDelegate;
    }

    public void doAction() {
        actionDelegate.doAction();
    }
}
