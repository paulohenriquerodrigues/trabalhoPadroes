/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.net.Socket;

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
     Jogador2 j2;

    public static Jogo getJogo() {
        return jogo;
    }

    public static void setJogo(Jogo jogo) {
        Jogo.jogo = jogo;
    }

    public Jogador getJ1() {
        return j1;
    }

    public void setJ1(Socket s) throws IOException {
        this.j1 = new Jogador(s);
    }

    public Jogador2 getJ2() {
        return j2;
    }

    public void setJ2(Socket s) throws IOException {
        this.j2  = new Jogador2(s);
    }

}
