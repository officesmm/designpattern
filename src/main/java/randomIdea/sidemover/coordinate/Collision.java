package randomIdea.sidemover.coordinate;

import randomIdea.sidemover.places.Placement;

public class Collision {

    public Board board;

    public Collision(Board board) {
        this.board = board;
    }


    public boolean onCollisionEnter(Placement other){

        return true;
    }
}
