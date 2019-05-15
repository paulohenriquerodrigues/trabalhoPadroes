/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogador;
import Model.Rodada;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class RodadaController {

    private Rodada rodada;
    private List<RodadaObserver> observadores = new ArrayList<>();

    public RodadaController() {
        rodada = new Rodada();
        rodada.setValorJogadorAmarelo(0);
        rodada.setValorJogadorVermelho(0);

    }

    public void addObservador(RodadaObserver obs) {
        observadores.add(obs);
    }

    public void escolherflor(int valor) {
        if (Jogador.getInstance().getCor().equals("Amarelo")) {
            rodada.setValorJogadorAmarelo(valor);
        } else if (Jogador.getInstance().getCor().equals("Veremelho")) {
            rodada.setValorJogadorVermelho(valor);
        }
        floresEscolhidas();
    }

    public void floresEscolhidas() {
        if (rodada.getValorJogadorAmarelo() > 0 && rodada.getValorJogadorVermelho() > 0) {
            observadores.forEach((obs) -> {
                obs.FloresEscolhidas(rodada.getValorJogadorAmarelo(), rodada.getValorJogadorVermelho());
            });
        } else {
            observadores.forEach((obs) -> {
                if (Jogador.getInstance().getCor().equals("Amarelo")) {
                    obs.FloresNãoEscolhidas(rodada.getValorJogadorAmarelo());
                } else if (Jogador.getInstance().getCor().equals("Veremelho")) {
                    obs.FloresNãoEscolhidas(rodada.getValorJogadorVermelho());
                }
            });
        }

    }

}
