import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    Node head;
    Node tail;
    private final Game game;
    int xa = 0;
    int ya = 0;


    public Snake (Game game) {
        this.game = game;
        int headx = game.boardX/2;
        int heady = game.boardY/2;
        head = new Node(headx, heady, game);
        head.setHead();
    }

    public void move(){
        head.move(xa, ya);
        if (collision()){
            game.point.newSpot();
            game.updateScore();
            grow();
        }
    }

    public void grow(){
        Node temp;
        if (tail == null) {
            temp = new Node (head.x, head.y, game);
            head.setNext(temp);
        }else {
            temp = new Node (tail.x,tail.y, game);
            tail.setNext(temp);
        }
        tail = temp;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT && this.xa != head.rad){ xa = -head.rad; ya = 0;}
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.xa != -head.rad) {xa = head.rad; ya = 0;}
        else if (e.getKeyCode() == KeyEvent.VK_UP && this.ya != head.rad) {ya = -head.rad; xa = 0;}
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.ya != -head.rad){ ya = head.rad; xa = 0;}
    }
    public void paint (Graphics2D g){
        head.draw(g);
    }

    public boolean collision() {
        return head.getBounds().intersects(game.point.getBounds());
    }
}
