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

    private ObjectOutputStream output;
    private ObjectInputStream input;

    public PartidaProxy(ObjectOutputStream output, ObjectInputStream input) throws IOException {
        this.output = output;
        this.input = input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public ObjectInputStream getInput() {
        return input;
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

    @Override
    public String enviarMensagem(String mensagem) {
        return null;

    }

    @Override
    public String getMensagem() {
        Mensagem msgRetorno = null;
        try {
            Object obj = input.readObject();

            msgRetorno = (Mensagem) obj;

        } catch (IOException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msgRetorno.getMessage().toString();

    }

    @Override
    public void getValor(int valor) {
        try {
            if (Jogador.getInstance().getCor().equals("Amarelo")) {
                Object obj;
                output.writeObject(new Mensagem(MensagemTipo.informaValorAmarelo, valor));
            } else {
                Object obj;
                output.writeObject(new Mensagem(MensagemTipo.informaValorVermelho, valor));
            }
        } catch (IOException ex) {
            Logger.getLogger(PartidaProxy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
