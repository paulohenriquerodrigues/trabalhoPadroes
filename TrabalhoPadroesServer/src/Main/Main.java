/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Jogador;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author paulohenrique
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(56000);
        serverSocket.setReuseAddress(true);
        
        System.out.println("Server em execução");
        
        Jogador j1 = new Jogador(serverSocket.accept());
        j1.start();
        
        Jogador j2 = new Jogador(serverSocket.accept());
        j2.start();
        
        while (j1.isAlive()&& j2.isAlive()) {
            	Thread.sleep(100);
            }
        
        
    }
    
}
