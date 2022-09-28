package randomIdea.sidemover._core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import randomIdea.sidemover.bullet.Bullet;
import randomIdea.sidemover.cards.BlockCard;
import randomIdea.sidemover.cards.abstracts.Card;
import randomIdea.sidemover.cards.HeroCard;
import randomIdea.sidemover.cards.PowerCard;
import randomIdea.sidemover.interfaces.IDestroyable;
import randomIdea.sidemover.interfaces.ISelectable;
import randomIdea.sidemover.places.Hero;
import randomIdea.sidemover.places.abstracts.Placement;
import randomIdea.sidemover.coordinate.Board;
import randomIdea.sidemover.coordinate.Vector2;
import randomIdea.sidemover.design.Singleton;

public class _MainSideMover {
    public static Board MAINBOARD;
    public static Player PLAYER;

    static Placement PLACEMENT_SELECTION;
    static Card CARD_SELECTION;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        init();
        while (true) { // until game over
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
                PLACEMENT_SELECTION = SelectingHeroOnMap();
                playerSelectionMapHero();
                break;
            case "2":
                playerSelectionCard();
                break;
            default:
                break;
        }
    }

    public static void playerSelectionMapHero() throws IOException {
        System.out.println(PLACEMENT_SELECTION.symbol + PLACEMENT_SELECTION.position.display() + " has been selected.");
        System.out.println("1 for move, 2 for shot");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean actionSuccessMoveShot = false;
        do {
            System.out.println("1 for →, 2 for ←, 3 for ↓, 4 for ↑");
            String input2 = br.readLine();
            switch (input) {
                case "1":
                    if (PLAYER.Gem > PLACEMENT_SELECTION.card.moveCost) {
                        actionSuccessMoveShot = (((Hero) PLACEMENT_SELECTION).move(MAINBOARD, Vector2.DirectionMapper(input2)) != null);
                        if (actionSuccessMoveShot) {
                            PLAYER.Gem -= PLACEMENT_SELECTION.card.moveCost;
                            System.out.println("Gem cost to move : " + PLACEMENT_SELECTION.card.moveCost);
                            System.out.println("Remaining Gem : " + PLAYER.Gem);
                        } else {
                            System.out.println("Unable to move that way please try again.");
                        }
                    } else {
                        System.out.println("Gem not enough to perform this action.");
                        System.out.println("Require Gem : " + PLACEMENT_SELECTION.card.moveCost + ". Remaining Gem : " + PLAYER.Gem);
                    }
                    break;
                case "2":
                    if (PLAYER.Gem > PLACEMENT_SELECTION.card.shotCost) {
                        PLAYER.Gem -= PLACEMENT_SELECTION.card.shotCost;
                        Bullet bullet = ((Hero) PLACEMENT_SELECTION).shoot(Vector2.DirectionMapper(input2));
                        OnCollisionEnter(bullet);
                        System.out.println("Gem cost to shot : " + PLACEMENT_SELECTION.card.shotCost);
                        System.out.println("Remaining Gem : " + PLAYER.Gem);
                        actionSuccessMoveShot = true;
                    } else {
                        System.out.println("Gem not enough to perform this action.");
                        System.out.println("Require Gem : " + PLACEMENT_SELECTION.card.shotCost + ". Remaining Gem : " + PLAYER.Gem);
                    }
                    break;
                default:
                    break;
            }
        } while (!actionSuccessMoveShot);
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
                CARD_SELECTION = PLAYER.deck.get(Integer.parseInt(input));
            } catch (NullPointerException e) {
                System.out.println("Please select the valid cards" + e);
            } catch (NumberFormatException e) {
                System.out.println("Please type number to select the Card");
            }
            if (PLAYER.Gem > CARD_SELECTION.placeCost) {
                if (CARD_SELECTION instanceof BlockCard) {
                    Vector2 deployPosition = RequestLocation();
                    if (Vector2.CheckingSamePosition(deployPosition, new Vector2(3, 1))) {
                        System.out.println("Hero Entrance is not allow to set Block");
                    } else if (LocationAvailable(deployPosition)) {
                        MAINBOARD.boardItem.add(
                                CARD_SELECTION.UseCard(deployPosition));
                        System.out.println("New Block is added on " + deployPosition.display());
                    } else {
                        System.out.println("This location is not available");
                    }
                } else if (CARD_SELECTION instanceof HeroCard) {
                    if (LocationAvailable(new Vector2(3, 1))) {
                        MAINBOARD.boardItem.add(
                                CARD_SELECTION.UseCard(new Vector2(3, 1)));
                        System.out.println("New Hero is added on " + new Vector2(3, 1).display());
                    } else {
                        System.out.println("Remove the entrance Item to deploy new hero");
                    }
                } else if (CARD_SELECTION instanceof PowerCard) {
                    Hero hero = SelectingHeroOnMap();
                    String effect = ((PowerCard) CARD_SELECTION).usePower(hero);
                    System.out.println(effect + " is applied on " + hero.symbol + hero.position.display());
                    System.out.println("HitPoint : " + hero.card.hitPoint +
                            "\nDamage : " + ((HeroCard) hero.card).damage);
                } else {
                    System.out.println("ERROR: This card is unknown card");
                    ShowAllStatus();
                    return;
                }
                PLAYER.Gem -= CARD_SELECTION.placeCost;
                System.out.println("Gem cost to place card : " + CARD_SELECTION.placeCost);
                System.out.println("Remaining Gem : " + PLAYER.Gem);
                PLAYER.deck.remove(Integer.parseInt(input));
            } else {
                System.out.println("Gem not enough to perform this action.");
                System.out.println("Require Gem : " + CARD_SELECTION.placeCost + ". Remaining Gem : " + PLAYER.Gem);
            }
        }
        ShowAllStatus();
    }

    // Recurring Functions
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

    public static boolean LocationAvailable(Vector2 vector2) {
        for (int i = 0; i < MAINBOARD.boardItem.size(); i++) {
            if (Vector2.CheckingSamePosition(MAINBOARD.boardItem.get(i).position, vector2)) {
                return false;
            }
        }
        return true;
    }

    public static Hero SelectingHeroOnMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (MAINBOARD.boardItem.size() == 0) {
            System.out.println("Nothing to select on the map");
            return null;
        } else {
            System.out.println("Select a hero on the map");
            for (int i = 0; i < MAINBOARD.boardItem.size(); i++) {
                if (MAINBOARD.boardItem.get(i) instanceof ISelectable) {
                    System.out.println(i + ". if you want to select " + MAINBOARD.boardItem.get(i).symbol + MAINBOARD.boardItem.get(i).position.display());
                }
            }
            String input = br.readLine();
            try {
                if (MAINBOARD.boardItem.get(Integer.parseInt(input)) instanceof ISelectable) {
                    return (Hero) MAINBOARD.boardItem.get(Integer.parseInt(input));
                } else {
                    System.out.println("You cannot select this.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please select the valid character.");
            }
            return null;
        }
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
