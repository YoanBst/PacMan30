package pacman.game;
import java.util.Random;


public class EnumDirection {
    private Direction direction;

    public EnumDirection(){
        this.direction = Direction.HAUT;
    }


    public Direction randomDirection(){
        Random random = new Random();
        int direction = random.nextInt(4);
        switch (direction){
            case 0:
                return Direction.HAUT;
            case 1:
                return Direction.BAS;
            case 2:
                return Direction.GAUCHE;
            case 3:
                return Direction.DROITE;
            default:
                return Direction.HAUT;
        }
    }


}
