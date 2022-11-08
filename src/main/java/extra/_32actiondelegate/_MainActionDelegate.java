package extra._32actiondelegate;

public class _MainActionDelegate { // this might be input from keyboard and mouse
    public static void main(String[] args) {
        ActionDelegate actionDelegate = new ActionDelegate();
        Player client = new Player(actionDelegate);

        actionDelegate.setActionType("EJB");
        client.doAction();

        actionDelegate.setActionType("JMS");
        client.doAction();

    }

    private static void rightMouseClick() {

    }
    private static void leftMouseClick() {
        ActionDelegate actionDelegate = new ActionDelegate();
        Player client = new Player(actionDelegate);
        actionDelegate.setActionType("EJB");
        client.doAction();
    }
}
