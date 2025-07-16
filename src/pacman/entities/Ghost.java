package pacman.entities;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public  class Ghost {
    private String color;
    private ImageIcon ghostImage;

    public Ghost(String color, ImageIcon ghostImage){
        this.color = color;
        this.ghostImage = ghostImage;
        
    }


    public Image getImage(){
        return this.ghostImage.getImage();
    }
}
