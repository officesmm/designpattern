package randomIdea.sidemover.places;

import randomIdea.sidemover.cards.BlockCard;
import randomIdea.sidemover.coordinate.Vector2;

public abstract class Block extends Placement {

    public Block(BlockCard card, Vector2 position) {
        this.card = card;
        this.position = position;
        symbol = "B";
    }

}
