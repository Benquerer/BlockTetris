package supertetris.pieces;


import java.awt.Color;
import supertetris.blocks.Block;
/**
 * This class represents the "I" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633
 */
public class PieceI extends Piece {

    /**
     * Creates a matrix in the form of the I Piece
     */
    static final Block[][] I = {{new Block('I', Color.CYAN)}, {new Block('I', Color.CYAN)}, {new Block('I', Color.CYAN)}};

    /**
     * Creates the Piece I using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceI() {
        super(I, 0, 0);
    }
}
