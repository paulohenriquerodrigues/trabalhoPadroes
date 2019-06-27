/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pecas;

import Model.Peca;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author paulohenrique
 */
public class PecaVitoriaRegiaFlorAmarela extends AbstractFactory.VitoriaRegiaFlorAmarela implements Serializable{
     private static final long serialVersionUID = 7526472295622776145L;

    public PecaVitoriaRegiaFlorAmarela() {
        super(new ImageIcon("imagens/vitoria-regia-claro-flor-amarela.png"));
    }
}
