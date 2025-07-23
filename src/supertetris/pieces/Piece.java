package supertetris.pieces;


import supertetris.blocks.Block;
import supertetris.blocks.BlockMatrix;

/**
 * This class represents a piece in the tetris system, which is a matrix of blocks
 * @author Andre Benquerer - n° 24633
 */
public class Piece extends BlockMatrix {

    /**
     * X position of the piece on the board
     */
    protected int positionX;

    /**
     * Y position of the piece on the board
     */
    protected int positionY;

    /**
     * Creates a piece of the game.
     *
     * @param mat matrix that represents the piece
     * @param y Position of the Piece in the Y axis
     * @param x Position of the Piece in the X axis
     */
    public Piece(Block[][] mat, int y, int x) {
        super(mat);
        this.positionY = y;
        this.positionX = x;
    }

    /**
     * Creates a piece of the game using another piece matrix and positions
     *
     * @param p piece that should be used for copy
     */
    public Piece(Piece p) {
        this(p.matrix, p.positionY, p.positionX);
    }

    /**
     * @return returns the X position of a piece
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Sets the X position of the Piece
     *
     * @param x value of the position on the X axis
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return returns the Y position of a piece
     */
    public int getPositionY( ) {    
        return positionY;
    }

    /**
     * Sets the Y position of the Piece
     *
     * @param y value of the position on the Y axis
     */
    public void setPositionY(int positionY) {    
        this.positionY = positionY;
    }

    /**
     * Decreases by 1 the X coordinate of the piece, moving it to the left
     */
    public void moveLeft() {
        positionX--;
    }

    /**
     * Increases by 1 the X coordinate of the piece, moving it to the right
     */
    public void moveRight() {
        positionX++;
    }

    /**
     * Increases by 1 the Y coordinate of the piece, moving it Down
     */
    public void moveDown() {
        positionY++;
    }

    /**
     * @return returns a clone of the piece
     */
    @Override
    public Piece getClone() {
        return new Piece(this);
    }

    @Override
    public String toString() {
        return positionY + " " + positionX + "\n" + super.toString();
    }
}
