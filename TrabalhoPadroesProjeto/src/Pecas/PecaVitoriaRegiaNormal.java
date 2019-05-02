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
public class PecaVitoriaRegiaNormal extends AbstractFactory.VitoriaRegiaNormal{

    public PecaVitoriaRegiaNormal() {
        super(new ImageIcon("imagens/vitoria-regia.png"));
    }
}
