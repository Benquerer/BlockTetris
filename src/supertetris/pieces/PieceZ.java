package supertetris.pieces;

import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;

/**
 * This class represents the "Z" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633 
 */
public class PieceZ extends Piece {

    /**
     * Creates a matrix in the form of the Z Piece
     */
    static final Block[][] Z = {{new Block('Z', Color.MAGENTA), new Block('Z', Color.MAGENTA), new Empty()},
    {new Empty(), new Block('Z', Color.MAGENTA), new Block('Z', Color.MAGENTA)}};

    /**
     * Creates the Piece Z using the matrix and sets the position on the board
     * as y = 0 and x =0
     */
    public PieceZ() {
        super(Z, 0, 0);
    }
}
