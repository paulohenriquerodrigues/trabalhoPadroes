/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import Model.Peca;
import java.io.Serializable;
import javax.swing.Icon;

/**
 *
 * @author paulohenrique
 */
public abstract class VitoriaRegiaSapoVermelho extends Peca implements Serializable{
    
    public VitoriaRegiaSapoVermelho(Icon imagem) {
        super(imagem);
    }
    
    
}
