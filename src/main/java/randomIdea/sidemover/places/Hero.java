package randomIdea.sidemover.places;

import java.util.ArrayList;
import java.util.List;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IAction;
import randomIdea.sidemover.interfaces.IMovable;
import randomIdea.sidemover.interfaces.IShootable;

public class Hero extends Placement implements IShootable, IMovable {
    HeroCard pc;

    public Hero(HeroCard pc) {
        this.pc = pc;
        this.hitPoint = pc.hitPoint;
        position = new Vector2(3, 1);
        symbol = "H";
    }

    @Override
    public void doAction(Vector2.Directions direction) {
        move(direction);
    }
    @Override
    public Bullet shoot(Vector2.Directions direction) {
        return new Bullet(position, direction,2);
    }
    @Override
    public void move(Vector2.Directions direction) {
        position = Vector2.Move(position, direction);
    }
    @Override
    public boolean selectionShow() {
        return false;
    }

    public IAction selectionAction() {
        return this;
    }
}
