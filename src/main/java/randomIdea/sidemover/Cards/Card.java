package randomIdea.sidemover.Cards;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.ISelectable;

public abstract class Card implements ISelectable {
    public int hitPoint;

    public int placeCost;
    public int moveCost;
    public int shotCost;

    public Card() {
    }

    public abstract void UseCard(Vector2 position);
}
