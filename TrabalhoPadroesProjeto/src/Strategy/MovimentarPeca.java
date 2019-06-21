/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public interface MovimentarPeca {
    
    Peca[][] movimentar(Peca[][] tabuleiro, String movimento, Peca peca, int x, int y);
    
}
