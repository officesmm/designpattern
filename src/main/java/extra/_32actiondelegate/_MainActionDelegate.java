package extra._32actiondelegate;

public class _MainActionDelegate { // this might be input from keyboard and mouse
    static ActionDelegate actionDelegate;
    static Player player;

    public static void main(String[] args) {
        actionDelegate = new ActionDelegate();
        player = new Player(actionDelegate);
        rightMouseClick();
//        leftMouseClick();
    }

    private static void rightMouseClick() {
        actionDelegate.setActionType("Fight");
        player.doAction();
    }
    private static void leftMouseClick() {
        actionDelegate.setActionType("Move");
        player.doAction();
    }
}
