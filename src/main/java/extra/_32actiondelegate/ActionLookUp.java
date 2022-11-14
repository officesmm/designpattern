package extra._32actiondelegate;

public class ActionLookUp {

    public Action getAction(String input) {
        if (input.equalsIgnoreCase("fight")) {
            return new Fight("enemy");
        } else {
            return new Move();
        }
    }

}
