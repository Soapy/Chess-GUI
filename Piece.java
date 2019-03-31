public abstract class Piece implements Movable{
    private String name;
    private Color color;
    private Location location;

    public Piece(Color color, String name, int row, int column) {
        setName(name);
        setColor(color);
        setLocation(row, column);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(int row, int column) {
        location = new Location(row, column);
    }

    public String toString() {
        String str = this.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(str.substring(0, 2));
        sb.append(color.name().charAt(0));
        return sb.toString();
    }
}
