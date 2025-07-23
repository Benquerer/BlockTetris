package supertetris.boards;

/**
 * this interface represents the listener for the game tetris
 * @author Andre
 */
public interface GameListener {
    
    /**
     * Triggered once the game is over
    */
    void onGameOver();
    /**
     * Triggered when a piece is placed in the board
     */
    void piecePlaced();
    
   /**
    * Triggered when a line is deleted
    * @param line score to be added.
    */
    void onDeleteLine(int score);
    
    /**
     * Triggered when the player uses the fall down key
     */
    void onFallDown();
    
}
