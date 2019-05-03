/**
 * Moves a piece to a new tile.
 * author: Stefan Heng
 */
public class Movement {
    private int oldX, oldY, newX, newY;

    public Movement(int oldX, int oldY, int newX, int newY) {
        this.oldX = oldX;
        this.oldY = oldY;
        this.newX = newX;
        this.newY = newY;
    }

    public int getOldX(){
        return this.oldX;
    }
    public int getOldY(){
        return this.oldY;
    }
    public int getNewX(){
        return this.newX;
    }
    public int getNewY(){
        return this.newY;
    }

    public int getDiffX(){
        return this.newX - this.oldX;
    }
    public int getDiffY(){
        return this.newY - this.oldY;
    }

}