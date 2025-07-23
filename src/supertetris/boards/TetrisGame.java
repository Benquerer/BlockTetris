package supertetris.boards;

import java.util.TimerTask;
import java.util.Timer;
import supertetris.blocks.Empty;
//

/**
 * this class represents the actual playable game of tetris, with a timer to make the current piece (inherited from the Board class) to move down automatically with a timed delay.
 * @author Andre Benquerer - n° 24633
 */
public class TetrisGame extends Board {

    /**
     * listener for the game
     */
    GameListener listener;
    /**
     * Timer that will determine the speed at which the piece will move down 
     */
    Timer timer;
    /**
     * Attribute to represent the score of the player
     */
    int score;
    /**
     * Attribute to set a multiplier for the score, since the game starts by default at level 1, the multiplier starts at 1.0
     */
    double multiplier = 1.0;

    /**
     * setter of the listener determined by the UI to call methods when specific situations occur on the game.
     * @param listener 
     */
    public void setListener(GameListener listener) {
        this.listener = listener;
    }   

    /**
     * Default constructor for the game, it uses de default constructor of the Board class to make an empty board, 
     * sets the score to 0 and starts the timer at the level 1 speed, also defining the multiplier for that level
     */
    public TetrisGame() {
        super();
        score = 0;
        timer = new Timer();
        startGame(1000);
        multiplier = 1.0;
    }  
    
    /**
     * Starts the timer with a specified delay that will determine the speed at which the pieces move down.
     * @param delay time in milliseconds at which the timer will perform its task
     */
    public void startGame(int delay) {
        // cancels any existing timer
        timer.cancel();
        // creates a new timer for the game
        timer = new Timer();
        //starts the game with the new specified delay (task, idle before starting, delay)
        timer.schedule(new MoveGame(), 0, delay);
    }
    
    /**
     * Stops the time, which will make the pieces stop falling.
     */
    public void stopGame() {
        //stops the timer
        timer.cancel();
    }
        
    /**
     * gets the position of the piece in the board and if it can no longer move down, that will represent that the game is over
     * @return false if the piece can still move down when spawned. 
     */
    public boolean isGameOver() {
        // returns if whether the condition has been met or not
        return current.getPositionY() == 0 && !canMovePiece(1, 0);
    }
    
    /**
     * Class that defines a task that represents the automatic movement of a piece in the tetris system.
     */
    private class MoveGame extends TimerTask {
        
        //Defines what the abstract method run() of the TimerTask class will do
        @Override
        public void run() {
            requestFocus();
            //checks the state of the game
            if (isGameOver()) { 
                // if the game is over, calls the stopGame() method that will stop the piece from falling
                stopGame();
                //Triggers the onGameOver() method to represent that the game is over
                listener.onGameOver();
            } else if (canMovePiece(1, 0)) {
                //if the game is not over, and the piece can still move, moves it down.
                moveDown();
            } else {
                //if the game is not over, but the piece cannot move down, freezes the piece and generates a new one.
                freezePiece();
                generateRandomPiece();   
            }
            requestFocus();
        }

    }
    
    /**
     * Check if a line is full of non empty blocks
     * @param line line to be checked
     * @return whether the line is full or not
     */
    public boolean isLineFull(int line) {
        //runs through every block in the parameter defined line
        for (int x = 0; x < matrix[line].length; x++) {
            //checks if the block is a empty block
            if (matrix[line][x] instanceof Empty) {
                //return false if any block is empty
                return false;
            }
        }
        // if all the block in the line are diffrent than empty, than the line is full.
        return true;
    }
    
    /**
     * deletes a line in the tetris system.
     * @param line 
     */
    public void deleteLine(int line) {
        //check if there is a listener
        if (listener != null) {
            //triggers what should happen when a line is deleted in the UI.
            listener.onDeleteLine(score);
        }
        //makes all the lines above the deleted line fall one row
        for (int y = line; y > 0; y--) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        //creates a new empty line on the top of the board
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty();
        }
    }
    
    /**
     * allows the deletion of multiple lines at once
     */
    public void deleteFullLines() {
        //runs through every line in the board
        for (int y = matrix.length - 1; y > 0; y--) {
            
            while (isLineFull(y)) { 
                //if any line is still full deletes the line and updates de score
                score += (int) 100*multiplier;
                deleteLine(y);
            }
        }
    }
    
    /**
     * Recreates the game with the specified lines, columns and level desired by the user
     * @param lines lines for the new board
     * @param cols columns for the new board
     * @param level level for the new game
     */
    public void reStartGame(int lines, int cols, int level){
        //calls tha parent class constructor to make a blank board
        super.reCreate(lines, cols);
        /*Checks what level was chosen by the user, starting the game 
        with the speed and multiplier for the level*/ 
        if (level==1) {
            startGame(1000);
            multiplier = 1.0;
        }else if(level==2){
            startGame(750);
            multiplier = 1.2;
        }else if(level==3){
            startGame(500);
            multiplier = 1.4;
        }else if(level==4){
            startGame(350);
            multiplier = 1.8;
        }else if(level==5){
            startGame(200);
            multiplier = 2.0;
        }else if(level==6){
            startGame(100);
            multiplier = 2.5;
        }else if(level==7){
            startGame(50);
            multiplier = 3.0;
        }else if(level==8){
            startGame(25);
            multiplier = 5.0;
        }else if(level==9){
            startGame(1);
            multiplier = 100.0;
        }else{ //if the level is 0
            startGame(2000);
            multiplier = 0.8;
        }
    }
    /**
     * Overrides the freezePiece() method from the parent class Board. adding to it 
     * the event for the listener and the deletion of lines
     */
    @Override
    public void freezePiece() {
        //calls the Board class freezePiece() method
        super.freezePiece();   
        //Triggers the piecePlaced event 
        listener.piecePlaced();
        //deletes all the deletable lines, if there are any
        deleteFullLines();
    }
    
    /**
     * Overrides the fallDown() method from the class Board, 
     * adding the check for if the game is over, 
     * and triggering the listener for the fallDown event
     */
    @Override
    public void fallDown(){
        //checks if the game is over
        if(!isGameOver()){
            //calls the board fallDown()
            super.fallDown();
            //triggers the event for the fall down
            listener.onFallDown();
        }
    }
    
    
    /**
     * getter for the score attribute
     * @return score of the current game
     */
    public int getScore() {
        return score;
    }
    
    /**
     * setter for the score attribute
     * @param score new score from the player.
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * getter for the multiplier attribute
     * @return multiplier of current game level.
     */
    public double getMultiplier() {
        return multiplier;
    }
    
    

}
