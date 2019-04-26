/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogador;
import Model.Mensagem;
import Model.MensagemTipo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ConfigJogador;

/**
 *
 * @author paulohenrique
 */
public class Teste {
    public void verificaCor(){
        String cor = "Amarelo";
        try {
            
            Socket socket = new Socket(Jogador.getInstance().getIpOutroJogador(), 56000);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Mensagem msg = new Mensagem(MensagemTipo.verificaCor, null);
            output.writeObject(msg);
            output.flush();

            Object obj;
                obj = input.readObject();
                Mensagem msgRetorno = (Mensagem) obj;
            
            
            //cor = msg.getMessage().toString();

            output.close();
            input.close();
            socket.close();
        } catch (SocketTimeoutException ex) {
            System.out.println("tempo");
        } catch (SocketException ex) {            
            System.out.println("teste");
        }
        catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
