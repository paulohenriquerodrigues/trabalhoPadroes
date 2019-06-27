/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Model.Jogo;
import Model.RespostaObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class DefinirJardineiros extends EstadoRodada {

    public DefinirJardineiros(Rodada r) throws IOException, InterruptedException {

        super(r);

        if (Jogo.getInstance().getJ1().getValor()
                > Jogo.getInstance().getJ2().getValor()) {
            //Senior
            Jogo.getInstance().getJ1().setTipoJardineiro(2);
            Jogo.getInstance().getJ1().enviarMensagem("Você é o Jardineiro Senior");
            Thread.sleep(500);

            //Junior
            Jogo.getInstance().getJ2().setTipoJardineiro(1);
            Jogo.getInstance().getJ2().enviarMensagem("Você é o Jardineiro Junior");

        } else {
            //Senior
            Jogo.getInstance().getJ2().setTipoJardineiro(2);
            Jogo.getInstance().getJ2().enviarMensagem("Você é o Jardineiro Senior");
            Thread.sleep(500);
            //Junior
            Jogo.getInstance().getJ1().setTipoJardineiro(1);
            Jogo.getInstance().getJ1().enviarMensagem("Você é o Jardineiro Junior");

        }
        
        r.setEstado(new JardineiroJunior(r));

    }

    @Override
    public void proxEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
