package randomIdea.sidemover._core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.cards.BlockCard;
import randomIdea.sidemover.cards.Card;
import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.cards.PowerCard;
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
        ShowBoard();

        PLAYER = new Player();
        PLAYER.init();
        ShowCard();
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
                    playerSelectionHero();
                } else {
                    System.out.println("You cannot select this.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please select the valid character.");
            }
        }
    }

    public static void playerSelectionHero() throws IOException {
        System.out.println(PLACEMENT_SELECTION.symbol + PLACEMENT_SELECTION.position.display() + " has been selected.");
        System.out.println("1 for move, 2 for shot");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println("1 for →, 2 for ←, 3 for ↓, 4 for ↑");
        String input2 = br.readLine();

        switch (input) {
            case "1":
                ((Hero) PLACEMENT_SELECTION).move(MAINBOARD, Vector2.DirectionMapper(input2));
                break;
            case "2":
                Bullet bullet = ((Hero) PLACEMENT_SELECTION).shoot(Vector2.DirectionMapper(input2));
                OnCollisionEnter(bullet);
                break;
            default:
                break;
        }
        ShowAllStatus();
    }

    private static void playerSelectionCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (PLAYER.deck.size() == 0) {
            System.out.println("Nothing to select for the Card");
        } else {
            System.out.println("Here are the Cards to select");
            for (int i = 0; i < PLAYER.deck.size(); i++) {
                System.out.println(i + ". " + PLAYER.deck.get(i).symbol);
            }
            String input = br.readLine();
            try {
                CARD_SELECTION = PLAYER.deck.get(Integer.getInteger(input));
                if (CARD_SELECTION instanceof BlockCard) {
                    // TODO: 16/09/2022 choose position
                    // TODO: check position available
                    // TODO: available use / not return error
                } else if (CARD_SELECTION instanceof HeroCard) {
                    // TODO: 16/09/2022
                    // TODO: check 3, 1 is available
                    // TODO: available use / not available return error
                } else if (CARD_SELECTION instanceof PowerCard) {
                    // TODO: 16/09/2022
                    // TODO: check hero exist
                    // TODO: exist choose hero and use / not exist return error
                }
                CARD_SELECTION.UseCard(new Vector2(1, 2));
            } catch (Exception e) {
                System.out.println("Please select the valid cards");
            }
        }
    }

    public static Vector2 RequestLocation() throws IOException {
        boolean errorOccur = false;
        Vector2 v2 = null;
        do {
            System.out.println("Please select the location");
            System.out.print("x : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputX = br.readLine();
            System.out.print("y : ");
            String inputY = br.readLine();
            try {
                v2 = new Vector2(Integer.parseInt(inputX), Integer.parseInt(inputY));
                errorOccur = false;
            } catch (Exception e) {
                errorOccur = true;
            }
        } while (errorOccur);
        return v2;
    }

    public static boolean LocationAvailable(Vector2 vector2){
        for (int i = 0; i < MAINBOARD.boardItem.size(); i++) {
            if (Vector2.CheckingSamePosition(MAINBOARD.boardItem.get(i).position, vector2)){
                return false;
            }
        }
        return true;
    }

    public static boolean OnCollisionEnter(Bullet bullet) {
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

    public static void ShowBoard() {
        MAINBOARD.TESTINPUT();
        MAINBOARD.show();
    }

    public static void ShowCard() {
        PLAYER.show();
    }

    public static void ShowAllStatus() {
        MAINBOARD.show();
        PLAYER.show();
    }

}
