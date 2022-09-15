package randomIdea.sidemover.places;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.ISelectable;

public abstract class Placement implements ISelectable {

    public int hitPoint;
    public Vector2 position;
    public String symbol;
}
