/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Model.Jogo;
import java.io.IOException;

/**
 *
 * @author paulohenrique
 */
public class Coachar extends EstadoRodada {

    public Coachar(Rodada r) throws IOException {
        super(r);
        System.out.println("Coachar"); 
    }

    @Override
    public void proxEstado() {
        
    }
   
}
