 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import State.Rodada;
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
public class Jogador2 extends Thread {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private String cor;
    private Jogador2 oponente;
    private int valor;
    private int tipoJardineiro; //1-Junior 2-Senior

    Partida partida = new PartidaReal();

    public Jogador2(Socket socket) throws IOException {
        this.socket = socket;
        this.setValor(0);

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

    public Jogador2 getOponente() {
        return oponente;
    }

    public void setOponente(Jogador2 oponente) {
        this.oponente = oponente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTipoJardineiro() {
        return tipoJardineiro;
    }

    public void setTipoJardineiro(int tipoJardineiro) {
        this.tipoJardineiro = tipoJardineiro;
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
                            processaMensagem(msg);
                            if(processaMensagem(msg) != null){
                            output.writeObject(processaMensagem(msg));
                                sleep(500);
                            }

                        }
                      
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Jogador2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jogador2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Jogador2.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(Jogador2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void iniciar() throws IOException {
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());

    }
    private Mensagem processaMensagem(Mensagem msg) throws IOException {
        Mensagem retorno = null;
        switch (msg.getType()) {
            case verificaCor:
                retorno = new Mensagem(MensagemTipo.informaCor, partida.getCor());
                break;
            case informaCor:
                partida.Setcor(msg.getMessage().toString());

                //significa que ambos logaram.
                if (Jogo.getInstance().j1 != null && Jogo.getInstance().j2 != null) {
                    iniciaJogo();
                }
                break;
            case informaValorAmarelo:
                if (this.getCor().equals("Amarelo")) {
                    partida.getValor(Integer.parseInt(msg.getMessage().toString()));
                }
                break;
            case informaValorVermelho:
                 if (this.getCor().equals("Vermelho")) {
                    partida.getValor(Integer.parseInt(msg.getMessage().toString()));
                }
                 break;
            default:
        }

        return retorno;
    }

    private void iniciaJogo() throws IOException {
            Rodada rodada = new Rodada();

        
    }

    public void enviarMensagem(String msg) throws IOException {
        output.writeObject(new Mensagem(MensagemTipo.mensagem, msg));
       
    }
}
