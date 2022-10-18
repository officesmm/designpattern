package behavioral._28template;

public class _MainTemplate {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class c = Class.forName("behavioral._28template.Chess");
        Game game = (Game) c.newInstance();
        game.play();
    }
}
