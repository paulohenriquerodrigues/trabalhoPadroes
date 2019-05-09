/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.CommandInvoker;
import Command.MovimentarPecaCommand;
import Model.Peca;
import Pecas.FabricaPeca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author paulohenrique
 */
public class ControleJogoImp implements ControleJogo {

    private Peca[][] tabuleiro;
    private List<Observador> observadores = new ArrayList<>();
    private int tecla;
    private MovimentoPeca movimento;
    private CommandInvoker inv = new CommandInvoker();

    
    FabricaPeca fabricaPeca = new FabricaPeca();
    
    @Override
    public Peca getPecaTabuleiro(int x, int y){
    return tabuleiro[x][y];
    }

    @Override
    public void inicializar() throws Exception {
        tabuleiro = new Peca[5][5];
        tabuleiro[0][0] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[0][1] = new FabricaPeca().criarPecaAgua();
        tabuleiro[0][2] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[0][3] = new FabricaPeca().criarPecaAgua();
        tabuleiro[0][4] = new FabricaPeca().criarPecaVitoriaRegiaNormal();

        tabuleiro[1][0] = new FabricaPeca().criarPecaAgua();
        tabuleiro[1][1] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[1][2] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[1][3] = new FabricaPeca().criarPecaVitoriaRegiaSapoVermelho();
        tabuleiro[1][4] = new FabricaPeca().criarPecaAgua();

        tabuleiro[2][0] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[2][1] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[2][2] = new FabricaPeca().criarPecaAgua();
        tabuleiro[2][3] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[2][4] = new FabricaPeca().criarPecaVitoriaRegiaNormal();

        tabuleiro[3][0] = new FabricaPeca().criarPecaAgua();
        tabuleiro[3][1] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[3][2] = new FabricaPeca().criarPecaVitoriaRegiaSapoAmarelo();
        tabuleiro[3][3] = new FabricaPeca().criarPecaVitoriaRegiaEscura();
        tabuleiro[3][4] = new FabricaPeca().criarPecaAgua();

        tabuleiro[4][0] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[4][1] = new FabricaPeca().criarPecaAgua();
        tabuleiro[4][2] = new FabricaPeca().criarPecaVitoriaRegiaNormal();
        tabuleiro[4][3] = new FabricaPeca().criarPecaAgua();
        tabuleiro[4][4] = new FabricaPeca().criarPecaVitoriaRegiaNormal();

    }

    @Override
    public Icon getPeca(int col, int row) throws Exception {
        return (tabuleiro[col][row] == null ? null : tabuleiro[col][row].getImagem());
    }

    @Override
    public void pressTecla(int keyCode) throws Exception {
        this.tecla = keyCode;
    }

    @Override
    public void run() throws Exception {
         Thread t = new Thread() {

            @Override
            public void run() {
               
                try {
                    int x = 0;
                    int y = 1;

                    Peca pecaAnterior = null;

                    while (true) {
                        // lerInputs
                        inv.add(new MovimentarPecaCommand(movimento, pecaAnterior, x, y));
                        inv.execute();

                        switch (tecla) {
                            case 37:
                                movimentoHer.vaiParaEsquerda(tabuleiro[x - 1][y]);
                                break;
                            case 38:
                                movimentoHeroi.vaiParaCima(tabuleiro[x][y - 1]);
                                break;
                            case 39:
                                movimentoHeroi.vaiParaDireita(tabuleiro[x + 1][y]);
                                break;
                            case 40:
                                movimentoHeroi.vaiParaBaixo(tabuleiro[x][y + 1]);
                                break;
                        }
                        tecla = 0;

                        // mudar a posicao do heroi
                        if (movimentoHeroi.getX() != 0) {
                            Peca p = tabuleiro[x + movimentoHeroi.getX()][y];
                            tabuleiro[x + movimentoHeroi.getX()][y] = movimentoHeroi.getPeca();
                            tabuleiro[x][y] = pecaAnterior;
                            pecaAnterior = p;
                            x = x + movimentoHeroi.getX();
                        } else {
                            if (movimentoHeroi.getY() != 0) {
                                Peca p = tabuleiro[x][y + movimentoHeroi.getY()];
                                tabuleiro[x][y + movimentoHeroi.getY()] = movimentoHeroi.getPeca();
                                tabuleiro[x][y] = pecaAnterior;
                                pecaAnterior = p;
                                y = y + movimentoHeroi.getY();
                            }
                        }

                        notificarMudancaTabuleiro();

                        Thread.sleep(100); // soh para dar um tempinho
                    }
                } catch (Exception e) {

                    notificarFimJogo(e.toString());
                }
            }
        };
        t.start();

        notificarIniciouJogo();
    }

    @Override
    public void setTipoHeroi(String tipoHeroi) throws Exception {

    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

}
