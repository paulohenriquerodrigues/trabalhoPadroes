/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Model.Jogo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class EscolhaFlores extends EstadoRodada {

    public EscolhaFlores(Rodada r) throws IOException {
        super(r);
        try {
            Jogo.getInstance().getJ1().enviarMensagem("Escolha a Flor - 2 Cliques");
            Thread.sleep(1000);
            Jogo.getInstance().getJ2().enviarMensagem("Escolha a Flor - 2 Cliques");
            
                        
            if(Jogo.getInstance().getJ1().getValor() == Jogo.getInstance().getJ2().getValor()){
            r.setEstado(new Coachar(r));
            }else{
                System.out.println("entrou aqui");
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void proxEstado() {
        
    }
   
}
