/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.tests;

//     @author Andre     //
import supertetris.pieces.Piece;
import supertetris.pieces.PieceL;
import supertetris.pieces.PieceT;

public class TestPiece2 {

    public static void main(String[] args) {
        Piece l = new PieceL();
        l.moveRight();
        System.out.println(l);
        Piece t = new PieceT();
        t.rotate();
        t.moveDown();
        System.out.println(t);

    }

}
