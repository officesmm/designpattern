package randomIdea.sidemover.coordinate;

public class Vector2 {
    public int x;
    public int y;

    public static enum Directions {
        EAST,
        WEST,
        SOUTH,
        NORTH
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 Move(Vector2 vector2, Directions direction) {
        switch (direction) {
            case EAST:
                return new Vector2(vector2.x + 1, vector2.y);
            case WEST:
                return new Vector2(vector2.x - 1, vector2.y);
            case SOUTH:
                return new Vector2(vector2.x, vector2.y - 1);
            case NORTH:
                return new Vector2(vector2.x, vector2.y + 1);
        }
        return null;
    }

    public String display() {
        return "(" + x + ", " + y + ")";
    }
}
