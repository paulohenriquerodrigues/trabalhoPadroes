/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Jogo;
import Model.Entrada;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author paulohenrique
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Jogo.getInstance().iniciarServer();
                
        System.out.println("Server em execução");
             
        Jogo.getInstance().setJ1(Jogo.getInstance().getServerSocket().accept());
        Jogo.getInstance().getJ1().start();
        System.out.println("j1 iniciou");
        
        Jogo.getInstance().setJ2(Jogo.getInstance().getServerSocket().accept());
        Jogo.getInstance().getJ2().start();
        System.out.println("j2 iniciou");

        while (Jogo.getInstance().getJ1().isAlive() && Jogo.getInstance().getJ2().isAlive()) {
            Jogo.getInstance().getJ1().sleep(1000);
            Jogo.getInstance().getJ2().sleep(1000);
        }

        Jogo.getInstance().getServerSocket().close();
        System.out.println("Server finished...");
        System.exit(0);

    }

}
