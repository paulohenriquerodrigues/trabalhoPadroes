/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pecas;

import Model.Peca;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author paulohenrique
 */
public class PecaAgua extends AbstractFactory.Agua{

    public PecaAgua() {
        super(new ImageIcon("imagens/agua.png"));
    }
}
