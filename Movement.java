public class Movement {
    private int oldX;
    private int newX;
    private int oldY;
    private int newY;

    public Movement()
    {
        oldX = 0;
        oldY = 0;
        newX = 1;
        newY = 1;
    }

    public Movement(int oldX, int oldY, int newX, int newY)
    {
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

    public void setOldX(int oldX){
        this.oldX = oldX;
    }
    public void setOldY(int oldY){
        this.oldY = oldY;
    }
    public void setNewX(int newX){
        this.newX = newX;
    }
    public void setNewY(int newX){
        this.newY = newX;
    }

    public int getGapX(){
        return this.newX - this.oldX;
    }
    public int getGapY(){
        return this.newY - this.oldY;
    }

}