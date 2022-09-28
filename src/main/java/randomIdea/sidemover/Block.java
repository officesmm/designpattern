package randomIdea.sidemover;

public abstract class Block extends Placement {

    public Block(BlockCard card, Vector2 position) {
        this.card = card;
        this.position = position;
        symbol = "B";
    }

}
