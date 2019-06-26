/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import sun.swing.icon.SortArrowIcon;

/**
 *
 * @author paulohenrique
 */
public class CoacharView extends CoacharDecorator {

    public CoacharView(Coachar coachar) {
        super(coachar);
        this.chamaJFrameCoachar();
    }

    @Override
    public void chamaJFrameCoachar() {
        super.chamaJFrameCoachar();
        Color [] cores = {Color.blue, Color.red, Color.GREEN};
        int i = new Random().nextInt(2);
        i = i +1;
        JFrameCoachar jframe = new JFrameCoachar(cores[i]);
        jframe.setVisible(true);
            
        }
}
