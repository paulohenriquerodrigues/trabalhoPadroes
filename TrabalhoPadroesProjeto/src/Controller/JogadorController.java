/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogador;
import Model.Mensagem;
import Model.MensagemTipo;
import Model.Partida;
import Model.PartidaProxy;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class JogadorController {

    private List<JogadorObserver> observadores;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    Partida partida;

    public JogadorController() {
        observadores = new ArrayList<>();
        this.socket = socket;
        this.output = output;
        this.input = input;
        

    }

    public void AddJogador(String nome, String ip, String cor) throws IOException {
        Jogador.getInstance().setCor(cor);
        Jogador.getInstance().setIpOutroJogador(ip);
        Jogador.getInstance().setNome(nome);
        partida = new PartidaProxy(output, input);
    }

    public void verificaCor() {
        String cor = partida.getCor();
        observadorCor(cor);

    }
    
    public void informaCor() {
        partida.Setcor(Jogador.getInstance().getCor());
    }

    public void observadorCor(String cor) {
        for (JogadorObserver obs : observadores) {
            obs.cor(cor);
        }

    }

    public void addObservador(JogadorObserver obs) {
        observadores.add(obs);
    }

    public void setCor(String cor) {
        Jogador.getInstance().setCor(cor);
    }

    public String getCor() {
        return Jogador.getInstance().getCor();
    }

}
