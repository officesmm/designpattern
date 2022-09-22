package randomIdea.sidemover.cards;

import randomIdea.sidemover.cards.abstracts.Card;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.abstracts.Placement;
import randomIdea.sidemover.coordinate.Vector2;

public class PowerCard extends Card {

    public int upgradeHitPoint;
    public int upgradeDamage;
    public String effectText;

    public PowerCard(int upgradeHitPoint, int upgradeDamage, String effectText) {
        this.upgradeHitPoint = upgradeHitPoint;
        this.upgradeDamage = upgradeDamage;
        this.effectText = effectText;
        symbol = "[P]";
    }

    public PowerCard(String effectText) {
        this.upgradeHitPoint = 1;
        this.upgradeDamage = 0;
        this.effectText = effectText;
        symbol = "[P]";
    }

    public PowerCard() {
        this.upgradeHitPoint = 1;
        this.upgradeDamage = 0;
        this.effectText = "Upgrading HitPoint";
        symbol = "[P]";
    }

    public String usePower(Hero hero) {
        hero.card.hitPoint +=upgradeHitPoint;
        hero.card.hitPoint +=upgradeDamage;
        return effectText;
    }

    @Override
    public boolean selectionShow() {
        // TODO: 13/09/2022 select hero;
        UseCard(null);
        return false;
    }

    @Override
    public Placement UseCard(Vector2 position) {
        return null;
    }

}