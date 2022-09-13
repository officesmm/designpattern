package randomIdea.sidemover.Places;

import randomIdea.sidemover.Cards.HeroCard;
import randomIdea.sidemover.coordinate.Direction;
import randomIdea.sidemover.interfaces.IMovable;
import randomIdea.sidemover.interfaces.IShootable;

public class Hero extends Placement implements IShootable, IMovable {
   HeroCard pc;

    public Hero(HeroCard pc) {
        this.pc = pc;
    }

    @Override
    public void shoot(Direction.Directions direction) {

    }

    @Override
    public void move(Direction.Directions direction) {

    }
    @Override
    public void selectionShow() {

    }
}
