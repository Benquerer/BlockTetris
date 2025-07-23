/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.tests;

//     @author Andre     //
import supertetris.boards.Board;

public class TestBoard {

    public static void main(String[] args) {
        Board tetris = new Board(10, 10);
        System.out.println(tetris);

        tetris.moveDown();
        System.out.println(tetris);
        tetris.moveDown();
        System.out.println(tetris);
        tetris.moveDown();
        System.out.println(tetris);

    }
}
