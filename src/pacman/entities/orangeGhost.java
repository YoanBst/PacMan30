package pacman.entities;
import javax.swing.ImageIcon;
import java.awt.Image;

public class orangeGhost extends Ghost{
    
    public orangeGhost(String color, ImageIcon ghostImage, int ghostX, int ghostY){
        super(color, ghostImage, ghostX, ghostY);
    }
    
    public void setInitialImage(){
        this.ghostImage = new ImageIcon("image/orangeGhost.png");
    }
  
    

}

