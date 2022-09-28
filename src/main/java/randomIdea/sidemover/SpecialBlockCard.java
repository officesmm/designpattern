package randomIdea.sidemover;

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
}
