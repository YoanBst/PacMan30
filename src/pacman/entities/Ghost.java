package pacman.entities;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public  abstract class Ghost {
    private int ghostX;
    private int ghostY;
    private String color;
    boolean isEaten;
    ImageIcon ghostImage;

    public Ghost(String color, ImageIcon ghostImage, int ghostX, int ghostY){
        this.ghostX = ghostX;
        this.ghostY = ghostY;
        this.color = color;
        this.ghostImage = ghostImage;
        this.isEaten = false;
    }
    public void setX(int ghostX){
        this.ghostX = ghostX;
    }

    public void setY(int ghostY){
        this.ghostY = ghostY;
    }

    public int getX(){
        return this.ghostX;
    }

    public int getY(){
        return this.ghostY;
    }

    
    public Image getImage(){
        return this.ghostImage.getImage();
    }

    public void setImageInvincible(){
        this.ghostImage = new ImageIcon("image/scaredGhost.png");
    }

    public void setInitialImage(){
        this.ghostImage = new ImageIcon("image/blueGhost.png");
    }

    public void setIsEatenTrue(){
        this.isEaten = true;
    }

    public boolean getIsEaten(){
        return this.isEaten;
    }



    
}
