package randomIdea.sidemover.cards;

import randomIdea.sidemover.cards.abstracts.Card;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.abstracts.Placement;

public class HeroCard extends Card {
    public int damage;

    public HeroCard(int hitPoint, int damage) {
        this.hitPoint = hitPoint;
        this.damage = damage;
        symbol = "[H]";
        placeCost = 2;
        shotCost = 2;
    }

    @Override
    public boolean selectionShow() {

        return false;
    }

    @Override
    public Placement UseCard(Vector2 position) {
        Placement plc = new Hero(this);
        return plc;
    }
}
