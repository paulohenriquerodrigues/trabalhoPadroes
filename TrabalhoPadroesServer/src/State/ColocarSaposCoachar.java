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
public class ColocarSaposCoachar extends EstadoRodada {

    public ColocarSaposCoachar(Rodada r) throws IOException, InterruptedException {
        super(r);
        
        if (Jogo.getInstance().getJ1().isCoachou() == true) {
            Jogo.getInstance().getJ1().enviarMensagem("Coloque os Sapos no Jogo - 1 Amarelo - 2- Vermelho");
            Thread.sleep(1000);
            Jogo.getInstance().getJ2().enviarMensagem("Outro Jogador irá colocar os sapos");

        } else {
            Jogo.getInstance().getJ2().enviarMensagem("Coloque os Sapos no Jogo - 1 Amarelo - 2- Vermelho");
            Thread.sleep(1000);
            Jogo.getInstance().getJ1().enviarMensagem("Outro Jogador irá colocar os sapos");


        }

    }

    @Override
    public void proxEstado() {

    }

}
