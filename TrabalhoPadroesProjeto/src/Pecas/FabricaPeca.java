/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pecas;

import AbstractFactory.Agua;
import AbstractFactory.VitoriaRegiaEscura;
import AbstractFactory.VitoriaRegiaFlorAmarela;
import AbstractFactory.VitoriaRegiaFlorVermelha;
import AbstractFactory.VitoriaRegiaNormal;
import AbstractFactory.VitoriaRegiaSapoAmarelo;
import AbstractFactory.VitoriaRegiaSapoVermelho;

/**
 *
 * @author paulohenrique
 */
public class FabricaPeca extends AbstractFactory.FabricaPeca{

    @Override
    public Agua criarPecaAgua() {
        return new PecaAgua();
    }

    @Override
    public VitoriaRegiaNormal criarPecaVitoriaRegiaNormal() {
        return new PecaVitoriaRegiaNormal();
    }

    @Override
    public VitoriaRegiaEscura criarPecaVitoriaRegiaEscura() {
       return new PecaVitoriaRegiaEscura();
    }

    @Override
    public VitoriaRegiaSapoVermelho criarPecaVitoriaRegiaSapoVermelho() {
        return new PecaVitoriaRegiaSapoVermelho();
    }

    @Override
    public VitoriaRegiaSapoAmarelo criarPecaVitoriaRegiaSapoAmarelo() {
        return new PecaVitoriaRegiaSapoAmarelo();
    }

    @Override
    public VitoriaRegiaFlorAmarela criarPecaVitoriaRegiaFlorAmarela() {
        return new PecaVitoriaRegiaFlorAmarela();
    }

    @Override
    public VitoriaRegiaFlorVermelha criarPecaVitoriaRegiaFlorVermelha() {
        return new PecaVitoriaRegiaFlorVermelha();
    }
    
   


}
