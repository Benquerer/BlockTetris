package supertetris.pieces;

import java.awt.Color;
import supertetris.blocks.Block;
import supertetris.blocks.Empty;

/**
 * This class represents the "S" shaped piece in the tetris game
 * @author Andre Benquerer - n° 24633 
 */
public class PieceS extends Piece{
    
    /**
     * Creates a matrix in the form of the S Piece
     */
    static final Block[][] S= {{new Empty(),new Block('S',Color.GREEN),new Block('S',Color.GREEN)},
        {new Block('S',Color.GREEN),new Block('S',Color.GREEN),new Empty()}};
   
    /**
     * Creates the Piece S using the matrix and sets the position on the board as y = 0 and x =0
     */
    public PieceS(){
        super(S,0,0);
    }
}
