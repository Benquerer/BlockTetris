/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.tests;

//     @author Andre     //

import supertetris.pieces.Piece;
import supertetris.pieces.PieceI;
import supertetris.pieces.PieceJ;
import supertetris.pieces.PieceL;
import supertetris.pieces.PieceO;
import supertetris.pieces.PieceS;
import supertetris.pieces.PieceT;
import supertetris.pieces.PieceZ;

public class TestAllPieces {

    public static void main(String[] args) {
        //Test L piece
        Piece l = new PieceL();
        System.out.println(l);
        System.out.println("");
        //Test T piece
        Piece t = new PieceT();
        System.out.println(t);
        System.out.println("");
        //Test J piece
        Piece j = new PieceJ();
        System.out.println(j);
        System.out.println("");
        //Test O piece
        Piece o = new PieceO();
        System.out.println(o);
        System.out.println("");
        //Test S piece
        Piece s = new PieceS();
        System.out.println(s);
        System.out.println("");
        //Test Z piece
        Piece z = new PieceZ();
        System.out.println(z);
        System.out.println("");
        //Test I piece
        Piece i = new PieceI();
        System.out.println(i);

    }

}
