package pacman.game;
import pacman.entities.*;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import pacman.grille.Plateau;
public class Game {
    public static void main(String args[]){
        
        Pacman pacman = new Pacman();
        GameManager gameManager = new GameManager(pacman);
        Plateau plateau = new Plateau(pacman, gameManager.getGhostBlue(), gameManager.getGhostRed(),
                gameManager.getGhostOrange(),  gameManager.getGhostPink(),gameManager.getPlateauInString(), gameManager);
        

        plateau.addKeyListener(new KeyAdapter(){
             @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_Q){
                    javax.swing.SwingUtilities.getWindowAncestor(plateau).dispose();
                }else if (e.getKeyCode() == KeyEvent.VK_R){
                   
                }
                
                else if (pacman.getHP() >0){
                    gameManager.keyPressed(e);
                    plateau.repaint();
                }
            }
            
        });


        plateau.setFocusable(true); //ecoute les touches clavier
        plateau.requestFocusInWindow();
        plateau.showGrid();


        
        
    }
}
