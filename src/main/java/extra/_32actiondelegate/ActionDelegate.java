package extra._32actiondelegate;

public class ActionDelegate {
    private ActionLookUp lookupService = new ActionLookUp();
    private Action actionService;
    private String actionType;

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void doAction() {
        actionService = lookupService.getAction(actionType);
        actionService.doAction();
    }


}
