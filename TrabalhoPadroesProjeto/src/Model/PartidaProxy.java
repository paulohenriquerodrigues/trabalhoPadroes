/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class PartidaProxy implements Partida {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public PartidaProxy(ObjectOutputStream output, ObjectInputStream input) throws IOException {
        this.socket = new Socket(Jogador.getInstance().getIpOutroJogador(), 56000);
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void Setcor(String cor) {
        
        try {
            output.writeObject(new Mensagem(MensagemTipo.informaCor, cor));
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getCor() {
        Mensagem msgRetorno = null;
        try {
            Object obj;
            output.writeObject(new Mensagem(MensagemTipo.verificaCor, null));
            output.flush();
            obj = input.readObject();
            msgRetorno = (Mensagem) obj;
        } catch (IOException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (String) msgRetorno.getMessage();
    }

}
