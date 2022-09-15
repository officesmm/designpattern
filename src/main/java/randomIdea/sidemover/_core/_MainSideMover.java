package randomIdea.sidemover._core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.cards.Card;
import randomIdea.sidemover.interfaces.IDestroyable;
import randomIdea.sidemover.interfaces.ISelectable;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.Placement;
import randomIdea.sidemover.coordinate.Board;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.design.Singleton;

public class _MainSideMover {
    static Board MAINBOARD;
    static Player PLAYER;

    static Placement PLACEMENT_SELECTION;
    static Card CARD_SELECTION;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {

//        TODO: Create random 6 cards - player block power 2 for each
        // TODO: 13/09/2022 create board size and board array list
        init();
//        TODO: Start Loop for player to drop Block
//        TODO: Lose and win state
        while (true) {
            playerAction();
        }
    }

    public static void init() throws InstantiationException, IllegalAccessException {
        MAINBOARD = Singleton.getInstance(Board.class);
        showBoard();

        PLAYER = new Player();
        PLAYER.init();
        showCard();
    }

    public static void playerAction() throws IOException {
        System.out.println("Select an action 1 for MAP 2 for CARD");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        switch (input) {
            case "1":
                playerSelectionMap();
                break;
            case "2":
                playerSelectionCard();
                break;
            default:
                break;
        }
    }

    public static void playerSelectionMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (MAINBOARD.boardItem.size() == 0) {
            System.out.println("Nothing to select on the map");
        } else {
            System.out.println("Select a hero on the map");
            for (int i = 0; i < MAINBOARD.boardItem.size(); i++) {
                if (MAINBOARD.boardItem.get(i) instanceof ISelectable) {
                    System.out.println("Type " + i + " if you want to select " + MAINBOARD.boardItem.get(i).symbol + MAINBOARD.boardItem.get(i).position.display());
                }
            }
            String input = br.readLine();
            try {
                PLACEMENT_SELECTION = MAINBOARD.boardItem.get(Integer.parseInt(input));
                if (PLACEMENT_SELECTION instanceof ISelectable) {
                    playerSelectionCard();
                }else {
                    System.out.println("You cannot select this.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please select the valid character.");
            }
        }
    }

    public static void playerSelectionCard() throws IOException {
        System.out.println(PLACEMENT_SELECTION.symbol + PLACEMENT_SELECTION.position.display() + " has been selected.");
        System.out.println("1 for move, 2 for shot");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println("1 for →, 2 for ←, 3 for ↓, 4 for ↑");
        String input2 = br.readLine();

        switch (input) {
            case "1":
                ((Hero) PLACEMENT_SELECTION).move(MAINBOARD, directionMapper(input2));
                break;
            case "2":
                Bullet bullet = ((Hero) PLACEMENT_SELECTION).shoot(directionMapper(input2));
                onCollisionEnter(bullet);
                break;
            default:
                break;
        }
        showAllStatus();
    }

    public static boolean onCollisionEnter(Bullet bullet) {
        for (int m = 0; m < bullet.bulletRange; m++) {
            bullet.move();
            System.out.println("bullet is moving to " + bullet.position.display());
            for (int i = 0; i < MAINBOARD.boardItem.size(); i++) {
                if (Vector2.CheckingSamePosition(MAINBOARD.boardItem.get(i).position, bullet.position)) {
                    if (MAINBOARD.boardItem.get(i) instanceof IDestroyable) {
                        IDestroyable iDestroyable = ((IDestroyable) MAINBOARD.boardItem.get(i));
                        iDestroyable.hit(bullet.damage);
                        if (iDestroyable.isDead()) {
                            System.out.println("Bullet hit " + MAINBOARD.boardItem.get(i).symbol +
                                    MAINBOARD.boardItem.get(i).position.display() +
                                    " and dead.");
                            MAINBOARD.boardItem.remove(i);
                        } else {
                            System.out.println("Bullet hit " + MAINBOARD.boardItem.get(i).symbol +
                                    MAINBOARD.boardItem.get(i).position.display() +
                                    " and " +
                                    MAINBOARD.boardItem.get(i).card.hitPoint + " hitPoint left.");
                        }
                    } else {
                        System.out.println("Bullet hit a random item that is not destroyable");
                    }
                    return true;
                }
            }
        }
        System.out.println("A bullet has release and nothing hit ");
        return false;
    }

    public static void showBoard() {
        MAINBOARD.TESTINPUT();
        MAINBOARD.show();
    }

    public static void showCard() {
        PLAYER.show();
    }

    public static void showAllStatus() {
        MAINBOARD.show();
        PLAYER.show();
    }

    private static Vector2.Directions directionMapper(String num) {
        switch (num) {
            case "1":
                return Vector2.Directions.EAST;
            case "2":
                return Vector2.Directions.WEST;
            case "3":
                return Vector2.Directions.SOUTH;
            case "4":
                return Vector2.Directions.NORTH;
        }
        return null;
    }

}
