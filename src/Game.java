import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Game extends JPanel{
    public final int boardY = 600;
    public final int boardX = 600;
    private boolean gameOver = false;
    int score = 0;
    Point point = new Point(this);
    Snake snake = new Snake(this);


    public Game() {
        JFrame frame = new JFrame("Snake");
        frame.add(this);
        frame.setSize(boardX+100,boardY+100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {} //pause menu?
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {snake.keyPressed(e);}
        });
        setFocusable(true);
    }



    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        snake.paint(g2d);
        point.paint(g2d);
        g.drawString("Score " + score, 0, 20);
        g.setColor(Color.YELLOW);
        g.drawRect(0,0,boardX,boardY);
        this.setBackground(Color.BLACK);
    }

    public void move() {
        snake.move();
        try {
            Thread.sleep(120);
        } catch (Exception e){}
    }

    public void updateScore() {
        score++;
    }

    public void gameOver( Graphics g) {
        g.setColor(Color.RED);
        g.drawString("You Died", 200,200);
        gameOver = true;
    }

    public static void main(String[] args){
        Game game = new Game();
        while (!game.gameOver){
            game.repaint();
            game.move();
        }
    }
}
