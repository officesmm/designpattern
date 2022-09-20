package randomIdea.sidemover.interfaces;

import javax.swing.*;

import randomIdea.sidemover.coordinate.Board;
import randomIdea.sidemover.coordinate.Vector2;

public interface IMovable {
    public Vector2 move(Board board, Vector2.Directions direction);
}
