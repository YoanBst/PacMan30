package pacman.entities;
import javax.swing.ImageIcon;
import java.awt.Image;
public class Food {
    private ImageIcon foodImage;
    public Food(){
        this.foodImage = new ImageIcon("image/food.png");
    }

    public Image getImage(){
        return this.foodImage.getImage();
    }
}
