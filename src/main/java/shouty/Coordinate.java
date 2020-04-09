package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        return (int) Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
    }
}
