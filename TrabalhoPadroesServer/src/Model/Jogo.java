/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author paulohenrique
 */
public class Jogo {

    private static Jogo jogo;

    public static Jogo getInstance() {
        if (jogo == null) {
            jogo = new Jogo();
        }
        return jogo;
    
    }
    
     Jogador j1;
     Jogador j2;

    public static Jogo getJogo() {
        return jogo;
    }

    public static void setJogo(Jogo jogo) {
        Jogo.jogo = jogo;
    }

    public Jogador getJ1() {
        return j1;
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public Jogador getJ2() {
        return j2;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

}
