package pacman.game;
import pacman.entities.*;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pacman.grille.Plateau;
public class Game {
    public static void main(String args[]){
        Pacman pacman = new Pacman();
        Plateau plateau = new Plateau(pacman);
        GameManager gameManager = new GameManager(pacman);

        plateau.addKeyListener(new KeyAdapter(){
             @Override
            public void keyPressed(KeyEvent e) {
                gameManager.keyPressed(e);
                plateau.repaint();
            }
            
        });


        plateau.setFocusable(true); //ecoute les touches clavier
        plateau.requestFocusInWindow();
        plateau.showGrid();


        
        
    }
}
