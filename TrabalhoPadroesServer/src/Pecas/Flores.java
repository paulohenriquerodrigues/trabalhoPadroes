/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pecas;

import Model.Peca;
import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author paulohenrique
 */
public class Flores extends Peca implements Serializable {

    private static final long serialVersionUID = 7526472295622776145L;

    String cor;
    int Valor;

    public Flores(String cor, int Valor, Icon imagem) {
        super(imagem);
        this.cor = cor;
        this.Valor = Valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

}
