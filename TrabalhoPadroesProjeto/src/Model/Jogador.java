/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author paulohenrique
 */
public class Jogador {
    
    private String nome;
    private String cor;
    private String ipOutroJogador;

    private static Jogador instance;
    
    public synchronized static Jogador getInstance() {
        if (instance == null) {
            instance = new Jogador();
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIpOutroJogador() {
        return ipOutroJogador;
    }

    public void setIpOutroJogador(String ipOutroJogador) {
        this.ipOutroJogador = ipOutroJogador;
    }
    
    
}
