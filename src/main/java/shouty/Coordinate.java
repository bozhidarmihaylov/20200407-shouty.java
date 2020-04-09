package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        // TODO: actually calculate distance between the coordinates.
        //       e.g. return Math.abs(x - other.x);

        Coordinate v = new Coordinate(x - other.x, y - other.y);
        return (int)Math.round(Math.sqrt(v.x * v.x + v.y * v.y));
    }
}
