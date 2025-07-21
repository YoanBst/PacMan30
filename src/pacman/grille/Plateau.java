package pacman.grille;
import pacman.entities.*;
import pacman.game.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;



public class Plateau  extends JPanel{
    private Pacman pacman;
    private blueGhost ghostBlue;
    private redGhost ghostRed;
    private orangeGhost ghostOrange;
    private pinkGhost ghostPink;
    private GameManager gameManager;
	int boardRow;
	int boardColumn;
	int caseSize;
	int boardWidth;
	int boardHeight;
	String[] plateauInString = {
	};
	

	public Plateau(Pacman pacman, blueGhost ghostBlue, redGhost ghostRed, orangeGhost ghostOrange, 
            pinkGhost ghostPink, String[] plateauInString, GameManager gameManager){

        this.plateauInString = plateauInString;
        this.pacman = pacman;
        this.ghostBlue = ghostBlue;
        this.ghostOrange = ghostOrange;
        this.ghostPink = ghostPink;
        this.ghostRed = ghostRed;
        this.gameManager = gameManager;

		this.boardRow = 21;
		this.boardColumn = 19;
		this.caseSize = 30;
		this.boardWidth = boardColumn * caseSize;
		this.boardHeight = boardRow * caseSize;
		this.setBackground(Color.BLACK);
		
		
	}

    public Pacman getPacman(){
        return this.pacman;
    }

    public int getBoardWidth(){
        return this.boardWidth;
    }

    public int getBoardHeight(){
        return this.boardHeight;
    }


    
    public void showGrid() {	
		JFrame frame = new JFrame("Pacman");

		frame.setSize(boardWidth, boardHeight);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(this);
		
		frame.setVisible(true);

    }

    

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		for (int row = 0; row < plateauInString.length; row++) {
            for (int col = 0; col < plateauInString[row].length(); col++) {
                char c = plateauInString[row].charAt(col);
                int x = col * caseSize;
                int y = row * caseSize;
                if (c == 'X') {
                    Wall wall = new Wall();
                    g.drawImage(wall.getImage(), x, y, caseSize, caseSize, null);
                    
                } else if (c == 'b'){
                    try{
                    
                        
                        g.drawImage(ghostBlue.getImage(), x, y, caseSize, caseSize, null);
                    }catch(Exception e){
                        System.out.println("Erreur : image introuvable");
                    }
                }else if (c == 'p'){
                    try{
                        
                        g.drawImage(ghostPink.getImage(), x, y, caseSize, caseSize, null);
                    }catch(Exception e){
                        System.out.println("Erreur : image introuvable");
                    }
                }else if (c == 'o'){
                    try{
                        
                        g.drawImage(ghostOrange.getImage(), x, y, caseSize, caseSize, null);
                    }catch(Exception e){
                        System.out.println("Erreur : image introuvable");
                    }
                }else if (c == 'r'){
                    try{
                        
                        g.drawImage(ghostRed.getImage(), x, y, caseSize, caseSize, null);
                    }catch(Exception e){
                        System.out.println("Erreur : image introuvable");
                    }

                }else if (c == 'c'){
                    try{
                        Cherry cherry = new Cherry(new ImageIcon("image/cherry.png"));
                        g.drawImage(cherry.getImage(), x, y, caseSize, caseSize, null);
                    }catch(Exception e){
                        System.out.println("Erreur : image introuvable");
                    }
                } else if (c == '.'){
					Food food = new Food();
					int foodSize = caseSize / 3;
					int offset = (caseSize - foodSize) /2;
					g.drawImage(food.getImage(), x+offset, y+offset, foodSize, foodSize, null);
				}
                int pacX = pacman.getX() * caseSize;
                int pacY = pacman.getY() * caseSize;
                g.drawImage(pacman.getImage(), pacX, pacY, caseSize, caseSize, null);
                
            }
        }
        
    g.setColor(Color.YELLOW);
    g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
    g.drawString("Score : " + gameManager.getScore(), 10, 25);

    g.setColor(Color.YELLOW);
    g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
    g.drawString("Vies : " + pacman.getHP(), 470, 25);

   

    if (pacman.getHP() <= 0){
        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
        g.drawString("Game Over", 145, 300);

        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        g.drawString("press q to quit" , 190, 380);

        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        g.drawString("press r to play " , 190, 460);
    }else if (pacman.getHP()>0 && pacman.getGhostEaten() == 4){
        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
        g.drawString("You win", 200, 300);

        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        g.drawString("press q to quit" , 190, 380);

        g.setColor(Color.RED);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        g.drawString("press r to play " , 190, 460);
    }
    

	}


}
