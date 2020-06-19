import java.awt.*;

public class Point {
    private static final int rad = 25;
    Game game;
    int x;
    int y;



    public Point (Game game){
        this.game = game;
        x = (int) (Math.random() * (game.boardY-rad*2));
        y = (int) (Math.random() * (game.boardX-rad*2));
    }

    public void paint (Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(x,y,rad,rad);
    }

    public void newSpot () {
        x = (int) (Math.random() * (game.boardX-(rad*2)));
        y = (int) (Math.random() * (game.boardY-(rad*2)));

        if (x+rad > game.boardX | x < 0 | y+rad> game.boardY | y < 0 ){
            System.out.println("Outta bounds!");
            newSpot();
        }
    }
    public Rectangle getBounds() {return new Rectangle(x,y,rad,rad);}
}
