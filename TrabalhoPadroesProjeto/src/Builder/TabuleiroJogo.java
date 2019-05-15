/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class TabuleiroJogo extends Tabuleiro {
    
        private Peca[][] tabuleiro;
        
        @Override
        public void criarTabuleiro(){
        tabuleiro = new Peca[5][5];
        }
        
        
        @Override
        public Peca[][] retornaTabuleiroPeca(){
        return tabuleiro;
        }

    
    
}
