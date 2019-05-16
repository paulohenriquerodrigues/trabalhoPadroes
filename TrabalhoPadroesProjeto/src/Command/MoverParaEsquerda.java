/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author paulohenrique
 */
public class MoverParaEsquerda implements Command{
    
    private MovimentarPecaCommand movimento;

    public MoverParaEsquerda(MovimentarPecaCommand movimento, int x) {
        this.movimento = movimento;
        this.movimento.setX(x);
    }
    
    @Override
    public void execute() {
        movimento.moverEsquerda(movimento.getPeca(), movimento.getX());
    }
    
}
