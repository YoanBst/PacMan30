package pacman.entities;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public class Wall {
    private ImageIcon wallImage;
    int wallX;
    int wallY;

    public Wall(){
        this.wallImage = new ImageIcon("image/wall.png");
        
    }

    public Image getImage(){
        return this.wallImage.getImage();
    }
    
}
