/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.awt.Color;

/**
 *
 * @author paulohenrique
 */
public class CoacharBase implements Coachar {

    public CoacharBase() {
        chamaJFrameCoachar();
    }

    @Override
    public void chamaJFrameCoachar() {
        Coachar diferente = new CoacharView(this);
    }

    
}
