import java.util.ArrayList;
import java.awt.Graphics2D;

/**
 * Write a description of class Unnecesary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Unnecesary extends Sign{

    /**
     * Constructor for objects of class Unnecesary
     */
    public Unnecesary(String speed){
        super(speed);
        drawSign();
    }
    private void drawSign(){
        Circle redPart = new Circle();
        redPart.changeSize(25);
        Circle whitePart = new Circle();
        redPart.changeColor("yellow");
        whitePart.changeColor("white");
        whitePart.changeSize(redPart.getDiameter()-4);
        whitePart.moveHorizontal(2);
        whitePart.moveVertical(2);
        circulos.add(redPart);
        circulos.add(whitePart);
    }
}
