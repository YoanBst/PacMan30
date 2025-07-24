package pacman.game;
import pacman.entities.*;

import javax.sound.sampled.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.*;
import javax.swing.JFrame;

import pacman.grille.Plateau;
public class Game {
    private static java.util.Timer ghostTimer;
    private static JFrame frame;
    private static Plateau plateau;
    private static GameManager gameManager;

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
        EnumDirection enumDirection = new EnumDirection();
        gameManager = new GameManager(pacman, enumDirection);
        plateau = new Plateau(pacman, gameManager.getGhostBlue(), gameManager.getGhostRed(),
            gameManager.getGhostOrange(), gameManager.getGhostPink(), gameManager.getPlateauInString(), gameManager);

        plateau.addKeyListener(new KeyAdapter(){
             @Override
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_Q){
                    javax.swing.SwingUtilities.getWindowAncestor(plateau).dispose();
                }else if (e.getKeyCode() == KeyEvent.VK_R){
                    reloadGame();
                }
                
                else if (gameManager.getPacman().getHP() > 0){
                    gameManager.keyPressed(e);
                    plateau.repaint();
                }
            }
            
        });


        playMusic("sound/pacmanSound.wav");
        

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

        if (ghostTimer != null) ghostTimer.cancel();
            ghostTimer = new java.util.Timer();
            ghostTimer.scheduleAtFixedRate(new java.util.TimerTask() {
                @Override
                public void run() {
                    gameManager.moveGhost();
                    gameManager.eatGhost();
                    gameManager.updateInvincibility();
                    plateau.repaint();
                }
            }, 0, 300);


        
        
    }

    public static void reloadGame(){
        startGame();
    }

    
}
