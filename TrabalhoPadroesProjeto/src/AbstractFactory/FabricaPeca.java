/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import java.io.Serializable;

/**
 *
 * @author paulohenrique
 */
public abstract class FabricaPeca implements Serializable{
    
    public abstract Agua criarPecaAgua();
    public abstract VitoriaRegiaNormal criarPecaVitoriaRegiaNormal();
    public abstract VitoriaRegiaEscura criarPecaVitoriaRegiaEscura();
    public abstract VitoriaRegiaSapoVermelho criarPecaVitoriaRegiaSapoVermelho();
    public abstract VitoriaRegiaSapoAmarelo criarPecaVitoriaRegiaSapoAmarelo();
    public abstract VitoriaRegiaFlorAmarela criarPecaVitoriaRegiaFlorAmarela();
    public abstract VitoriaRegiaFlorVermelha criarPecaVitoriaRegiaFlorVermelha();
    
    
    
}
