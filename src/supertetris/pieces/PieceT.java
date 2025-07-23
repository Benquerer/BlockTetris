package supertetris.pieces;

import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;

/**
 * This class represents the "T" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633
 */
public class PieceT extends Piece {

    /**
     * Creates a matrix in the form of the T Piece
     */
    static final Block[][] T = {{new Block('T', Color.YELLOW), new Block('T', Color.YELLOW), new Block('T', Color.YELLOW)},
    {new Empty(), new Block('T', Color.YELLOW), new Empty()}};

    /**
     * Creates the Piece T using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceT() {
        super(T, 0, 0);
    }
}
