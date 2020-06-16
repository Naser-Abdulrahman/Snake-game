import java.awt.*;

public class Node {
    public int x;
    public int y;
    public final int rad = 25;
    private Node next = null;
    private boolean head = false;
    int xa;
    int ya;

    public Node (int x, int y){
        this.x = x;
        this.y = y;
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
        this.x += xa;
        this.y += ya;
        this.xa = xa;
        this.ya = ya;
    }

    public void draw (Graphics2D g){
        if (head) g.setColor(Color.MAGENTA);
        else g.setColor(Color.YELLOW);
        g.fillOval(x,y,rad,rad);
        if (next !=null) next.draw(g);
    }

    public void setHead(){
        this.head = true;
    }
    public Rectangle getBounds() { return new Rectangle(x,y,rad,rad);}

}
