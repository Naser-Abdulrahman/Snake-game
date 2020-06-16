import java.awt.*;

public class Point {
    private static final int rad = 25;
    Game game;
    int x;
    int y;



    public Point (Game game){
        this.game = game;
        x = (int) (Math.random() * (game.boardY-rad));
        y = (int) (Math.random() * (game.boardX-rad));

    }

    public void paint (Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(x,y,rad,rad);
    }

    public void newSpot () {
        x = (int) (Math.random() * (game.boardX));
        y = (int) (Math.random() * (game.boardY));
        if (x > game.boardX | x < 0 | y > game.boardY | y < 0 ){
            System.out.println("Outta bounds!");
            newSpot();
        }
    }
    public Rectangle getBounds() {return new Rectangle(x,y,rad,rad);}
}
