package randomIdea.sidemover.Cards;

import com.sun.xml.internal.bind.v2.TODO;

import randomIdea.sidemover.Places.Block;
import randomIdea.sidemover.Places.Placement;
import randomIdea.sidemover.coordinate.Vector2;

public class BlockCard extends Card{

    public BlockCard() {
        symbol = "[B]";
    }

    @Override
    public void selectionShow() {
//        TODO: input position data
        Vector2 position = new Vector2(2,4); // dummy position data

    }

    @Override
    public void UseCard(Vector2 position) {
        Placement plc = new Block(position, hitPoint, false);
    }



}
