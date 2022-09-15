package randomIdea.sidemover.interfaces;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.coordinate.Vector2;

public interface IShootable extends IAction{

    public Bullet shoot(Vector2.Directions direction);
}
