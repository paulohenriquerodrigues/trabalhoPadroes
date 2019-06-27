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
public class Jogador extends Thread {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    private String cor;
    private Jogador oponente;
    private int valor;
    private int tipoJardineiro; //1-Junior 2-Senior

    private boolean coachou;

    Partida partida = new PartidaReal();

    public Jogador(Socket socket) throws IOException {
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

    public Jogador getOponente() {
        return oponente;
    }

    public void setOponente(Jogador oponente) {
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

    public boolean isCoachou() {
        return coachou;
    }

    public void setCoachou(boolean coachou) {
        this.coachou = coachou;
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

                        }

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
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

    private void iniciar() throws IOException {
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        
    }

    private void processaMensagem(Mensagem msg) throws IOException, InterruptedException {
        switch (msg.getType()) {
            case verificaCor:
                output.writeObject(new Mensagem(MensagemTipo.informaCor, partida.getCor()));
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
                    this.setValor(Integer.parseInt(msg.getMessage().toString()));
                    partida.getValor(Integer.parseInt(msg.getMessage().toString()));
                    System.out.println(msg.getMessage().toString());
                    Jogo.getInstance().ambosEscolheram();
                }
                break;
            case informaValorVermelho:
                if (this.getCor().equals("Vermelho")) {
                    this.setValor(Integer.parseInt(msg.getMessage().toString()));
                    partida.getValor(Integer.parseInt(msg.getMessage().toString()));
                    System.out.println(msg.getMessage().toString());
                    Jogo.getInstance().ambosEscolheram();
                }
                break;
            case informaCoachar:
                partida.coachar(this);
                break;
            case tabuleiro:
                
            default:
        }
    }

    private void iniciaJogo() throws IOException {
        
//        for(int i = 1; i <=8; i++){
        Rodada rodada = new Rodada();
//        }

    }

    public void enviarMensagem(String msg) throws IOException {
        output.writeObject(new Mensagem(MensagemTipo.mensagem, msg));


    }

    public void coachar() throws IOException {
        output.writeObject(new Mensagem(MensagemTipo.coachar, null));

    }
    
    public void removerSapos() throws IOException{
        output.writeObject(new Mensagem(MensagemTipo.removerSapos, Jogo.getInstance().getTabuleiro()));
    }
    
}
