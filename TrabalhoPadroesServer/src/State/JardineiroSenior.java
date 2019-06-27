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
public class JardineiroSenior extends EstadoRodada {

    public JardineiroSenior(Rodada r) throws IOException, InterruptedException {

        super(r);

        
        
        r.setEstado(new VentoPrimavera(r));

    }

    @Override
    public void proxEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
