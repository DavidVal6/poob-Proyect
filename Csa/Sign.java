import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
/**
 * Write a description of class sing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sign
{
    // instance variables - replace the example below with your own
    protected ArrayList<Circle> circulos = new ArrayList();
    protected String speed;
    protected boolean visible = false;
    /**
     * This is the constructor for the class sign where i only need the graphics with the speed
     */
    public Sign(String speed){
        this.speed = speed;
        drawSign();
    }
    /**
     * This method initialize the circles that make the sign but no draw 
     */
    private void drawSign(){
        Circle redPart = new Circle();
        redPart.changeSize(25);
        Circle whitePart = new Circle();
        redPart.changeColor("red");
        whitePart.changeColor("white");
        whitePart.changeSize(redPart.getDiameter()-4);
        whitePart.moveHorizontal(2);
        whitePart.moveVertical(2);
        circulos.add(redPart);
        circulos.add(whitePart);
    }
    /**
     * This method moves the entire sign into a new x and y coordenade 
     */
    public void move(int x , int y){
        erase();
        for(int i = 0 ; i < circulos.size();i++){
            circulos.get(i).moveHorizontal(x);
            circulos.get(i).moveVertical(y);
            circulos.get(i).makeVisible();
        }
        Canvas canvas =  Canvas.getCanvas();
        canvas.drwString(speed,circulos.get(1).getX()+6,circulos.get(1).getY()+15);
    }
    public void makeInvisible(){
        for(int i = 0; i < circulos.size();i++){
            circulos.get(i).makeInvisible();
        }
        erase();
    }
    /**
     * To delete de canvas
     */
    protected void erase(){
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }
    protected int speedLimit(){
        return Integer.parseInt(speed);
    }
}
