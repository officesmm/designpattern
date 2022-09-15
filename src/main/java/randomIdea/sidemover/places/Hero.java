package randomIdea.sidemover.places;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.coordinate.Board;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IDestroyable;
import randomIdea.sidemover.interfaces.IMovable;
import randomIdea.sidemover.interfaces.ISelectable;
import randomIdea.sidemover.interfaces.IShootable;

public class Hero extends Placement implements IShootable, IMovable, IDestroyable, ISelectable {

    public Hero(HeroCard card) {
        this.card = card;
        position = new Vector2(3, 1);
        symbol = "H";
    }

    @Override
    public Bullet shoot(Vector2.Directions direction) {
        return new Bullet(position, direction, 2);
    }

    @Override
    public void move(Board board, Vector2.Directions direction) {
        position = Vector2.Move(board, position, direction);
    }

    @Override
    public boolean selectionShow() {
        return false;
    }

    @Override
    public int hit(int damage) {
        return 0;
    }

    @Override
    public boolean isDead() {
        return false;
    }

}
