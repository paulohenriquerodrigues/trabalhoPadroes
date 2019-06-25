/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author paulohenrique
 */
public abstract class EstadoRodada {
    
    protected Rodada rodada;
    
    public  EstadoRodada(Rodada r){
    this.rodada = r;
    }
    
    public abstract void proxEstado();
    
}
