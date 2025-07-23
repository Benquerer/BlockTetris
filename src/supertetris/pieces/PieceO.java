package supertetris.pieces;


import java.awt.Color;
import supertetris.blocks.Block;

/**
 * This class represents the "O" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633 
 */
public class PieceO extends Piece {

    /**
     * Creates a matrix in the form of the O Piece
     */
    static final Block[][] O = {{new Block('O', Color.BLUE), new Block('O', Color.BLUE)},
    {new Block('O', Color.BLUE), new Block('O', Color.BLUE)}};

    /**
     * Creates the Piece O using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceO() {
        super(O, 0, 0);
    }
}
