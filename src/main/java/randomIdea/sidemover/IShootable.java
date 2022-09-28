package randomIdea.sidemover;

import randomIdea.sidemover.Bullet;
import randomIdea.sidemover.Vector2;

public interface IShootable{

    public Bullet shoot(Vector2.Directions direction);
}
