/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author paulohenrique
 */
public class Pontuacao {
    
    private int pontuacaoVisual;
    private int pontuacaoJogadorAmarelo;
    private int pontuacaoJogadorVermelho;
    private int pontuacaoAtualAmarelo;
    private int pontuacaoAtualVermelho;

    public Pontuacao() {
    }

    public Pontuacao(int pontuacaoVisual, int pontuacaoJogadorAmarelo, int pontuacaoJogadorVermelho, int pontuacaoAtualAmarelo, int pontuacaoAtualVermelho) {
        this.pontuacaoVisual = pontuacaoVisual;
        this.pontuacaoJogadorAmarelo = pontuacaoJogadorAmarelo;
        this.pontuacaoJogadorVermelho = pontuacaoJogadorVermelho;
        this.pontuacaoAtualAmarelo = pontuacaoAtualAmarelo;
        this.pontuacaoAtualVermelho = pontuacaoAtualVermelho;
    }

    public int getPontuacaoVisual() {
        return pontuacaoVisual;
    }

    public void setPontuacaoVisual(int pontuacaoVisual) {
        this.pontuacaoVisual = pontuacaoVisual;
    }

    public int getPontuacaoJogadorAmarelo() {
        return pontuacaoJogadorAmarelo;
    }

    public void setPontuacaoJogadorAmarelo(int pontuacaoJogadorAmarelo) {
        this.pontuacaoJogadorAmarelo = pontuacaoJogadorAmarelo;
    }

    public int getPontuacaoJogadorVermelho() {
        return pontuacaoJogadorVermelho;
    }

    public void setPontuacaoJogadorVermelho(int pontuacaoJogadorVermelho) {
        this.pontuacaoJogadorVermelho = pontuacaoJogadorVermelho;
    }

    public int getPontuacaoAtualAmarelo() {
        return pontuacaoAtualAmarelo;
    }

    public void setPontuacaoAtualAmarelo(int pontuacaoAtualAmarelo) {
        this.pontuacaoAtualAmarelo = pontuacaoAtualAmarelo;
    }

    public int getPontuacaoAtualVermelho() {
        return pontuacaoAtualVermelho;
    }

    public void setPontuacaoAtualVermelho(int pontuacaoAtualVermelho) {
        this.pontuacaoAtualVermelho = pontuacaoAtualVermelho;
    }

    @Override
    public String toString() {
        return "Pontuacao{" + "pontuacaoVisual=" + pontuacaoVisual + ", pontuacaoJogadorAmarelo=" + pontuacaoJogadorAmarelo + ", pontuacaoJogadorVermelho=" + pontuacaoJogadorVermelho + ", pontuacaoAtualAmarelo=" + pontuacaoAtualAmarelo + ", pontuacaoAtualVermelho=" + pontuacaoAtualVermelho + '}';
    }
    
    
    
}
