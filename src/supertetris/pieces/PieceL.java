package supertetris.pieces;


import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;

/**
 * This class represents the "L" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633
 */
public class PieceL extends Piece {

    /**
     * Creates a matrix in the form of the L Piece
     */
    static final Block[][] L = {{new Block('L', Color.ORANGE), new Empty()},
    {new Block('L', Color.ORANGE), new Empty()},
    {new Block('L', Color.ORANGE), new Block('L', Color.ORANGE)}};

    /**
     * Creates the Piece L using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceL() {
        super(L, 0, 0);
    }

}
