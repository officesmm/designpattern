package randomIdea.sidemover.cards;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.Placement;

public class HeroCard extends Card {
    public int damage;

    public HeroCard(int hitPoint, int damage) {
        this.hitPoint = hitPoint;
        this.damage = damage;
        symbol = "[H]";
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
