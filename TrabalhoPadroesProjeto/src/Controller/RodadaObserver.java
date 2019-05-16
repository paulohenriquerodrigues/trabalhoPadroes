/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author paulohenrique
 */
public interface RodadaObserver {
    
    public void FloresEscolhidas(int valorJogadorAmarelo, int valorJogadorVermelho);
    public void FloresNãoEscolhidas(int valor);
    public void empate();
    public void msgTipoJardineiro(String msg);
    public void jardineiroJuniorEscura();
    public void jardineiroSeniorcolocaPeca();
    

    
}
