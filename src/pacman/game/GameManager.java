package pacman.game;
import pacman.entities.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class GameManager{
    private Pacman pacman;
    private blueGhost ghostBlue;
    private redGhost ghostRed;
    private orangeGhost ghostOrange;
    private pinkGhost ghostPink;
    int score;
    String[] plateauInString = {    //x :  numero ligne
                                    //y : numero colonne
		    "XXXXXXXXXXXXXXXXXXX",
        "X.c......X........X",
        "X.XX.XXX.X.XXX.XX.X",
        "X.................X",
        "X.XX.X.XXXXX.X.XX.X",
        "X....X.......X....X",
        "XXXX.XXXX.XXXX.XXXX",
        "OOOX.X.......X.XOOO",
        "XXXX.X.XXrXX.X.XXXX",
        "O.......bpo.......O",
        "XXXX.X.XXXXX.X.XXXX",
        "OOOX.X.......X.XOOO",
        "XXXX.X.XXXXX.X.XXXX",
        "X........X........X",
        "X.XX.XXX.X.XXX.XX.X",
        "X..X.....P.....X..X",
        "XX.X.X.XXXXX.X.X.XX",
        "X....X...X...X..c.X",
        "X.XXXXXX.X.XXXXXX.X",
        "X.................X",
        "XXXXXXXXXXXXXXXXXXX" 
	};


    public GameManager(Pacman pacman){
        this.pacman = pacman;
        this.score = 0;
        for (int y = 0; y < plateauInString.length; y++){
          for (int x = 0; x< plateauInString[y].length(); x ++){
            char c = plateauInString[y].charAt(x);
            if (c == 'b'){
              this.ghostBlue = new blueGhost("blue", new ImageIcon("image/blueGhost.png"), x, y);
            } else if (c == 'o'){
              this.ghostOrange = new orangeGhost("orange", new ImageIcon("image/orangeGhost.png"), x, y);
            }else if (c == 'r'){
              this.ghostRed = new redGhost("red", new ImageIcon("image/redGhost.png"), x, y);
            }else if (c == 'p'){
              this.ghostPink = new pinkGhost("pink", new ImageIcon("image/pinkGhost.png"), x, y);
            }
          }
        }
    }

  public void removeBonbon(){
    int x = pacman.getX();
    int y = pacman.getY();
    if (plateauInString[y].charAt(x) == '.'){
      StringBuilder row = new StringBuilder(plateauInString[y]);
      row.setCharAt(x, ' ');
      plateauInString[y] = row.toString();
      this.score +=10;
    }
      
  }

  public void eatCherry(){
    int x = pacman.getX();
    int y = pacman.getY();
    if (plateauInString[y].charAt(x) == 'c'){
      StringBuilder row = new StringBuilder(plateauInString[y]);
      row.setCharAt(x, ' ');
      plateauInString[y] = row.toString();
      this.score +=20;

      Timer timer = new Timer();


      pacman.setInvincibilityTrue();
      this.ghostBlue.setImageInvincible();
      this.ghostOrange.setImageInvincible();
      this.ghostPink.setImageInvincible();
      this.ghostRed.setImageInvincible();
      timer.schedule(new TimerTask() {
      @Override
        public void run() {
            pacman.setInvincibilityFalse();
            ghostBlue.setInitialImage();
            ghostRed.setInitialImage();
            ghostPink.setInitialImage();
            ghostOrange.setInitialImage();
        }
    }, 7500);
    }
  };

  public void eatGhost(){
    int x = pacman.getX();
    int y = pacman.getY();
    List<Ghost> listOfGhost = new ArrayList<>();
      listOfGhost.add(ghostBlue);
      listOfGhost.add(ghostRed);
      listOfGhost.add(ghostPink);
      listOfGhost.add(ghostOrange);
      
    for (Ghost ghost : listOfGhost){

        if( pacman.getInvincibility() && pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY() 
              && !ghost.getIsEaten()){
          StringBuilder row = new StringBuilder(plateauInString[y]);
          row.setCharAt(x, ' ');
          plateauInString[y] = row.toString();
          ghost.setIsEatenTrue();
          score+=20;
        }else if (!pacman.getInvincibility() && pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()
            && !ghost.getIsEaten()){
          System.out.println("Perdu !");
          System.out.println("Score : " + score);
          pacman.setDownHP();
          System.out.println("Vies restantes : " + pacman.getHP());
        };
    }
  }

  public blueGhost getGhostBlue() { return ghostBlue; }
  public redGhost getGhostRed() { return ghostRed; }
  public orangeGhost getGhostOrange() { return ghostOrange; }
  public pinkGhost getGhostPink() { return ghostPink; }

  public String[] getPlateauInString() {
    return plateauInString;
}

  public int getScore(){
    return this.score;
  }
  
    
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    int pacmanX = pacman.getX();
    int pacmanY = pacman.getY();
    if (keyCode == KeyEvent.VK_UP) {
        
      pacman.setImage(new ImageIcon("image/pacmanUp.png"));
      if (pacmanY > 0 && plateauInString[pacmanY -1].charAt(pacmanX) != 'X'){
        
        pacman.setY(pacman.getY() - 1);
        removeBonbon();
        eatCherry();
        eatGhost();
        
      }
    }
    else if (keyCode == KeyEvent.VK_DOWN) {
      
      pacman.setImage(new ImageIcon("image/pacmanDown.png"));
      if (pacmanY > 0 && plateauInString[pacmanY +1].charAt(pacmanX) != 'X'){
        
        pacman.setY(pacman.getY() + 1);
        removeBonbon();
        eatCherry();
        eatGhost();
        
      }
    }
    else if (keyCode == KeyEvent.VK_LEFT) {
      
      pacman.setImage(new ImageIcon("image/pacmanLeft.png"));
      if (pacmanX == 0 && pacmanY == 9) {     //téléportation gauche
        pacman.setX(18);
        pacman.setY(9);
      }else if (pacmanY > 0 && plateauInString[pacmanY].charAt(pacmanX - 1) != 'X'){
        
        pacman.setX(pacman.getX() - 1);
        removeBonbon();
        eatCherry();
        eatGhost();
      }
      
    }

    else if (keyCode == KeyEvent.VK_RIGHT) {
     
      pacman.setImage(new ImageIcon("image/pacmanRight.png"));
      if (pacmanX == 18 && pacmanY == 9) { //téléportation droite
          pacman.setX(0);
          pacman.setY(9);
      }else if (pacmanY > 0 && plateauInString[pacmanY].charAt(pacmanX + 1) != 'X'){
          
          pacman.setX(pacman.getX() + 1);
          removeBonbon();
          eatCherry();
          eatGhost();
        }
   } 
  }





}
