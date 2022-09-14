package randomIdea.sidemover.Cards;

import randomIdea.sidemover.Places.Placement;
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
    public void selectionShow() {
        // TODO: 13/09/2022 select hero;
        UseCard(null);
    }

    @Override
    public void UseCard(Vector2 position) {
        usePower(hero);
    }

}