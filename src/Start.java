public class Start{
    private boolean start;
    public Start(){
        start = false;
    }
    public boolean get(){
        return start;
    }
    public void set(boolean b){
        start = b;
    }
    public void flip(){
        start = !start;
    }
}