import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line
{
    // instance variables - replace the example below with your own
    private double[] firstCoordinate;
    private double[] secondCoordinate; 
    private boolean visible;
    private String color;

    /**
     * Constructor for objects of class Line
     */
    public Line()
    {
        firstCoordinate = new double[]{10,10};
        secondCoordinate = new double[]{20,20};
        color = "Orange";
        visible = false;
    }
    /**
     * the mission of this method is to change the position of the location points
     * @param
     *
     */
    public void changePosition(double[] newPos, int selector){
        double[] finalPosx = {newPos[0] + 25, newPos[1] + 25};
        double[] finalPosy = {newPos[0] + 25, newPos[1] + 25};
        if(selector==0){
            firstCoordinate = finalPosx;
        }
        else if(selector == 1){
            secondCoordinate = finalPosy;
        }
    }
    /**
     * This method will make visible using the parameter visible 
     */
    public void makeVisible(){
        visible = true;
        draw();
    }
    public void makeInvisible(){
        erase();
    }
    public void changeColor(String newColor){
        makeInvisible();
        color = newColor;
        makeVisible();
    }
    /**
     * just draw using the canvas with their incorporated graphics
     */
    private void draw(){
        if(visible){
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this,color,new Line2D.Double(firstCoordinate[0],firstCoordinate[1]
                ,secondCoordinate[0],secondCoordinate[1]));
        }
    }
    /**
     * Change the state of the atributte visible and erase the object from canvas
     */
    private void erase(){
        if(visible){
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
        visible = false;
    }
    

}
