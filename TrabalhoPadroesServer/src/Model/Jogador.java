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
public class Jogador extends Thread {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String cor;
    private Jogador oponente;

    Partida partida = new PartidaReal();

    public Jogador(Socket socket) throws IOException {
        this.socket = socket;
        
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Jogador getOponente() {
        return oponente;
    }

    public void setOponente(Jogador oponente) {
        this.oponente = oponente;
    }

    @Override
    public void run() {
        try {
            iniciar();
            try {
                while (true) {
                    try {
                        
                        Object obj;
                        obj = input.readObject();
                        if (obj != null) {
                            Mensagem msg = (Mensagem) obj;
                            output.writeObject(processaMensagem(msg));
                            output.flush();
                            
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void iniciar() throws IOException{
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        
        if(Jogo.getInstance().j1 == null){
        Jogo.getInstance().setJ1(this);
        }else{
        Jogo.getInstance().setJ2(this);
            setOponente(Jogo.getInstance().j1);
            Jogo.getInstance().j1.setOponente(this);
        }
        
    
    }

    private Mensagem processaMensagem(Mensagem msg) {
        Mensagem retorno = null;
        switch (msg.getType()) {
            case verificaCor:
                retorno = new Mensagem(MensagemTipo.informaCor, partida.getCor());
                break;
            case informaCor:
                partida.Setcor(msg.getMessage().toString());
                retorno = new Mensagem(null, "Lido");
                break;
            case informaValorFlorSelecionada:
            default:
        }

        return retorno;
    }
}
