package pacman.entities;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public class Pacman {
    private int hp;
    private ImageIcon pacmanImage;
    
    private boolean isInvincible;
    

    public Pacman(){
        this.hp = 3;
        this.pacmanImage = new ImageIcon("image/pacmanRight.png");
        this.isInvincible = false;
        
    }

    public Image getImage(){
        return this.pacmanImage.getImage();
    }
}
