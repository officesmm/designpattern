package randomIdea.sidemover._Core;

import com.sun.xml.internal.bind.v2.TODO;

import behavioral._23memento.Caretaker;
import behavioral._23memento.Originator;
import randomIdea.sidemover.coordinate.Board;
import randomIdea.sidemover.design.Singleton;

public class _MainSideMover {
    static Board _MAINBOARD;
    static Player player;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

//        TODO: Create random 6 cards - player block power 2 for each
        // TODO: 13/09/2022 create board size and board array list
        init();
//        TODO: Start Loop for player to drop Block
//        TODO:


    }

    public static void init() throws InstantiationException, IllegalAccessException {
        _MAINBOARD = Singleton.getInstance(Board.class);
        showBoard();

        player = new Player();
        player.init();
        showCard();
    }


    public static void showBoard(){
//        _MAINBOARD.TESTINPUT();
        _MAINBOARD.show();
    }

    public static void showCard(){
        player.show();
    }


    public static void shot() {

    }
}
