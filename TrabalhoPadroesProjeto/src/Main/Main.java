/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Server.Server;
import view.ConfigJogador;

/**
 *
 * @author paulohenrique
 */
public class Main {
    public static void main(String[] args) {
        ConfigJogador tela = new ConfigJogador();
        tela.setVisible(true);
        Server server = new Server();
        server.execute();
        
        
        
    }
    
}
