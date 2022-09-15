package randomIdea.sidemover.places;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IDestroyable;

public class Block extends Placement implements IDestroyable {


    private boolean hittable;

    public Block( Vector2 position, int hitPoint, boolean hittable) {
        this.hitPoint = hitPoint;
        this.position = position;
        this.hittable = hittable;
        symbol = "B";
    }

    @Override
    public boolean allowHit() {
        return hittable;
    }

    @Override
    public boolean selectionShow() {

        return false;
    }
}
