/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Model.Jogo;
import Model.RespostaObserver;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class EscolhaFlores extends EstadoRodada implements RespostaObserver{

    public EscolhaFlores(Rodada r) throws IOException {
        super(r);
        try {
            Jogo.getInstance().addObserver(this);
            
            Jogo.getInstance().getJ1().enviarMensagem("Escolha a Flor - 2 Cliques");
            Thread.sleep(1000);
            Jogo.getInstance().getJ2().enviarMensagem("Escolha a Flor - 2 Cliques");

        } catch (InterruptedException ex) {
            Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void proxEstado() {
       
    }

    @Override
    public void Resposta(int i) {
        if(i == 0){ 
            try {
                Jogo.getInstance().removerObserver(this);
                this.rodada.setEstado(new Coachar(rodada));
            } catch (IOException ex) {
                Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                this.rodada.setEstado(new DefinirJardineiros(rodada));
            } catch (IOException ex) {
                Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(EscolhaFlores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void coachou() {
       
    }

}
