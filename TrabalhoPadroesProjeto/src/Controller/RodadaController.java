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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class RodadaController {

    private List<RodadaObserver> observadores = new ArrayList<>();
   
    public RodadaController(){
        Rodada.getInstance().setValorJogadorAmarelo(0);
        Rodada.getInstance().setValorJogadorVermelho(0);
    }

    public void addObservador(RodadaObserver obs) {
        observadores.add(obs);
    }

    public void escolherflor(int valor) throws IOException, ClassNotFoundException {
        Jogador.getInstance().getConexao().getPartida().getValor(valor);
        floresEscolhidas();
    }

    public void floresEscolhidas() throws IOException{ 
        // se ambos já escolheram a flor, mostra valor
        observadores.forEach((obs) -> {
            obs.FloresEscolhidas(Rodada.getInstance().getValorJogadorAmarelo(), Rodada.getInstance().getValorJogadorVermelho());
        });


    }

    public void verificaEmpate() throws IOException {
        if (Rodada.getInstance().getValorJogadorAmarelo() == Rodada.getInstance().getValorJogadorVermelho()) {
            //Devolve flores;
            observadores.forEach((obs) -> {
                obs.empate();
            });
            
        } else {
            defineJardineiros();
        }
    }

    public void defineJardineiros() throws IOException {
        String msg;
        if (Rodada.getInstance().getValorJogadorAmarelo() > Rodada.getInstance().getValorJogadorVermelho()) {
            Rodada.getInstance().setCorJardineiroJunior("Vermelho");
            Rodada.getInstance().setCorJardineiroSenior("Amarelo");
        } else {
            Rodada.getInstance().setCorJardineiroJunior("Amarelo");
            Rodada.getInstance().setCorJardineiroSenior("Vermelho");
        }
        if (Jogador.getInstance().getCor().equals(Rodada.getInstance().getCorJardineiroJunior())) {
            msg = "Você é o Jardineiro Junior";
        } else {
            msg = "Você é o Jardineiro Sênior";
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
