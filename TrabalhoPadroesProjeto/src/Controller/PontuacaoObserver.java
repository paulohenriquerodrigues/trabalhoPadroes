/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pontuacao;

/**
 *
 * @author paulohenrique
 */
public interface PontuacaoObserver {
    
    void criarPontuacao();
    void modificarPontuacao(String corJogador,int pontos, int posicao);
    
}
