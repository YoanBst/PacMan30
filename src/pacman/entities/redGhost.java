package pacman.entities;
import javax.swing.ImageIcon;
import java.awt.Image;

public class redGhost extends Ghost{
    
    public redGhost(String color, ImageIcon ghostImage, int ghostX, int ghostY){
        super(color, ghostImage, ghostX, ghostY);
    }
    
    @Override
    public void setInitialImage(){
        this.ghostImage = new ImageIcon("image/redGhost.png");
    }
    
}