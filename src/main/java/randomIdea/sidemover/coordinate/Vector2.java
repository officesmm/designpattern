package randomIdea.sidemover.coordinate;

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
            case WEST:
                newPosition = new Vector2(vector2.x - 1, vector2.y);
            case SOUTH:
                newPosition = new Vector2(vector2.x, vector2.y - 1);
            case NORTH:
                newPosition = new Vector2(vector2.x, vector2.y + 1);
        }
        for (int i = 0; i < board.boardItem.size(); i++){
            if(CheckingSamePosition (newPosition,board.boardItem.get(i).position)){
                return null;
            }
        }
        return newPosition;
    }

//    public static Vector2 Move(Vector2 vector2, Directions direction) {
//        Vector2 newPosition = null;
//        switch (direction) {
//            case EAST:
//                newPosition = new Vector2(vector2.x + 1, vector2.y);
//            case WEST:
//                newPosition = new Vector2(vector2.x - 1, vector2.y);
//            case SOUTH:
//                newPosition = new Vector2(vector2.x, vector2.y - 1);
//            case NORTH:
//                newPosition = new Vector2(vector2.x, vector2.y + 1);
//        }
//        return newPosition;
//    }


    public static boolean CheckingSamePosition(Vector2 pos1, Vector2 pos2) {
        return (pos1.x == pos2.x && pos1.y == pos2.y);
    }
}
