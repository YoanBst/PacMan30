package pacman.entities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class blueGhost extends Ghost{
    

    public blueGhost(String color, ImageIcon ghostImage, int ghostX, int ghostY){
        super(color, ghostImage, ghostX, ghostY);
    }
    
    @Override
    public void setInitialImage(){
        this.ghostImage = new ImageIcon("image/blueGhost.png");
    }

}
