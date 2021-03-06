/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Builder.Tabuleiro;
import Builder.TabuleiroJogo;
import Command.CommandInvoker;
import Command.MoverParaBaixo;
import Command.MoverParaCima;
import Command.MoverParaDireita;
import Command.MoverParaEsquerda;
import Command.MovimentarPecaCommand;
import Model.Jogador;
import Model.Peca;
import Model.Rodada;
import Pecas.FabricaPeca;
import Strategy.MovimentarPecaDetalhado;
import Strategy.MovimentarPecaNormal;
import Visitor.VerificarPontuacao;
import Visitor.Visitor;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

/**
 *
 * @author paulohenrique
 */
public class ControleJogoImp implements ControleJogo {

    private int x;
    private int y;
    private int coluna;
    private int linha;
    private int tecla;

    private Peca[][] tabuleiro;
    Tabuleiro tabuleiroBuilder = new TabuleiroJogo();

    private List<Observador> observadores = new ArrayList<>();

    private MovimentarPecaCommand movimento = new MovimentarPecaCommand();
    private CommandInvoker inv = new CommandInvoker();

    FabricaPeca fabricaPeca = new FabricaPeca();

    VerificarPontuacao verificaPontuacao = new VerificarPontuacao();

    @Override
    public Peca getPecaTabuleiro(int x, int y) {
        return tabuleiro[x][y];
    }

    @Override
    public void inicializar() throws Exception {

        tabuleiroBuilder.criarTabuleiro();
        tabuleiro = tabuleiroBuilder.retornaTabuleiroPeca();

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
        Peca peca = getPecaTabuleiro(coluna, linha);
        switch (tecla) {
            case 37:
                if (peca != null) {
                    movimento.setPeca(peca);
                    if (coluna > 0) {
                        inv.adicionar(new MoverParaEsquerda(movimento, coluna));
                        inv.execute(new MoverParaEsquerda(movimento, coluna));

                        if (tabuleiro[movimento.getX()][linha].getClass().toString().equals("class Pecas.PecaAgua")) {
                            tabuleiro = new MovimentarPecaNormal().movimentar(tabuleiro, "Esquerda", peca, movimento.getX(), linha);
                        } else {
                            tabuleiro = new MovimentarPecaDetalhado().movimentar(tabuleiro, "Esquerda", peca, movimento.getX(), linha);
                        }

                        accept(verificaPontuacao);

                        peca = null;
                        notificarMudancaTabuleiro();
                        zerarLinhaColuna();
                    }

                }
                break;
            case 38:
                if (peca != null) {
                    movimento.setPeca(peca);
                    if (linha > 0) {
                        inv.adicionar(new MoverParaCima(movimento, linha));
                        inv.execute(new MoverParaCima(movimento, linha));

                        if (tabuleiro[coluna][movimento.getY()].getClass().toString().equals("class Pecas.PecaAgua")) {
                            tabuleiro = new MovimentarPecaNormal().movimentar(tabuleiro, "Cima", peca, coluna, movimento.getY());
                        } else {
                            tabuleiro = new MovimentarPecaDetalhado().movimentar(tabuleiro, "Cima", peca, coluna, movimento.getY());
                        }

                        accept(verificaPontuacao);

                        peca = null;
                        notificarMudancaTabuleiro();
                        zerarLinhaColuna();
                    }

                }
                break;
            case 39:
                if (peca != null) {
                    movimento.setPeca(peca);
                    if (coluna < 4) {
                        inv.adicionar(new MoverParaDireita(movimento, coluna));
                        inv.execute(new MoverParaDireita(movimento, coluna));

                        if (tabuleiro[movimento.getX()][linha].getClass().toString().equals("class Pecas.PecaAgua")) {
                            tabuleiro = new MovimentarPecaNormal().movimentar(tabuleiro, "Direita", peca, movimento.getX(), linha);
                        } else {
                            tabuleiro = new MovimentarPecaDetalhado().movimentar(tabuleiro, "Direita", peca, movimento.getX(), linha);
                        }

                        accept(verificaPontuacao);

                        peca = null;
                        notificarMudancaTabuleiro();
                        zerarLinhaColuna();
                    }

                }
                break;
            case 40:
                if (peca != null) {
                    movimento.setPeca(peca);
                    if (linha < 4) {
                        inv.adicionar(new MoverParaBaixo(movimento, linha));
                        inv.execute(new MoverParaBaixo(movimento, linha));

                        if (tabuleiro[coluna][movimento.getY()].getClass().toString().equals("class Pecas.PecaAgua")) {
                            tabuleiro = new MovimentarPecaNormal().movimentar(tabuleiro, "Baixo", peca, coluna, movimento.getY());
                        } else {
                            tabuleiro = new MovimentarPecaDetalhado().movimentar(tabuleiro, "Baixo", peca, coluna, movimento.getY());
                        }

                        accept(verificaPontuacao);

                        peca = null;
                        notificarMudancaTabuleiro();
                        zerarLinhaColuna();
                    }
                }
                break;
        }
    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

    private void notificarMudancaTabuleiro() {

        observadores.forEach((obs) -> obs.mudouTabuleiro());

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void zerarLinhaColuna() {
        setY(0);
        setX(0);
    }

    @Override
    public void colunaLinhaSelecionada(int coluna, int linha) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void JardineiroJuniorEscura() {
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                if (tabuleiro[coluna][linha].getClass().toString().equals("class Pecas.PecaVitoriaRegiaEscura")) {
                    if (Rodada.getInstance().getCorJardineiroJunior().equals("Amarelo")) {
                        tabuleiro[coluna][linha] = new FabricaPeca().criarPecaVitoriaRegiaFlorAmarela();
                    } else {
                        tabuleiro[coluna][linha] = new FabricaPeca().criarPecaVitoriaRegiaFlorVermelha();

                    }
                }
            }
        }
        notificarMudancaTabuleiro();
    }

    public void jardineiroSeniorcolocaPeca(int coluna, int linha) {
        if (Rodada.getInstance().getCorJardineiroSenior().equals("Amarelo")) {
            tabuleiro[coluna][linha] = new FabricaPeca().criarPecaVitoriaRegiaFlorAmarela();
        } else {
            tabuleiro[coluna][linha] = new FabricaPeca().criarPecaVitoriaRegiaFlorVermelha();

        }
        notificarMudancaTabuleiro();
    }

    public void accept(Visitor visitor) throws Exception {
        String tipoPeca;
        if(Jogador.getInstance().getCor().equals("Amarelo")){
        tipoPeca = "class Pecas.PecaVitoriaRegiaFlorAmarelo";
        }else{
        tipoPeca = "class Pecas.PecaVitoriaRegiaFlorVermelho";
        }
        visitor.visit(tabuleiro, tipoPeca);

    }

    @Override
    public void removerSapos() {

        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (tabuleiro[l][c].getClass().toString().equals("class Pecas.PecaVitoriaRegiaSapoVermelho")) {
                    tabuleiro[l][c] = new FabricaPeca().criarPecaVitoriaRegiaFlorVermelha();
                }
                if (tabuleiro[l][c].getClass().toString().equals("class Pecas.PecaVitoriaRegiaSapoAmarelo")) {
                    tabuleiro[l][c] = new FabricaPeca().criarPecaVitoriaRegiaFlorAmarela();
                }

            }
        }

    }

    @Override
    public void enviarTabuleiro() {
        try {
            Jogador.getInstance().getConexao().enviarTabuleiro(tabuleiro);
        } catch (IOException ex) {
            Logger.getLogger(ControleJogoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControleJogoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
