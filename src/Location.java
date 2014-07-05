public class Location{
    private int x;
    private int y;
    
    public Location(int theX, int theY){
        x = theX;
        y = theY;
        
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void set(int theX, int theY){
        x = theX;
        y = theY;
    }
    public void setX(int theX){
        x = theX;
    }
    
}