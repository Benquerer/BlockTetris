package supertetris.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import supertetris.ui.Drawable;

/**
 * this class represents a block in the tetris system
 *
 * @author Andre Benquerer - n° 24633 
 */
public class Block extends JComponent implements Drawable{

    //Given by professor Manso
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr); //build component
        draw(gr, 0, 0, getWidth() - 1, getHeight() - 1);
    }
    
    //Given by professor Manso
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        //color of fill
        gr.setColor(blockColor);
        //fill block
        gr.fill3DRect(px, py, width, height, true);
        //color of line
        gr.setColor(Color.BLACK);
        //draw line
        gr.draw3DRect(px, py, width, height, true);
    }
    /**
     * character to identify the block
     */
    protected char txt;
    /**
     * defines the color for the block when drawn
     */
    protected Color blockColor;
    
    /**
     * Constructor for a block
     * @param ch character 
     * @param color color
     */
    public Block(char ch,Color color) {
        this.txt = ch;
        this.blockColor = color;
    }

    /**
     * Default constructor for a block without a specified color or character
     */
    public Block(){
        this(' ', Color.BLACK);
    }
    

    /**
     * constructor with a character
     *
     * @param txt character 
     */
    public Block(char txt) {
        this.txt = txt;
        this.blockColor = Color.CYAN;
    }

    /**
     * constructor with a block (copy)
     *
     * @param b block to be used as model
     */
    public Block(Block b) {
        this(b.txt,b.blockColor);
    }

    /**
     * selector of txt parameter
     *
     * @return character of the block
     */
    public char getTxt() {
        return txt;
    }

    /**
     * modifier of txt parameter
     *
     * @param txt new character
     */
    public void setTxt(char txt) {
        this.txt = txt;
    }

    /**
     * selector of color parameter
     *
     * @return color of the block
     */
    public Color getBlockColor() {
        return blockColor;
    }

    /**
     * modifier of color parameter
     * @param blockColor new intended color
     */
    public void setBlockColor(Color blockColor) {
        this.blockColor = blockColor;
    }
    
    

    /**
     * convert block to string
     *
     * @return text of block
     */
    public String toString() {
        return txt + " ";
    }

    /**
     * makes a deep clone of the object
     *
     * @return deep clone
     */
    public Block getClone() {
        return new Block(this);
    }

}
