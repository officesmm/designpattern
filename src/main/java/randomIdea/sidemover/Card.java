package randomIdea.sidemover;

public abstract class Card implements ISelectable {
    public int hitPoint;

    public int placeCost = 1;
    public int moveCost = 1;
    public int shotCost = 1;

    public String symbol;

    public Card() {
    }

    public abstract Placement UseCard(Vector2 position);

}
