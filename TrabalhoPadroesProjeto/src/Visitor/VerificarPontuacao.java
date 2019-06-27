/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class VerificarPontuacao implements Visitor {

    private int pontuacao;

    @Override
    public void visit(Peca[][] tabuleiro, String Cor) {
        pontuacao = pontuacao + validaLinhasHorizontal4(tabuleiro, Cor);
        pontuacao = pontuacao + validaLinhasVertical4(tabuleiro, Cor);

        pontuacao = pontuacao + validaLinhasHorizontal5(tabuleiro, Cor);
        pontuacao = pontuacao + validaLinhasVertical5(tabuleiro, Cor);

        pontuacao = pontuacao + validaDiagonal4(tabuleiro, Cor);
        pontuacao = pontuacao + validaDiagonal5(tabuleiro, Cor);

    }

    public int validaLinhasHorizontal4(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (tabuleiro[l][c].getClass().toString().equals(cor)) {
                    qtdeEncontrada++;
                } else {
                    qtdeEncontrada = 0;
                }
                if (qtdeEncontrada == 4) {
                    qtde++;
                }

            }
        }
        return qtde * 2;
    }

    public int validaLinhasVertical4(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (tabuleiro[c][l].getClass().toString().equals(cor)) {
                    qtdeEncontrada++;
                } else {
                    qtdeEncontrada = 0;
                }
                if (qtdeEncontrada == 4) {
                    qtde++;
                }

            }
        }
        return qtde * 2;
    }

    public int validaLinhasHorizontal5(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (tabuleiro[l][c].getClass().toString().equals(cor)) {
                    qtdeEncontrada++;
                } else {
                    qtdeEncontrada = 0;
                }
                if (qtdeEncontrada == 5) {
                    qtde++;
                }

            }
        }
        return qtde * 5;
    }

    public int validaLinhasVertical5(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                if (tabuleiro[c][l].getClass().toString().equals(cor)) {
                    qtdeEncontrada++;
                } else {
                    qtdeEncontrada = 0;
                }
                if (qtdeEncontrada == 5) {
                    qtde++;
                }

            }
        }
        return qtde * 5;
    }

    public int validaDiagonal4(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 4; l >= 0; l--) {
            if (tabuleiro[l][l].getClass().toString().equals(cor)) {
                qtdeEncontrada++;
            } else {
                qtdeEncontrada = 0;
            }
            if (qtdeEncontrada == 4) {
                qtde++;
            }
        }

        qtdeEncontrada = 0;

        for (int l = 0; l < 5; l++) {
            if (tabuleiro[l][l].getClass().toString().equals(cor)) {
                qtdeEncontrada++;
            } else {
                qtdeEncontrada = 0;
            }
            if (qtdeEncontrada == 4) {
                qtde++;
            }
        }

        return qtde * 3;
    }

    public int validaDiagonal5(Peca[][] tabuleiro, String cor) {
        int qtde = 0;
        int qtdeEncontrada = 0;
        for (int l = 4; l >= 0; l--) {
            if (tabuleiro[l][l].getClass().toString().equals(cor)) {
                qtdeEncontrada++;
            } else {
                qtdeEncontrada = 0;
            }
            if (qtdeEncontrada == 5) {
                qtde++;
            }
        }
        qtdeEncontrada = 0;

        for (int l = 0; l < 5; l++) {
            if (tabuleiro[l][l].getClass().toString().equals(cor)) {
                qtdeEncontrada++;
            } else {
                qtdeEncontrada = 0;
            }
            if (qtdeEncontrada == 5) {
                qtde++;
            }
        }
        return qtde * 5;
    }

}
