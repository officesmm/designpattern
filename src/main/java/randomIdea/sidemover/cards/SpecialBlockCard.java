package randomIdea.sidemover.cards;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.abstracts.Placement;
import randomIdea.sidemover.places.SpecialBlock;

public class SpecialBlockCard extends BlockCard {
    public SpecialBlockCard() {
        super(1);
        placeCost = 2;
    }

    @Override
    public Placement UseCard(Vector2 position) {
        Placement plc = new SpecialBlock(this, position);
        return plc;
    }

    @Override
    public String fullDescription() {
        return " (Special) "+" PlacementCost: " +placeCost;
    }
}
