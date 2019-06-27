/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Model.Jogo;
import Model.RespostaObserver;
import java.io.IOException;

/**
 *
 * @author paulohenrique
 */
public class RemoverSapos extends EstadoRodada{

    public RemoverSapos(Rodada r) throws IOException, InterruptedException {
        super(r);
        Thread.sleep(5000);
        
        Jogo.getInstance().getJ1().removerSapos();
        Thread.sleep(500);
        Jogo.getInstance().getJ2().removerSapos();
        
        r.setEstado(new ColocarSaposCoachar(r));
        
    }

    @Override
    public void proxEstado() {
        

    }

}
