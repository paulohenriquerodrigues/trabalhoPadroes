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
public class MovimentarPecaDetalhado implements MovimentarPeca {
    //esta classe serve para empurar as peças ao mover

    FabricaPeca fabricaPeca = new FabricaPeca();

    @Override
    public Peca[][] movimentar(Peca[][] tabuleiro, String movimento, Peca peca, int x, int y) {
        boolean fim = true;
        int limite = 0;
        switch (movimento) {
            case "Cima":
                //valida final
                for (int i = y - 1; i >= 0; i--) {
                    if (tabuleiro[x][i].getClass().toString().equals("class Pecas.PecaAgua")) {
                        fim = false;
                        limite = i;
                    }
                }

                if (fim == false) {
                    for (int i = limite; i < y; i++) {
                        if (tabuleiro[x][i].getClass().toString().equals("class Pecas.PecaAgua") == false) {
                            tabuleiro[x][i] = tabuleiro[x][i + 1];
                        } else {
                            tabuleiro[x][i] = tabuleiro[x][i + 1];

                        }
                    }
                    tabuleiro[x][y] = peca;
                    tabuleiro[x][y + 1] = fabricaPeca.criarPecaAgua();
                }
                break;
            case "Baixo":
                //valida final
                for (int i = y + 1; i <= 4; i++) {
                    if (tabuleiro[x][i].getClass().toString().equals("class Pecas.PecaAgua")) {
                        limite = i;
                        fim = false;
                    }
                }

                if (fim == false) {
                    for (int i = limite; i > y; i--) {
                        if (tabuleiro[x][i].getClass().toString().equals("class Pecas.PecaAgua") == false) {
                            tabuleiro[x][i] = tabuleiro[x][i - 1];
                        } else {
                            tabuleiro[x][i] = tabuleiro[x][i - 1];

                        }
                    }

                    tabuleiro[x][y] = peca;
                    tabuleiro[x][y - 1] = fabricaPeca.criarPecaAgua();
                }
                break;
            case "Esquerda":
                //valida final
                for (int i = x - 1; i >= 0; i--) {
                    if (tabuleiro[i][y].getClass().toString().equals("class Pecas.PecaAgua")) {
                        fim = false;
                        limite = i;
                    }
                }

                if (fim == false) {
                    for (int i = limite; i < x; i++) {
                        if (tabuleiro[i][y].getClass().toString().equals("class Pecas.PecaAgua") == false) {
                            tabuleiro[i][y] = tabuleiro[i + 1][y];
                        } else {
                            tabuleiro[i][y] = tabuleiro[i + 1][y];

                        }
                    }

                    tabuleiro[x][y] = peca;
                    tabuleiro[x + 1][y] = fabricaPeca.criarPecaAgua();
                }
                break;
            case "Direita":
                //valida final
                for (int i = x + 1; i <= 4; i++) {
                    if (tabuleiro[i][y].getClass().toString().equals("class Pecas.PecaAgua")) {
                        limite = i;
                        fim = false;
                    }
                }

                if (fim == false) {
                    for (int i = limite; i > x; i--) {
                        if (tabuleiro[i][y].getClass().toString().equals("class Pecas.PecaAgua") == false) {
                            tabuleiro[i][y] = tabuleiro[i - 1][y];
                        } else {
                            tabuleiro[i][y] = tabuleiro[i - 1][y];

                        }
                    }
                    tabuleiro[x][y] = peca;
                    tabuleiro[x - 1][y] = fabricaPeca.criarPecaAgua();
                }

                break;
        }
        return tabuleiro;
    }
}
