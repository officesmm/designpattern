package randomIdea.sidemover.Cards;

import randomIdea.sidemover.coordinate.Vector2;

public class HeroCard extends Card {
    public int damage;

    public HeroCard(int hitPoint, int damage) {
        this.hitPoint = hitPoint;
        this.damage = damage;
        symbol = "[H]";
    }

    @Override
    public void selectionShow() {

    }

    @Override
    public void UseCard(Vector2 position) {

    }
}
