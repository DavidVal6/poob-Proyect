
/**
 * Write a description of class wrong here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class wrong extends Sign{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class wrong
     */
    public wrong(String speed){
        super(speed);
        drawSign();
        this.move(100,100);
    }
    private void drawSign(){
        Circle redPart = new Circle();
        redPart.changeSize(25);
        Circle whitePart = new Circle();
        redPart.changeColor("black");
        whitePart.changeColor("white");
        whitePart.changeSize(redPart.getDiameter()-4);
        whitePart.moveHorizontal(2);
        whitePart.moveVertical(2);
        circulos.add(redPart);
        circulos.add(whitePart);
    }
}
