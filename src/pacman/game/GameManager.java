package pacman.game;
import pacman.entities.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameManager {
    private Pacman pacman;
    public GameManager(Pacman pacman){
        this.pacman = pacman;
    }
    
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      pacman.setImage(new ImageIcon("image/pacmanUp.png"));
      pacman.setY(pacman.getY() - 1);
    }
    else if (keyCode == KeyEvent.VK_DOWN) {
      pacman.setY(pacman.getY() + 1);
      pacman.setImage(new ImageIcon("image/pacmanDown.png"));
    }
    else if (keyCode == KeyEvent.VK_LEFT) {
      pacman.setX(pacman.getX() - 1);
      pacman.setImage(new ImageIcon("image/pacmanLeft.png"));
    }
    else if (keyCode == KeyEvent.VK_RIGHT) {
     pacman.setX(pacman.getX() + 1);
     pacman.setImage(new ImageIcon("image/pacmanRight.png"));
    }

  }


}
