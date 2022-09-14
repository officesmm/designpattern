package randomIdea.sidemover._Core;

import java.util.ArrayList;
import java.util.List;

import randomIdea.sidemover.Cards.BlockCard;
import randomIdea.sidemover.Cards.Card;
import randomIdea.sidemover.Cards.HeroCard;
import randomIdea.sidemover.Cards.PowerCard;
import randomIdea.sidemover.interfaces.ISelectable;

public class Player {

    List<Card> deck = new ArrayList<Card>();

    public void init() {
        creation();
    }

    public void select(ISelectable selection) {
        selection.selectionShow();
    }

    public void action() {

    }

    void creation() {
        deck.add(new BlockCard());
        deck.add(new BlockCard());
        deck.add(new HeroCard(3, 2));
        deck.add(new HeroCard(3, 2));
        deck.add(new PowerCard());
        deck.add(new PowerCard());
    }

    void show() {
        System.out.println("----- CARDS -----");
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.get(i).symbol);
        }
        System.out.println();
        System.out.println("----- CARDS -----");
        System.out.println();
    }
}
