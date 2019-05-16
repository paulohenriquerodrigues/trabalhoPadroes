/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogador;
import Model.Mensagem;
import Model.MensagemTipo;
import Model.Peca;
import Model.Rodada;
import Pecas.FabricaPeca;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class RodadaController {

    private List<RodadaObserver> observadores = new ArrayList<>();

    public RodadaController() {
        Rodada.getInstance().setValorJogadorAmarelo(0);
        Rodada.getInstance().setValorJogadorVermelho(0);
    }

    public void addObservador(RodadaObserver obs) {
        observadores.add(obs);
    }

    public void escolherflor(int valor) throws IOException, ClassNotFoundException {
        if (Jogador.getInstance().getCor().equals("Amarelo")) {
            Rodada.getInstance().setValorJogadorAmarelo(valor);
        } else if (Jogador.getInstance().getCor().equals("Vermelho")) {
            Rodada.getInstance().setValorJogadorVermelho(valor);
        }

        Socket socket = new Socket();
        socket.setReuseAddress(true);
        socket.connect(new InetSocketAddress(Jogador.getInstance().getIpOutroJogador(), 56000), 1000);
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

        Mensagem msg = new Mensagem(MensagemTipo.informaValorFlorSelecionada, valor);
        output.writeObject(msg);
        output.flush();

        floresEscolhidas();
    }

    public void floresEscolhidas() {
        while (Rodada.getInstance().getValorJogadorAmarelo() < 1 || Rodada.getInstance().getValorJogadorVermelho() < 1) {
            observadores.forEach((obs) -> {
                // mostra valor somente do jogador que selecionou, o outro não sabe o número
                if (Jogador.getInstance().getCor().equals("Amarelo")) {
                    obs.FloresNãoEscolhidas(Rodada.getInstance().getValorJogadorAmarelo());
                } else if (Jogador.getInstance().getCor().equals("Vermelho")) {
                    obs.FloresNãoEscolhidas(Rodada.getInstance().getValorJogadorVermelho());
                }
            });

        }
        // se ambos já escolheram a flor, mostra valor
        observadores.forEach((obs) -> {
            obs.FloresEscolhidas(Rodada.getInstance().getValorJogadorAmarelo(), Rodada.getInstance().getValorJogadorVermelho());
        });

        verificaEmpate();

    }

    public void verificaEmpate() {
        if (Rodada.getInstance().getValorJogadorAmarelo() == Rodada.getInstance().getValorJogadorVermelho()) {
            //Devolve flores;
            observadores.forEach((obs) -> {
                obs.empate();
            });
            
        } else {
            defineJardineiros();
        }
    }

    public void defineJardineiros() {
        String msg;
        if (Rodada.getInstance().getValorJogadorAmarelo() > Rodada.getInstance().getValorJogadorVermelho()) {
            Rodada.getInstance().setCorJardineiroJunior("Vermelho");
            Rodada.getInstance().setCorJardineiroSenior("Amarelo");
        } else {
            Rodada.getInstance().setCorJardineiroJunior("Amarelo");
            Rodada.getInstance().setCorJardineiroSenior("Vermelho");
        }
        if (Jogador.getInstance().getCor().equals(Rodada.getInstance().getCorJardineiroJunior())) {
            msg = "Você é o Jardineito Junior";
        } else {
            msg = "Você é o Jardineito Sênior";
        }
        observadores.forEach((obs) -> {
            obs.msgTipoJardineiro(msg);
        });
        
        colocaJardineiroJuniorEscura();
    
    }
    
    public void colocaJardineiroJuniorEscura(){
    observadores.forEach((obs) -> {
            obs.jardineiroJuniorEscura();
        });
    }
    
    public void jardineiroSeniorcolocaPeca(){
    observadores.forEach((obs) -> {
            obs.jardineiroSeniorcolocaPeca();
        });
    }
    
    }



