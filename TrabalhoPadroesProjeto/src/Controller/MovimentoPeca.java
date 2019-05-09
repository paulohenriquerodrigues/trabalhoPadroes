/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AbstractFactory.Agua;
import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class MovimentoPeca {
    private Peca peca;
    private int x;
    private int y;
    
    public void vaiParaCima(Peca peca) {
        if (peca == null || peca.getClass() == Agua.class) {
            y--;
        }
    }
    


    
}
