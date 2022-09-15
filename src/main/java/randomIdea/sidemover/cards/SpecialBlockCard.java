package randomIdea.sidemover.cards;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.NormalBlock;
import randomIdea.sidemover.places.Placement;
import randomIdea.sidemover.places.SpecialBlock;

public class SpecialBlockCard extends BlockCard{
    public SpecialBlockCard() {
        super(1);
    }

    @Override
    public Placement UseCard(Vector2 position) {
        Placement plc = new SpecialBlock(this, position);
        return plc;
    }
}
