/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.io.IOException;

/**
 *
 * @author paulohenrique
 */
public class Rodada {

    private EstadoRodada estado;

    public Rodada() throws IOException {
        this.estado = new EscolhaFlores(this);
    }

    public void setEstado(EstadoRodada estado) {
        this.estado = estado;
    }
    

    public void proximoEstado() {
        this.estado.proxEstado();
    }

}
