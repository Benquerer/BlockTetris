/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supertetris.tests;

//     @author Andre     //

import supertetris.blocks.Block;

public class TestBlock {

    public static void main(String[] args) {
        //construtor com parâmetros
        Block b1 = new Block('L');
        //construor cópia
        Block b2 = new Block(b1);
        //clonar um objeto
        Block b3 = b2.getClone();
        System.out.println("Construtores e clone");
        //tostring
        System.out.println("b1 = " + b1 + "\t b2 = " + b2 + "\t b3 = " + b3);
        //modificador
        b2.setTxt('X');
        System.out.println(" Modificador b2");
        System.out.println("b1 = " + b1 + "\t b2 = " + b2 + "\t b3 = " + b3);
    }

}
