package shouty;

class PersonLocation {
    PersonLocation(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    private String name;
    private int x;
    private int y;

    String getName() {  return name; }
    int getX() {  return x; }
    int getY() {  return y; }
}
