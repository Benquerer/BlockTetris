package supertetris.boards;

import java.awt.Graphics;
import java.util.Random;
import supertetris.blocks.Block;
import supertetris.blocks.BlockMatrix;
import supertetris.blocks.Empty;
import supertetris.pieces.Piece;
import supertetris.pieces.PieceI;
import supertetris.pieces.PieceJ;
import supertetris.pieces.PieceL;
import supertetris.pieces.PieceO;
import supertetris.pieces.PieceS;
import supertetris.pieces.PieceT;
import supertetris.pieces.PieceZ;
/**
 * This class represents the board in the tetris game. It extends the class BlockMatrix inheriting its methods. 
 * the board is composed of empty blocks and a matrix called current that represents a falling piece 
 * @author Andre Benquerer - n° 24633 
 */
public class Board extends BlockMatrix{
    //Given by professor Manso
    @Override
    public void paintComponent(Graphics g) {
        draw(g, 0, 0, getWidth(), getHeight());
    }
    //Given by professor Manso
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        super.draw(gr, px, py, width, height);
        int sizeX = width / getColumms();
        int sizeY = height / getLines();
        current.draw(gr, px + current.getPositionX() * sizeX,
                py + current.getPositionY() * sizeY,
                sizeX * current.getColumms(),
                sizeY * current.getLines());
    }

    /**
     * Piece that is currently playable on the board
     */
    protected Piece current;

    /**
     * Generates a board given a matrix and a piece to start with
     *
     * @param mat matrix which dimension will be used for the board
     * @param current piece that should start the game
     */
    public Board(Block[][] mat, Piece current) {
        super(mat);
        this.current = current;
    }

    /**
     * Creates a Board with no parameters
     */
    public Board() {
        this(25, 15);
    }

    /**
     * Generates a board from another board
     *
     * @param b
     */
    public Board(Board b) {
        super(b);
        this.current = b.current.getClone();
    }

    /**
     * Creates a board given the desired dimensions, and generates a piece to
     * start with
     *
     * @param lines number of lines the board should have
     * @param cols number of columns the board should have
     */
    public Board(int lines, int cols) {
        reCreate(lines, cols);
    }

    /**
     * @return returns the piece currently playable
     */
    public Piece getCurrent() {
        return current;
    }

    /**
     * Sets a Piece as the current piece playable on the board
     *
     * @param current Piece that should be playable.
     */
    public void setCurrent(Piece current) {
        this.current = current;
    }
    /**
     * Recreates the board by replacing the matrix with the dimensions specified by the parameters, 
     * which is made out of empty blocks only, also generating a new piece randomly to be the new current
     *
     * @param lines number of lines intended in the new matrix
     * @param cols number of columns intended in the new matrix
     */
    public void reCreate(int lines, int cols) {
        this.matrix = new Block[lines][cols];
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < cols; x++) {
                matrix[y][x] = new Empty();
            }
        }
        generateRandomPiece();
        repaint();
    }

    /**
     * Generates a random piece out of any of the 7 types (L, I, J, O, S, T and
     * Z)
     */
    public void generateRandomPiece() {
        Random rnd = new Random();
        switch (rnd.nextInt(7)) {
            case 1:
                this.current = new PieceL();
                break;
            case 2:
                this.current = new PieceI();
                break;
            case 3:
                this.current = new PieceJ();
                break;
            case 4:
                this.current = new PieceO();
                break;
            case 5:
                this.current = new PieceS();
                break;
            case 6:
                this.current = new PieceT();
                break;
            default:
                this.current = new PieceZ();
                break;
        }
        this.current.setPositionY(0);
        this.current.setPositionX(getColumms()/ 2 - current.getColumms() / 2);
        repaint();
    }

    /**
     * Verifies if the piece, if placed on the board, would not be on top of
     * other pieces, then freezes it as part of the Board.
     */
    public void freezePiece() {
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumms(); x++) {
                //verificar se é vazio
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x].getClone();
            }
        }
        repaint();
    }

    /**
     * Creates a drawn version of the board.
     *
     * @return returns the text version of the board as it is in the current
     * state.
     */
    @Override
    public String toString() {
        Board clone = new Board(this);
        clone.freezePiece();
        String txt = "";
        for (int y = 0; y < clone.matrix.length; y++) {
            for (int x = 0; x < clone.matrix[y].length; x++) {
                txt += clone.matrix[y][x];
            }
            txt += "\n";
        }
        return txt;
        //TROCAR PARA STRINGBUILDER POSTERIORMENTE
    }

    /**
     * Checks if a piece can move given the directions intended, without it
     * colliding with other pieces or going out of bounds
     *
     * Uses a screen for the orientation (Y axis increases when going down), not
     * a Cartesian Plane.
     *
     * @param dy direction on the Y axis (Lines / down)
     * @param dx direction on the X axis (Columns / left and right)
     * @return returns if the intended move is possible
     */
    public boolean canMovePiece(int dy, int dx) {

        int newX = current.getPositionX() + dx;
        int newY = current.getPositionY() + dy;
        if (newX < 0) {
            return false;
        }
        if (newX + current.getColumms() > getColumms()) {
            return false;
        }
        if (newY + current.getLines() > getLines()) {
            return false;
        }

        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColumms(); x++) {
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                if (!(matrix[current.getPositionY() + dy + y][current.getPositionX() + dx + x] instanceof Empty)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Checks if the current, if rotated, wont collide with other pieces on the
     * board
     *
     * @return Boolean for the ability to rotate the piece
     */
    public boolean canRotatePiece() {
        //creates a clone to simulate the rotation of de piece
        Piece cClone = current.getClone();
        //rotates the clone
        cClone.rotate();

        //checks if there will not be a collision on te rotation
        for (int y = 0; y < cClone.getLines(); y++) {
            for (int x = 0; x < cClone.getColumms(); x++) {
                if (cClone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                if (!(matrix[cClone.getPositionY() + y][cClone.getPositionX() + x] instanceof Empty)) {
                    //if a collision was detected with the clone, than the piece can´t rotate
                    return false;
                }
            }
        }
        //if theres no collision with the clone, allows the actual piece to rotate
        return true;
    }

    /**
     * Moves the Piece to the left if possible
     */
    public void moveLeft() {
        if (canMovePiece(0, -1)) {
            current.moveLeft();
        }
        repaint();
    }

    /**
     * Moves the Piece to the right if possible
     */
    public void moveRight() {
        if (canMovePiece(0, 1)) {
            current.moveRight();
        }
        repaint();
    }

    /**
     * Moves the Piece to the down if possible. If the Piece can´t move down,
     * freezes the piece and generates a new one
     */
    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();
            repaint();
        } else {
            freezePiece();
            generateRandomPiece();
        }
        
    }

    /**
     * Makes the piece go down as much as possible without colliding with other
     * pieces
     */
    public void fallDown() {
        while (canMovePiece(1, 0)) {
            current.moveDown();
            repaint();
        }
        freezePiece();
        generateRandomPiece();
    }

    /**
     * Rotates the piece if possible.
     */
    public void rotate() {
        if (canRotatePiece()) {
            current.rotate();
        }
        repaint();
    }

}
