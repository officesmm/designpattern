package randomIdea.sidemover.cards;

import randomIdea.sidemover.places.Placement;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IConsumable;

public class PowerCard extends Card implements IConsumable {

    public Placement hero;

    public PowerCard() {
        symbol = "[P]";
    }

    @Override
    public void usePower(Placement hero) {

    }

    @Override
    public boolean selectionShow() {
        // TODO: 13/09/2022 select hero;
        UseCard(null);
        return false;
    }

    @Override
    public Placement UseCard(Vector2 position) {
        usePower(hero);
        return null;
    }

}