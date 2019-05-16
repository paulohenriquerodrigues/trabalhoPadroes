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
public class Rodada {
    
    private int valorJogadorAmarelo;
    private int valorJogadorVermelho;
    private String corJardineiroJunior;
    private String corJardineiroSenior;
    
    private static Rodada instance;
    
    public synchronized static Rodada getInstance() {
        if (instance == null) {
            instance = new Rodada();
        }
        return instance;
    }

    public int getValorJogadorAmarelo() {
        return valorJogadorAmarelo;
    }

    public void setValorJogadorAmarelo(int valorJogadorAmarelo) {
        this.valorJogadorAmarelo = valorJogadorAmarelo;
    }

    public int getValorJogadorVermelho() {
        return valorJogadorVermelho;
    }

    public void setValorJogadorVermelho(int valorJogadorVermelho) {
        this.valorJogadorVermelho = valorJogadorVermelho;
    }

    public String getCorJardineiroJunior() {
        return corJardineiroJunior;
    }

    public void setCorJardineiroJunior(String corJardineiroJunior) {
        this.corJardineiroJunior = corJardineiroJunior;
    }

    public String getCorJardineiroSenior() {
        return corJardineiroSenior;
    }

    public void setCorJardineiroSenior(String corJardineiroSenior) {
        this.corJardineiroSenior = corJardineiroSenior;
    }
    
    
}


