package supertetris.blocks;


import java.awt.Color;

/**
 * This class extends the class Block to create a special type of block (empty) that will be used for the board
 * @author Andre Benquerer - n° 24633 
 */
public class Empty extends Block{
    
    /**
     * Creates a block with the character '.' to represent a empty space in a tetris board
     */
    public Empty(){
        super('.', Color.LIGHT_GRAY);
    }
    
    /**
     * @return returns a clone of an empty block
     */
    @Override
    public Block getClone(){
        return new Empty();
    }
}
