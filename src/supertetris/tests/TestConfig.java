/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.tests;

//     @author Andre     //
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import supertetris.boards.ConfigGame;

public class TestConfig {

    public static void main(String[] args) {

        File cfg = new File("config.cfg");
        cfg.delete();
        ConfigGame config;
        
        int left = KeyEvent.getExtendedKeyCodeForChar('t');
        int right = KeyEvent.getExtendedKeyCodeForChar('y');
        int down = KeyEvent.getExtendedKeyCodeForChar('u');
        int rotate = KeyEvent.getExtendedKeyCodeForChar('i');
        int falldown = KeyEvent.getExtendedKeyCodeForChar('o');
        try {
            config = ConfigGame.loadConfig();
        } catch (Exception ex) {
            config = new ConfigGame(left, right, down, rotate, falldown); // criar config com as teclas acima
            try {
                config.saveConfig();
            } catch (Exception ex1) {
                System.out.println("NOT SUPORTED");
            }
        }

    }
}