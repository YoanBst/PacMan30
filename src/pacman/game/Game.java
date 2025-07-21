package pacman.game;
import pacman.entities.*;

import javax.sound.sampled.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import pacman.grille.Plateau;
public class Game {
     private static JFrame frame;
    private static Plateau plateau;
    private static Clip clip;
    public static void playMusic(String filename) {
        try {
            if (clip != null && clip.isRunning()){
                clip.stop();
                clip.close();
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new java.io.File(filename));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startGame(){
        
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
                    reloadGame();
                }
                
                else if (pacman.getHP() >0){
                    gameManager.keyPressed(e);
                    plateau.repaint();
                }
            }
            
        });


        playMusic("sound/Mood.wav");
        

        if (frame == null) {
            frame = new JFrame("Pacman");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(plateau.getBoardWidth(), plateau.getBoardHeight());
            frame.add(plateau);
            frame.setVisible(true);
        } else {
            frame.getContentPane().removeAll();
            frame.add(plateau);
            frame.revalidate();
            frame.repaint();
        }

        plateau.setFocusable(true); //ecoute les touches clavier
        plateau.requestFocusInWindow();


        
        
    }

    public static void reloadGame(){
        startGame();
    }

    public static void main(String args[]){
            startGame();
            
        }
}
