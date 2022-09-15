package randomIdea.sidemover.places;

import randomIdea.sidemover.cards.BlockCard;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IDestroyable;

public class NormalBlock extends Block implements IDestroyable {

    public NormalBlock(BlockCard card, Vector2 position) {
        super(card, position);
    }

    @Override
    public int hit(int damage) {
        card.hitPoint -= damage;
        return card.hitPoint;
    }

    @Override
    public boolean isDead() {
        return (card.hitPoint <= 0);
    }
}
