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
public class MoverParaDireita implements Command{
    
    private MovimentarPecaCommand movimento;

    public MoverParaDireita(MovimentarPecaCommand movimento, int x) {
        this.movimento = movimento;
        this.movimento.setX(x);
    }
    
    @Override
    public void execute() {
        movimento.moverDireita(movimento.getPeca(), movimento.getX());
    }
    
}
