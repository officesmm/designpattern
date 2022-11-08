package extra._32actiondelegate;

import extra._31businessdelegate.EJBService;
import extra._31businessdelegate.JMSService;

public class ActionLookUp {
    public Action getAction(String input) {
        if (input.equalsIgnoreCase("fighting")) {
            return new Fight("enemy");
        } else {
            return new Jump();
        }
    }
    public Action getAction(int target) {
        if (target > 1) {
            return new Fight("enemy");
        } else {
            return new Fight("block");
        }
    }
}
