package randomIdea.sidemover.Places;

import randomIdea.sidemover.Cards.HeroCard;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IMovable;
import randomIdea.sidemover.interfaces.IShootable;

public class Hero extends Placement implements IShootable, IMovable {
    HeroCard pc;

    public Hero(HeroCard pc) {
        this.pc = pc;
        position = new Vector2(3,1);
        symbol = "H";
    }

    @Override
    public void shoot(Vector2.Directions direction) {

    }

    @Override
    public void move(Vector2.Directions direction) {

    }

    @Override
    public void selectionShow() {

    }

}
