package randomIdea.sidemover;

public class KnockBackPowerCard extends PowerCard {

    public KnockBackPowerCard() {
        super("Knocking Backing");
    }

    public String usePower(Hero hero) {
        for (int i = 0; i < _MainSideMover.MAINBOARD.BoardSizeY; i++) {
            hero.move(_MainSideMover.MAINBOARD, Vector2.Directions.NORTH);
        }
        return effectText;
    }
}
