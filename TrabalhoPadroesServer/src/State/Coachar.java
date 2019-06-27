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
public class Coachar extends EstadoRodada implements RespostaObserver{
    

    public Coachar(Rodada r) throws IOException, InterruptedException {
        
        
        super(r);
        Jogo.getInstance().addObserver(this);
        
        Jogo.getInstance().getJ1().coachar();
        Thread.sleep(1000);
        Jogo.getInstance().getJ2().coachar();
        
        
    }

    @Override
    public void proxEstado() {

    }

    @Override
    public void Resposta(int i) {
        
    }

    @Override
    public void coachou() {
        try {
            this.rodada.setEstado(new RemoverSapos(rodada));
            
        } catch (IOException ex) {
            Logger.getLogger(Coachar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Coachar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}
