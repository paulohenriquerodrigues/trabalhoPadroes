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
public class MoverParaBaixo implements Command{
    
    private MovimentarPecaCommand movimento;

    public MoverParaBaixo(MovimentarPecaCommand movimento, int y) {
        this.movimento = movimento;
        this.movimento.setY(y);
    }
    
    @Override
    public void execute() {
        movimento.moverBaixo(movimento.getPeca(), movimento.getY());
    }
    
}
