/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Controller.MovimentoPeca;
import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class MovimentarPecaCommand extends PecaCommand {

    public MovimentarPecaCommand(MovimentoPeca movimento, Peca peca, int x, int y) {
        super(movimento, peca, x, y);
    }

    @Override
    public void execute() {
        movimento.vaiParaCima(peca);
    }

    @Override
    public void undo() {
        
    }
    
    
}
