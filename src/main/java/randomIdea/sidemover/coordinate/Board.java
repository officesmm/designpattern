package randomIdea.sidemover.coordinate;

import java.util.ArrayList;
import java.util.List;

import randomIdea.sidemover.cards.BlockCard;
import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.cards.NormalBlockCard;
import randomIdea.sidemover.cards.SpecialBlockCard;
import randomIdea.sidemover.places.Block;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.NormalBlock;
import randomIdea.sidemover.places.Placement;
import randomIdea.sidemover.places.SpecialBlock;

public class Board {
    public final int BoardSizeX = 5;
    public final int BoardSizeY = 5;

    public List<Placement> boardItem = new ArrayList<Placement>(); // board should be singleton class

    public void init() {

    }

    public void TESTINPUT() {

//        boardItem.add(new SpecialBlock(new Vector2(2, 3), 3));
        boardItem.add(new SpecialBlockCard().UseCard(new Vector2(2, 3)));
        boardItem.add(new NormalBlockCard(5).UseCard(new Vector2(4, 3)));
        boardItem.add(new Hero(new HeroCard(3, 2)));
    }

    public void show() {
        System.out.println("----- MAP -----");
        int boardItemCounter = 0;
        boolean flagItemExist = true;
        for (int loopY = BoardSizeY; loopY > 0; loopY--) {
            for (int loopX = 1; loopX <= BoardSizeX; loopX++) {
                if (!flagItemExist || boardItem.size() == 0) {
                    System.out.print(" _ ");
                } else {
                    if (boardItem.get(boardItemCounter).position.x == loopX && boardItem.get(boardItemCounter).position.y == loopY) {
                        System.out.print(" " + boardItem.get(boardItemCounter).symbol + " ");
                        boardItemCounter++;
                        if (boardItemCounter >= boardItem.size()) {
                            flagItemExist = false;
                        }
                    } else {
                        System.out.print(" _ ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("----- MAP -----");
        System.out.println();
    }
}
