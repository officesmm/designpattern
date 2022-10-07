package behavioral._26state;

public class _MainState {

    Controller controller;

    _MainState(String con) {
        controller = new Controller();
        //the following trigger should be made by the user
        if (con.equalsIgnoreCase("management"))
            controller.setManagementConnection();
        if (con.equalsIgnoreCase("sales"))
            controller.setSalesConnection();
        if (con.equalsIgnoreCase("accounting"))
            controller.setAccountingConnection();
        controller.open();
        controller.log();
        controller.close();
        controller.update();
    }

    public static void main(String args[]) {
        new _MainState("sales");
    }
}
