package randomIdea.sidemover.cards;

import randomIdea.sidemover.places.Block;
import randomIdea.sidemover.places.Placement;
import randomIdea.sidemover.coordinate.Vector2;

public class BlockCard extends Card{

    public BlockCard() {
        symbol = "[B]";
    }

    @Override
    public boolean selectionShow() {
//        TODO: input position data
        Vector2 position = new Vector2(2,4); // dummy position data

        return false;
    }

    @Override
    public void UseCard(Vector2 position) {
        Placement plc = new Block(position, hitPoint, false);
    }



}
