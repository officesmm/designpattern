package randomIdea.sidemover;

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
