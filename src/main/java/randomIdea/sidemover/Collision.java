package randomIdea.sidemover;

public class Collision {

    public Board board;

    public Collision(Board board) {
        this.board = board;
    }


    public boolean onCollisionEnter(Placement other){

        return true;
    }

    private static boolean CheckingSamePosition(Vector2 pos1, Vector2 pos2) {
        return (pos1.x == pos2.x && pos1.y == pos2.y);
    }
}
