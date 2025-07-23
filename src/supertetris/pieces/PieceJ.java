package supertetris.pieces;

import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;

/**
 * This class represents the "J" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633
 */
public class PieceJ extends Piece {

    /**
     * Creates a matrix in the form of the J Piece
     */
    static final Block[][] J = {{new Empty(), new Block('J', Color.RED)},
    {new Empty(), new Block('J', Color.RED)},
    {new Block('J', Color.RED), new Block('J', Color.RED)}};

    /**
     * Creates the Piece J using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceJ() {
        super(J, 0, 0);
    }
}
