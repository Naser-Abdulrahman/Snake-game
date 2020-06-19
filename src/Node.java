import java.awt.*;

public class Node {
    public int x;
    public int y;
    public final int rad = 25;
    private Node next = null;
    private boolean head = false;
    int xa;
    int ya;
    Game game;

    public Node (int x, int y, Game game){
        this.x = x;
        this.y = y;
        this.game = game;
    }

    public void setNext(Node next) {
        this.next = next;
        if ( xa < 0) next.x += rad;
        else if ( xa > 0) next.x -= rad;
        else if ( ya < 0 ) next.y += rad;
        else if ( ya > 0 ) next.y -= rad;
    }

    public void move(int xa, int ya){
        if (next != null) next.move(this.xa, this.ya);
      //  if (this.head) System.out.println(x + "          " + y);
        this.x += xa;
        this.y += ya;
        this.xa = xa;
        this.ya = ya;
    }

    public void draw (Graphics2D g){
        if (head) g.setColor(Color.MAGENTA);
        else g.setColor(Color.YELLOW);
        g.fillOval(x,y,rad,rad);
        if (touchesHead() | outOfBounds()) game.gameOver(g);
        if (next !=null) next.draw(g);
    }

    public void setHead(){
        this.head = true;
    }

    public boolean touchesHead(){
        if (this.head) return false;
        else return this.getBounds().intersects(game.snake.head.getBounds());
    }

    public boolean outOfBounds(){
        return x < 0 | x + rad > game.boardX | y < 0 | y + rad > game.boardY;
    }

    public Rectangle getBounds() { return new Rectangle(x,y,rad,rad);}
}
