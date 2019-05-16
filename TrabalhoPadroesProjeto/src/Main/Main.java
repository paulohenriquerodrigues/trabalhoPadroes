/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Jogador;
import Server.Server;
import view.ConfigJogadorView;

/**
 *
 * @author paulohenrique
 */
public class Main {
    public static void main(String[] args) {
        Jogador.getInstance().setCor(null);
        ConfigJogadorView tela = new ConfigJogadorView();
        tela.setVisible(true);
        Server server = new Server();
        server.execute();
        
        
        
    }
    
}
