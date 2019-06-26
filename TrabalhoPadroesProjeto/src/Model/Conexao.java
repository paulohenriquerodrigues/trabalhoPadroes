/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.JogadorController;
import Controller.JogadorObserver;
import Controller.RodadaController;
import com.sun.corba.se.impl.io.OutputStreamHook;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class Conexao extends Thread {

    private List<ConexaoObserver> observadores;

    Partida partida;

    RodadaController rodada;
    JogadorController jogador = new JogadorController();

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public Conexao() throws IOException {
        observadores = new ArrayList<>();
        socket = new Socket(Jogador.getInstance().getIpOutroJogador(), 56000);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        
        partida = new PartidaProxy(output, input);
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj;
                obj = input.readObject();
                Mensagem msg = (Mensagem) obj;
                if (msg.getType().toString().length()>0) {
                    processaMensagem(msg);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void processaMensagem(Mensagem msg) {
        Mensagem retorno = null;
        switch (msg.getType()) {
            case mensagem:
                Mensagens(msg.getMessage().toString());
                break;
            case verificaCor:
                jogador.verificaCor();
                break;
            case coachar:
                Coachar();
                break;    
            default:
        }
    }

    public void addObserver(ConexaoObserver obs) {
        observadores.add(obs);
    }

    public void Mensagens(String msg) {
        for (ConexaoObserver obs : observadores) {
            obs.mensagem(msg);
        }

    }
    
    public void Coachar () {
        for (ConexaoObserver obs : observadores) {
            obs.coachar();
        }

    }
}
