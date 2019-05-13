/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.CommandInvoker;
import Command.MoverParaCima;
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
    
    private int x;
    private int y;
    private Peca[][] tabuleiro;
    private List<Observador> observadores = new ArrayList<>();
    private int tecla;
    private MovimentarPecaCommand movimento = new MovimentarPecaCommand();
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
    public void pressTecla(int keyCode,int x, int y) throws Exception {
        this.tecla = keyCode;
        Peca peca = getPecaTabuleiro(x, y);
        switch (tecla) {
                            case 37:
                                
                                break;
                            case 38:
                              if(peca != null){  
                               movimento.setPeca(peca);
                               inv.adicionar(new MoverParaCima(movimento, y));
                               System.out.println("entrou");
                               inv.execute(new MoverParaCima(movimento, y));
                               Peca p = tabuleiro[x][y + movimento.getY()];
                               tabuleiro[x][movimento.getY()] = movimento.getPeca();
                               
                               tabuleiro [x][y] = fabricaPeca.criarPecaAgua();
                               peca = null;
                               notificarMudancaTabuleiro();
                               
                              }
                                break;
                            case 39:
                                
                                break;
                            case 40:
                                
                                break;
                        }
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
                       movimento.zerarDeslocamento();

                        switch (tecla) {
                            case 37:
                                
                                break;
                            case 38:
//                               movimento.setPeca(getPecaTabuleiro(x, y));
//                               inv.add(new MoverParaCima(movimento));
                                System.out.println("entrou");
//                               inv.execute();
                                break;
                            case 39:
                                
                                break;
                            case 40:
                                
                                break;
                        }
                        tecla = 0;

                        
                        notificarMudancaTabuleiro();
                        Thread.sleep(100); // soh para dar um tempinho
                    }
                } catch (Exception e) {

                }
            }
        };
        t.start();
        

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

    @Override
    public void setTipoHeroi(String tipoHeroi) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
  

}
