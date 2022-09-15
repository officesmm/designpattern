package randomIdea.sidemover.interfaces;

import javax.swing.*;

import randomIdea.sidemover.coordinate.Vector2;

public interface IMovable extends IAction {
    public void move(Vector2.Directions direction);
}
