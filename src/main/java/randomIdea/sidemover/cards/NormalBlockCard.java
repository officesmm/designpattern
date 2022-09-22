package randomIdea.sidemover.cards;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.places.NormalBlock;
import randomIdea.sidemover.places.abstracts.Placement;

public class NormalBlockCard extends BlockCard{
    public NormalBlockCard(int hitPoint) {
        super(hitPoint);
    }
    @Override
    public Placement UseCard(Vector2 position) {
        Placement plc = new NormalBlock(this, position);
        return plc;
    }
}
