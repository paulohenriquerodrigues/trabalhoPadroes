/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.Peca;
import Pecas.FabricaPeca;

/**
 *
 * @author paulohenrique
 */
public class MovimentarPecaNormal implements MovimentarPeca {
    FabricaPeca fabricaPeca = new FabricaPeca();

    @Override
    public Peca[][] movimentar(Peca[][] tabuleiro, String movimento, Peca peca, int x, int y) {
        switch (movimento){
            case "Cima":
                tabuleiro[x][y] = peca;
                tabuleiro[x][y+1] = fabricaPeca.criarPecaAgua();
                    break;
            case "Baixo":
                tabuleiro[x][y] = peca;
                tabuleiro[x][y-1] = fabricaPeca.criarPecaAgua();
                    break;
            case "Esquerda":
                tabuleiro[x][y] = peca;
                tabuleiro[x+1][y] = fabricaPeca.criarPecaAgua();
                    break;
            case "Direita":
                tabuleiro[x][y] = peca;
                tabuleiro[x-1][y] = fabricaPeca.criarPecaAgua();
                    break;        
        }       
        return tabuleiro;
        }
    }
    

