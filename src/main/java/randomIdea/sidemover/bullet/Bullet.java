package randomIdea.sidemover.bullet;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.Placement;

public class Bullet extends Placement {
    Vector2.Directions direction;
    public int damage;
    public int bulletRange;

    public Bullet(Vector2 startPosition, Vector2.Directions direction, int damage) {
        this.position = startPosition;
        this.direction = direction;
        this.damage = damage;
        this.bulletRange = 5;
        symbol = "o";
    }

    public Bullet(Vector2 startPosition, Vector2.Directions direction, int damage, int bulletRange) {
        this.position = startPosition;
        this.direction = direction;
        this.damage = damage;
        this.bulletRange = bulletRange;
        symbol = "o";
    }


    @Override
    public boolean selectionShow() {
        return false;
    }

    public void move() {
        position = Vector2.Move(position, direction);
    }
}
