/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class PartidaReal implements Partida {

    public PartidaReal() {

    }

    @Override
    public void Setcor(String cor) {
        if(Jogo.getInstance().j2 == null){
        Jogo.getInstance().j1.setCor(cor);
        }else{
        Jogo.getInstance().j2.setCor(cor);
        }

    }

    @Override
    public String getCor() {
        String cor = null;
        if(Jogo.getInstance().j2 == null){
           cor = null;
        } else if(Jogo.getInstance().j1.isAlive() && Jogo.getInstance().j2.isAlive()){
            if (Jogo.getInstance().j1.getCor().equals("Amarelo")) {
                cor = "Amarelo";
            } else if (Jogo.getInstance().j1.getCor().equals("Vermelho")) {
                cor = "Vermelho";
            } else {
                cor = null;
            }
        }
        return cor;
    }

    @Override
    public String enviarMensagem(String mensagem) {
        return mensagem;
        
    }

    @Override
    public String getMensagem() {
        return null;
       
    }

    @Override
    public void getValor(int valor) {
        System.out.println(valor);
    }    
   
}
