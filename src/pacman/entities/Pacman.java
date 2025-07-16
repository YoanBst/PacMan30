package pacman.entities;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public class Pacman {
    private int hp;
    private int x;
    private int y;
    private ImageIcon pacmanImage;
    private boolean isInvincible;
    

    public Pacman(){
        this.hp = 3;
        this.pacmanImage = new ImageIcon("image/pacmanRight.png");
        this.isInvincible = false;
        this.x = 9;
        this.y = 15;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setImage(ImageIcon newPacmanImage){
        this.pacmanImage = newPacmanImage;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Image getImage(){
        return this.pacmanImage.getImage();
    }
}
