import java.io.*;
import java.util.Scanner;

/**
 * The Maze class constructs a maze from a user input file. It then sets the rules for the maze game, checks if the user's move is valid, and ultimately checks if the user won the game.
 * @author Joon Hyuck Choi
 *
 */
public class Maze {
	
	/**
	 * The array that contains the structure of the maze.
	 */
	private char[][] mazeStructure;
	
	/**
	 * The number of rows in the maze.
	 */
	private int row;
	
	/**
	 * The number of columns in the maze.
	 */
	private int col;
	
	/**
	 * The x position of Mario.
	 */
	private int marioX;
	
	/**
	 * The y position of Mario.
	 */
	private int marioY;
	
	/**
	 * The x position of the goal X.
	 */
	private int xPositionX;
	
	/**
	 * The y position of the goal X.
	 */
	private int yPositionX;
	
	/**
	 * The number of valid moves.
	 */
	private int count;
	
	/**
	 * Constructs a maze given the name of text file containing the number of rows and columns of a maze, a Mario, and a goal X. The constructor scans the input file and creates a maze using an array and also scans the the (x,y) positions of Mario and the goal.
	 * @param filename the name of the file that contains the number of rows and columns of a maze and its structure.
	 * @throws IOException if the given file cannot be opened.
	 */
	public Maze(String filename) throws IOException {

	    Scanner inputFile = new Scanner(new FileReader(filename));
	    this.row = 0;
	    this.col = 0;
	    this.marioX = 0;
	    this.marioY = 0;
	    this.xPositionX = 0;
	    this.yPositionX = 0;
	    
	    row = inputFile.nextInt();        
	    col = inputFile.nextInt();  
	    mazeStructure = new char[row][col];
	    
		inputFile.nextLine();
		for (int r = 0; r < row; r++){
			String oneLine = inputFile.nextLine();
				for (int i = 0; i < oneLine.length(); i++){
					mazeStructure[r][i] = oneLine.charAt(i);
					if(mazeStructure[r][i] == 'M'){
						marioX = i;
						marioY = r;
					} else if(mazeStructure[r][i] == 'X'){
						xPositionX = i;
						yPositionX = r;
					}
				}
		} //end for

		inputFile.close();
		
	} //end constructor Maze();
	


	/**
	 * Prints the most updated version of the maze.
	 */
	public void printMaze(){

		for (int r = 0; r < row; r++){
			for (int c = 0; c < col; c++){
				System.out.print(mazeStructure[r][c]);
			}
			System.out.println();
		} //end for
		System.out.println();
		
	} //end printMaze();
	

	
	/**
	 * Moves Mario up by one step.
	 */
	private void moveUp(){
		
		if(marioY == 0){
			System.out.println("This is an invalid move!");			
		} else if(mazeStructure[marioY - 1][marioX] == '+'){
			System.out.println("This is an invalid move!");
		} else{
			mazeStructure[marioY][marioX] = '.';
			mazeStructure[marioY - 1][marioX] = 'M';
			marioY = marioY - 1;
			count++;
		} //end if
		
	} //end moveUp();
	
	
	
	/**
	 * Moves Mario left by one step.
	 */
	private void moveLeft(){
		
		if(marioX == 0){
			System.out.println("This is an invalid move!");			
		} else if(mazeStructure[marioY][marioX - 1] == '+'){
			System.out.println("This is an invalid move!");
		} else{
			mazeStructure[marioY][marioX] = '.';
			mazeStructure[marioY][marioX - 1] = 'M';
			marioX = marioX - 1;
			count++;
		} //end if
		
	} //end moveLeft();

	
	
	/**
	 * Moves Mario down by one step.
	 */
	private void moveDown(){
		
		if(marioY == (row - 1)){
			System.out.println("This is an invalid move!");
		} else if(mazeStructure[marioY + 1][marioX] == '+'){
			System.out.println("This is an invalid move!");
		} else{
			mazeStructure[marioY][marioX] = '.';
			mazeStructure[marioY + 1][marioX] = 'M';
			marioY = marioY + 1;
			count++;
		} //end if
		
	} //end moveDown();
	
	
	
	/**
	 * Moves Mario right by one step.
	 */
	private void moveRight(){
		
		if(marioX == (col - 1)){
			System.out.println("This is an invalid move!");			
		} else if(mazeStructure[marioY][marioX + 1] == '+'){
			System.out.println("This is an invalid move!");
		} else{
			mazeStructure[marioY][marioX] = '.';
			mazeStructure[marioY][marioX + 1] = 'M';
			marioX = marioX + 1;
			count++;
		} //end if
		
	} //end moveRight();
	
	
	
	/**
	 * Takes the user input of a move and performs the move. This method gets called in the main method in the MazeDriver class. When "w" is called, it moves calls the moveUp method. When "a" is called, it moves calls the moveLeft method. When "s" is called, it moves calls the moveDown method. When "d" is called, it moves calls the moveRight method.
	 * @param s the user input of a move.
	 */
	public void moveMario(String s){
		
		switch (s.toLowerCase()) {
		case "w": 
			moveUp();
			break;
			
		case "a": 
			moveLeft();
			break;
			
		case "s": 
			moveDown();
			break;
			
		case "d": 
			moveRight();
			break;

		} //end switch
		
	} //end moveMario();
	
	
	
	/**
	 * Checks if the user reached the goal. When the (x, y) position of Mario matches that of the goal X, the method returns true.
	 * @return returns whether or not the user has won the game.
	 */
	public boolean gameWon(){
		
		if(marioX == xPositionX && marioY == yPositionX){
			return true;
		} else {
			return false;
		}
		
	} //end gameWon();
	
	
	
	/**
	 * Prints a message that shows how many valid moves it took for the user to win the game. The method calls the updated count variable and prints it.
	 * @return returns a string that shows how many valid moves it took for the user to win the game.
	 */
	public String victoryMessage(){
		
		return "You won in " + count + " moves!";
		
	} //end victoryMessage();
	
} //end Maze Class
