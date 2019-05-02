/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author paulohenrique
 */
public abstract class FabricaPeca {
    
    public abstract Agua criarPecaAgua();
    public abstract VitoriaRegiaNormal criarPecaVitoriaRegiaNormal();
    public abstract VitoriaRegiaEscura criarPecaVitoriaRegiaEscura();
    public abstract VitoriaRegiaSapoVermelho criarPecaVitoriaRegiaSapoVermelho();
    public abstract VitoriaRegiaSapoAmarelo criarPecaVitoriaRegiaSapoAmarelo();
    
    
    
}
