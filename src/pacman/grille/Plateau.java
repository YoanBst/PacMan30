package pacman.grille;
import pacman.entities.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;



public class Plateau  extends JPanel{
	int boardRow;
	int boardColumn;
	int caseSize;
	int boardWidth;
	int boardHeight;
	String[] plateauInString = {
		"XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
	};
	

	public Plateau(){
		this.boardRow = 21;
		this.boardColumn = 19;
		this.caseSize = 30;
		this.boardWidth = boardColumn * caseSize;
		this.boardHeight = boardRow * caseSize;
		this.setBackground(Color.BLACK);
		
		
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
                } else if (c == 'P') {
                    Pacman pacman = new Pacman();
                    g.drawImage(pacman.getImage(), x, y, caseSize, caseSize, null);
                } else if (c == ' '){
					Food food = new Food();
					int foodSize = caseSize / 3;
					int offset = (caseSize - foodSize) /2;
					g.drawImage(food.getImage(), x+offset, y+offset, foodSize, foodSize, null);
				}
            }
        }
	}

}
