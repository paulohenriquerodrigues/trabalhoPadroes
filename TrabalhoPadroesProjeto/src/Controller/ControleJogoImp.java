/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Peca;
import Pecas.Agua;

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

    @Override
    public void inicializar() throws Exception {
        tabuleiro = new Peca[5][5];
        tabuleiro[0][0] = new Agua();
        tabuleiro[0][1] = new Agua();
        tabuleiro[0][2] = new Agua();
        tabuleiro[0][3] = new Agua();
        tabuleiro[0][4] = new Agua();

        tabuleiro[1][0] = new Agua();
        tabuleiro[1][1] = new Agua();
        tabuleiro[1][2] = new Agua();
        tabuleiro[1][3] = new Agua();
        tabuleiro[1][4] = new Agua();

        tabuleiro[2][0] = new Agua();
        tabuleiro[2][1] = new Agua();
        tabuleiro[2][2] = new Agua();
        tabuleiro[2][3] = new Agua();
        tabuleiro[2][4] = new Agua();

        tabuleiro[3][0] = new Agua();
        tabuleiro[3][1] = new Agua();
        tabuleiro[3][2] = new Agua();
        tabuleiro[3][3] = new Agua();
        tabuleiro[3][4] = new Agua();

        tabuleiro[4][0] = new Agua();
        tabuleiro[4][1] = new Agua();
        tabuleiro[4][2] = new Agua();
        tabuleiro[4][3] = new Agua();
        tabuleiro[4][4] = new Agua();

    }

    @Override
    public Icon getPeca(int col, int row) throws Exception {
        return (tabuleiro[col][row] == null ? null : tabuleiro[col][row].getImagem());
    }

    @Override
    public void pressTecla(int keyCode) throws Exception {

    }

    @Override
    public void run() throws Exception {

    }

    @Override
    public void setTipoHeroi(String tipoHeroi) throws Exception {

    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

}
