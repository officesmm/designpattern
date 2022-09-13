package randomIdea.sidemover.Places;

import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.interfaces.IDestroyable;

public class Block extends Placement implements IDestroyable {

    public int hitPoint;

    private boolean hittable;

    public Block( Vector2 position, int hitPoint, boolean hittable) {
        this.hitPoint = hitPoint;
        this.position = position;
        this.hittable = hittable;
    }

    @Override
    public boolean allowHit() {
        return hittable;
    }

    @Override
    public void selectionShow() {

    }
}
