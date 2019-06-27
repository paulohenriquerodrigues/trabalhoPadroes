/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Builder.Tabuleiro;
import Builder.TabuleiroJogo;
import static Model.MensagemTipo.tabuleiro;
import Pecas.FabricaPeca;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class Jogo {

    ServerSocket serverSocket;
    
     List<RespostaObserver> observadores = new ArrayList<>();
     
        Peca[][] tabuleiro = new Peca[5][5];


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void iniciarServer() throws IOException {
        this.serverSocket = new ServerSocket(56000);
    }

    private static Jogo jogo;

    public static Jogo getInstance() {
        if (jogo == null) {
            jogo = new Jogo();
        }
        return jogo;

    }

    Jogador j1;
    Jogador j2;

    public static Jogo getJogo() {
        return jogo;
    }

    public static void setJogo(Jogo jogo) {
        Jogo.jogo = jogo;
    }

    public Jogador getJ1() {
        return j1;
    }

    public void setJ1(Socket s) throws IOException {
        this.j1 = new Jogador(s);
    }

    public Jogador getJ2() {
        return j2;
    }

    public void setJ2(Socket s) throws IOException {
        this.j2 = new Jogador(s);
    }

    public Peca[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Peca[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    

    public void ambosEscolheram() {
        if (Jogo.getInstance().j1.getValor() != 0
                && Jogo.getInstance().j2.getValor() != 0) {
            if(Jogo.getInstance().j1.getValor() ==
                    Jogo.jogo.j2.getValor()){
                resposta(0);
                //coachar
            }else{
                resposta(1);
                //segue normal
            }
            
        }

    }

    public void addObserver(RespostaObserver obs) {
        observadores.add(obs);
    }
    
    public void removerObserver(RespostaObserver obs) {
        observadores.remove(obs);
    }

    public void resposta(int i) {
        for (RespostaObserver obs : observadores) {
            obs.Resposta(i);
        }

    }
    
    public void alguemCoachou() {
        for (RespostaObserver obs : observadores) {
            obs.coachou();
        }

    }

}
