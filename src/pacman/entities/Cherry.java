package pacman.entities;
import javax.swing.ImageIcon;
import java.awt.Image;


public class Cherry {
    private ImageIcon cherryImage;

    public Cherry(ImageIcon cherryImage){
        this.cherryImage = cherryImage;
    }

    public Image getImage(){
        return this.cherryImage.getImage();
    }
}
