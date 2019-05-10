/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogador;
import Model.Mensagem;
import Model.MensagemTipo;
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

    public JogadorController() {
        observadores = new ArrayList<>();
    }

    public void AddJogador(String nome, String ip, String cor) {
        Jogador.getInstance().setCor(cor);
        Jogador.getInstance().setIpOutroJogador(ip);
        Jogador.getInstance().setNome(nome);
    }

    public void verificaCor() {
        try {

            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(Jogador.getInstance().getIpOutroJogador(), 56000), 1000);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Mensagem msg = new Mensagem(MensagemTipo.verificaCor, null);
            output.writeObject(msg);
            output.flush();

            Object obj;
            obj = input.readObject();
            Mensagem msgRetorno = (Mensagem) obj;

            switch (msgRetorno.getMessage().toString()) {
                case "Amarelo":
                    observadorCor("Amarelo");
                    break;
                case "Vermelho":
                    observadorCor("Vermelho");
                    break;

                default:
                    observadorCor(null);
            }
            output.close();
            input.close();
            socket.close();
        } catch (SocketTimeoutException ex) {
            System.out.println("tempo");
            observadorCor(null);
        } catch (SocketException ex) {
            observadorCor(null);

        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public String getCor(){
    return Jogador.getInstance().getCor();
    }

}
