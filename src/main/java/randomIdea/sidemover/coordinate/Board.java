package randomIdea.sidemover.coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.cards.NormalBlockCard;
import randomIdea.sidemover.cards.SpecialBlockCard;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.Placement;

public class Board {
    public final int BoardSizeX = 5;
    public final int BoardSizeY = 5;

    public List<Placement> boardItem = new ArrayList<Placement>(); // board should be singleton class
    public Placement[] boardItems = new Placement[BoardSizeX * BoardSizeY];

    public Placement getBoardItems(int x, int y) {
        int specialX = Math.abs(Math.abs(x - BoardSizeX) - 1);
        int specialY = Math.abs(y - 1);
        return boardItems[specialX * BoardSizeX + specialY];
    }

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
                if (boardItem.size() == 0) {
                    System.out.print(" . ");
                } else {
                    if (!flagItemExist) {
                        System.out.print(" . ");
                    } else {
                        if (Vector2.CheckingSamePosition(boardItem.get(boardItemCounter).position, new Vector2(loopX, loopY))) {
                            System.out.print(" " + boardItem.get(boardItemCounter).symbol + " ");
                            boardItemCounter++;
                            if (boardItemCounter >= boardItem.size()) {
                                flagItemExist = false;
                            }
                        } else {
                            System.out.print(" . ");
                        }
                    }
                }
            }
            System.out.println();
        }

        System.out.println("----- MAP -----");
        for (int i = 0; i < boardItem.size(); i++) {
            System.out.println("- " + boardItem.get(i).symbol + boardItem.get(i).position.display());
        }
        System.out.println();
    }
}
