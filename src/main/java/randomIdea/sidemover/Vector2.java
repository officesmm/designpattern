package randomIdea.sidemover;

public class Vector2 {
    public int x;
    public int y;

    public static enum Directions {
        EAST, WEST, SOUTH, NORTH
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String display() {
        return "(" + x + ", " + y + ")";
    }

    public static Vector2 Move(Board board, Vector2 vector2, Directions direction) {
        Vector2 newPosition = null;
        switch (direction) {
            case EAST:
                newPosition = new Vector2(vector2.x + 1, vector2.y);
                break;
            case WEST:
                newPosition = new Vector2(vector2.x - 1, vector2.y);
                break;
            case SOUTH:
                newPosition = new Vector2(vector2.x, vector2.y - 1);
                break;
            case NORTH:
                newPosition = new Vector2(vector2.x, vector2.y + 1);
                break;
        }
        if(board != null){
            for (int i = 0; i < board.boardItem.size(); i++) {
                if ((CheckingSamePosition(newPosition, board.boardItem.get(i).position)) || (!isInsideMap(newPosition, board.BoardSizeX, board.BoardSizeY))) {
                    System.out.println("Debug: return Null by Vector 2: " + board.boardItem.get(i).position.display());
                    return null;
                }
            }
        }
        return newPosition;
    }

    public static boolean CheckingSamePosition(Vector2 pos1, Vector2 pos2) {
        return ((pos1.x == pos2.x) && (pos1.y == pos2.y));
    }
    public static boolean isInsideMap(Vector2 pos, int MapBoundaryX, int MapBoundaryY) {
        return (pos.x <= MapBoundaryX && pos.x >= 1 && pos.y <= MapBoundaryY && pos.y >= 1 );
    }

    public static Vector2.Directions DirectionMapper(String num) {
        switch (num) {
            case "1":
                return Directions.EAST;
            case "2":
                return Directions.WEST;
            case "3":
                return Directions.SOUTH;
            case "4":
                return Directions.NORTH;
        }
        return null;
    }

}
