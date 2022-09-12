package behavioral._22mediator;

class User1 extends Participant {

    private String name;
    private ApnaChatRoom chat;

    @Override
    public void sendMsg(String msg) {
        chat.showMsg(msg, this);

    }

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public User1(ApnaChatRoom chat) {
        this.chat = chat;
    }

}// End of the User1 class.

class User2 extends Participant {

    private String name;
    private ApnaChatRoom chat;

    @Override
    public void sendMsg(String msg) {
        this.chat.showMsg(msg, this);

    }

    @Override
    public void setname(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public User2(ApnaChatRoom chat) {
        this.chat = chat;
    }


}
// End of the User2 class.