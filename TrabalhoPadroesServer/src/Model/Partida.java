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
public interface Partida {

    void Setcor(String cor);
    String getCor();
    String enviarMensagem(String mensagem);
    String getMensagem();
    void getValor(int valor);

}
