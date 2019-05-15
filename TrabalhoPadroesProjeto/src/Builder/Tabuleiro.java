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
public abstract class Tabuleiro {

    public void criarTabuleiro() {
    }
    
    public Peca[][] retornaTabuleiroPeca(){return null;}

    public Pontuacao[][] retornaTabuleiroPontuacao(){return null;}

}
