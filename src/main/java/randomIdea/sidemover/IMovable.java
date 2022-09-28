package randomIdea.sidemover;

import randomIdea.sidemover.Board;
import randomIdea.sidemover.Vector2;

public interface IMovable {
    public Vector2 move(Board board, Vector2.Directions direction);
}
