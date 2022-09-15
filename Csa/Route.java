
/**
 * Write a description of class Routes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    private Rectangle road = new Rectangle();
    private String[] parts = new String[2];
    private int xPosition;
    private int yPosition;
    private boolean visible = false;
    
    public Route(String a, String b){
        this.parts[0] = a;
        this.parts[1] = b;
    }
    public void draw(){
        
    }
    public String[] getParts(){
        return parts;
    }
    @Override
    public boolean equals(Object obj) {
        return equals((Route)obj);
    }
    public boolean equals(Route other){
        if((this.getParts()[0] == other.getParts()[0])&&(this.getParts()[1] == other.getParts()[1])){
            return true;
        }else if((this.getParts()[0] == other.getParts()[1])&&(this.getParts()[1] == other.getParts()[0])){
            return true;
        }else{
            return false;
        }
    }
}
