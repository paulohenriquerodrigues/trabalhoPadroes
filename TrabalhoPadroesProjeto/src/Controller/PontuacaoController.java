/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pontuacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class PontuacaoController implements PontuacaoObserver {

    private List<PontuacaoObserver> observadores = new ArrayList<>();

    private Pontuacao [][] pontuacoes;
 
    
    public void addObservador(PontuacaoObserver obs) {
        observadores.add(obs);
    }

    @Override
    public void criarPontuacao() {
        pontuacoes = new Pontuacao[1][11];
        for (int i = 0; i < 11; i++) {
            Pontuacao p = new Pontuacao();
            if (i <= 5) {
                p.setPontuacaoVisual(i);
            } else {
                p.setPontuacaoVisual(10 - i);
            }
            p.setPontuacaoJogadorAmarelo(10 - i);
            p.setPontuacaoJogadorVermelho(i);
            pontuacoes[0][i] = p;
            
        }
    }
    
    public String getPontuacao(int row, int col){
    return (pontuacoes[row][col] == null ? null : String.valueOf(pontuacoes[row][col].getPontuacaoVisual()));
    }
    
    public void modificaPontuacao(int pontos){
        
    
    }
    
}
