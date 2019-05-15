/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Model.Peca;
import Model.Pontuacao;

/**
 *
 * @author paulohenrique
 */
public class TabuleiroPontuacao extends Tabuleiro {
    
        private Pontuacao[][] tabuleiro;
        
        @Override
        public void criarTabuleiro(){
        tabuleiro = new Pontuacao[1][11];
        }
        
        
        @Override
        public Pontuacao[][] retornaTabuleiroPontuacao(){
        return tabuleiro;
        }

    
    
}
