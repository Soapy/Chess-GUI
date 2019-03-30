public abstract class Piece implements Movable {
    private String name;
    private Color color;

    public Piece(Color color, String name) {
        setName(name);
        setColor(color);
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

    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(name.charAt(0)));
        sb.append(color.name().charAt(0));
        return sb.toString();
    }
}
