import java.util.*;
import java.io.*;

/**
 * The MazeDriver class works with the Maze class so that users can play a fun maze game with Mario.
 * @author Joon Hyuck Choi
 *
 */
public class MazeDriver {
	
	/**
	 * The scanner that reads input from the keyboard.
	 */
	private static Scanner kb = new Scanner(System.in);

	/**
	 * Constructs a maze that contains the dimensions of a maze structure in a user input file and the rules of the maze game.
	 */
	private static Maze maze;
	
	/**
	 * This is the main method for the Maze game. It gets the filename from the user, prints the menu, gets the choice input from the user, interprets the user's choice, and performs actions on the Maze class, making heavy use of helper methods.
	 * @param args arguments.
	 * @throws IOException if the given file cannot be opened.
	 */
	public static void main(String args[]) throws IOException{
		
		System.out.print("Please input a file name: ");
		String filename = kb.next();
		maze = new Maze(filename);
		
		while (maze.gameWon() == false){
		
			maze.printMaze();
			printMenu();
			String choice = kb.next();
			interpretChoice(choice);	
			System.out.println();

		} //end while
		
		if (maze.gameWon() == true){
			maze.printMaze();
			System.out.println(maze.victoryMessage());
		} //end if
		
		kb.close();
		
	} //end main

	

	/**
	 * Outputs the four different menu options to the screen. 
	 */
	private static void printMenu(){
		
		System.out.println("Enter w to move up");
		System.out.println("Enter a to move left");
		System.out.println("Enter s to move down");
		System.out.println("Enter d to move right");
		System.out.print("Choice --> ");

	} //end printMenu
	
	
	
	/**
	 * Performs the appropriate operation, based on which choice the user input. "w" to move up, "a" to move left, "s" to move down, "d" to move right.
	 * @param choice the choice that the user input.
	 */
	private static void interpretChoice(String choice) {
	
		switch (choice.toLowerCase()) {
		case "w": 
			maze.moveMario(choice);
			break;
			
		case "a": 
			maze.moveMario(choice);
			break;
			
		case "s": 
			maze.moveMario(choice);
			break;
			
		case "d": 
			maze.moveMario(choice);
			break;

		} //end switch
		
	} //end interpretChoice
	
} //end class
