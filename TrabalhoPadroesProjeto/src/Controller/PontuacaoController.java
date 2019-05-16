/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Builder.Tabuleiro;
import Builder.TabuleiroPontuacao;
import Model.Pontuacao;
import Model.Rodada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class PontuacaoController implements PontuacaoObserver {

    private List<PontuacaoObserver> observadores = new ArrayList<>();

    private Tabuleiro tabuleiroBuilder = new TabuleiroPontuacao();
    private Pontuacao[][] pontuacoes;
    
    private int posicao2 = 0;


    public void addObservador(PontuacaoObserver obs) {
        observadores.add(obs);
    }

    @Override
    public void criarPontuacao() {
        tabuleiroBuilder.criarTabuleiro();
        pontuacoes = tabuleiroBuilder.retornaTabuleiroPontuacao();

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

    public String getPontuacao(int row, int col) {
        return (pontuacoes[row][col] == null ? null : String.valueOf(pontuacoes[row][col].getPontuacaoVisual()));
    }

    @Override
    public void modificarPontuacao(String corJogador, int pontos, int posicao) {
        if (corJogador.equals("Amarelo")) {
            for (int i = 0; i < 11; i++) {
                if (pontuacoes[0][i].getPontuacaoJogadorAmarelo() == pontos) {
                    posicao2 = i;
                    observadores.forEach((obs) -> {
                        obs.modificarPontuacao(corJogador, pontos, posicao2);
                    });
                }
            }
        } else {
            for (int i = 0; i < 11; i++) {
                if (pontuacoes[0][i].getPontuacaoJogadorVermelho() == pontos) {
                    posicao2 = i;
                    observadores.forEach((obs) -> {
                        obs.modificarPontuacao(corJogador, pontos, posicao2);
                    });
                }
            }
        }

    }

}
