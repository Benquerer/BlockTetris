package supertetris.boards;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This class represents a configuration for the tetris game
 * @author Andre Benquerer - n° 24633 
 */
public class ConfigGame implements Serializable {

    protected int leftkey; // what key should be used for the move left action
    protected int downkey; // what key should be used for the move down action
    protected int rigtkey; // what key should be used for the move right action
    protected int rotatekey; // what key should be used for the rotation action
    protected int falldownkey; // what key should be used for the move falldown action

    /**
     * Constructor to make a config with the default settings
     */
    public ConfigGame() {
        this.leftkey = KeyEvent.VK_LEFT;
        this.downkey = KeyEvent.VK_DOWN;
        this.rigtkey = KeyEvent.VK_RIGHT;
        this.rotatekey = KeyEvent.VK_SPACE;
        this.falldownkey = KeyEvent.VK_ENTER;
    }
    /**
     * Constructor to make a config with the custom settings
     * @param left what key should be used as the left movement key
     * @param right what key should be used as the right movement key
     * @param down what key should be used as the down movement key
     * @param rotate what key should be used as the rotation movement key
     * @param falldown what key should be used as the falldown movement key
     */
    public ConfigGame(int left, int right, int down, int rotate, int falldown) {
        setLeftkey(left);
        setRigtkey(right);
        setDownkey(down);
        setRotatekey(rotate);
        setFalldownkey(falldown);
    }
    /**
     * Uses the keybinds that is defined in the config file to move the keys in a tetris game
     * @param evt what event triggered the method()
     * @param gBoard what game will it trigger on
     */
    public void moveByKey(KeyEvent evt, TetrisGame gBoard) {
        //cheks what key triggered the event and calls the respective method that the key should use
        if (evt.getKeyCode() == falldownkey) {
            gBoard.fallDown();
        } else if (evt.getKeyCode() == rotatekey) {
            gBoard.rotate();
        } else if (evt.getKeyCode() == rigtkey) {
            gBoard.moveRight();
        } else if (evt.getKeyCode() == downkey) {
            gBoard.moveDown();
        } else if (evt.getKeyCode() == leftkey) {
            gBoard.moveLeft();
        }
    }
    
    /**
     * creates a new cfg file in the main project folder with the name "config.cfg"
     * @throws Exception 
     */
    public void saveConfig() throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("config.cfg"))) {
            out.writeObject(this);
        }
    }
    
    /**
     * creates a new cfg file in the main project folder with a name as a parameter
     * @param fName desired file name
     * @throws Exception 
     */
    public void saveConfig(String fName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fName + ".cfg"))) {
            out.writeObject(this);
        }
    }
    
    /**
     * Loads the config file
     * @return values of the atributes, and methods that the config class have
     * @throws Exception 
     */
    public static ConfigGame loadConfig() throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("config.cfg"))) {
            return (ConfigGame) in.readObject();
        }
    }
    /**
     * Loads a config file chosen by the user
     * @param fName
     * @return values of the atributes, and methods that the config class have
     * @throws Exception 
     */
    public static ConfigGame loadConfig(String fName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName))) {
            return (ConfigGame) in.readObject();
        }
    }
 
    
    /**
     * setter for the left key
     * @param leftkey key to be used
     */
    public void setLeftkey(int leftkey) {
        this.leftkey = leftkey;
    }
    
    /**
     * setter for the down key
     * @param downkey  key to be used
     */
    public void setDownkey(int downkey) {
        this.downkey = downkey;
    }
    /**
     * setter for the right key
     * @param rigtkey key to be used
     */
    public void setRigtkey(int rigtkey) {
        this.rigtkey = rigtkey;
    }
    
    /**
     * setter for the rotate key
     * @param rotatekey  key to be used
     */
    public void setRotatekey(int rotatekey) {
        this.rotatekey = rotatekey;
    }
    /**
     * setter for the falldown key
     * @param falldownkey key to be used
     */
    public void setFalldownkey(int falldownkey) {
        this.falldownkey = falldownkey;
    }
    
    /**
     * getter for the left key
     * @return what key is set.
     */
    public int getLeftkey() {
        return leftkey;
    }
    
    /**
     * getter for the down key
     * @return what key is set
     */
    public int getDownkey() {
        return downkey;
    }
    
    /**
     * getter for the right key
     * @return  what key is set
     */
    public int getRigtkey() {
        return rigtkey;
    }
    
    /**
     * getter for the rotate key
     * @return what key is set
     */
    public int getRotatekey() {
        return rotatekey;
    }
    
    /**
     * getter for the falldown key
     * @return what key is set
     */
    public int getFalldownkey() {
        return falldownkey;
    }
    
    
    
    

}
