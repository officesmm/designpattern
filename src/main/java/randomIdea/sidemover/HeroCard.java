package randomIdea.sidemover;

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
