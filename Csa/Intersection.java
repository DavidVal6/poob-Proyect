
/**
 * Write a description of class Intersections here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intersection
{
    // instance variables - replace the example below with your own
    private String color;
    private int xPosition;
    private int yPosition;
    private int size;
    private boolean visible = false;
    private Circle graphicForm = new Circle();

    /**
     * Constructor for objects of class Intersections
     */
    public Intersection(String color, int x, int y)
    {
       this.color = color;
       xPosition = x;
       yPosition = y;
    }
    public void makeVisible(){
        if(!visible){
            draw();
        }
    }
    public void makeInvisible(){
        if(visible){
            erase();
        }
    }

    private void draw(){
        graphicForm.changeColor(color);
        graphicForm.moveHorizontal(xPosition);
        graphicForm.moveVertical(yPosition);
        graphicForm.makeVisible();
        visible = true;
    }
    private void erase(){
        graphicForm.makeInvisible();
        visible = false;
    }
    
    @Override
    public boolean equals(Object obj) {
        return equals((Intersection)obj);
    }
    public boolean equals(Intersection other){
        if(this.getColor().equals(other.getColor())){
            return true;
        }else{
            return false;
        }
    
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getX()
    {
        return xPosition;
    }
    public boolean isVisible(){
        return visible;
    }
    public int getY()
    {
        return yPosition;
    }
    public String getColor()
    {
        return color;
    }
    @Override
    public String toString() {
        return "Intersection [color=" + color + ", size=" + size + ", visible=" + visible + ", xPosition=" + xPosition
                + ", yPosition=" + yPosition + "]";
    }
    
}
