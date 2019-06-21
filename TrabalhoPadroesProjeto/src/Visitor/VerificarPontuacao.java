/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class VerificarPontuacao implements Visitor {
    
    private int pontuacao;
    
    
    @Override
    public void visit(Peca[][] tabuleiro) {
        System.out.println("entrou");
    }
    
}
