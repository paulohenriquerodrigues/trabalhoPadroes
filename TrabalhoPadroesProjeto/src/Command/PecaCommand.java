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
public abstract class PecaCommand implements Command{
    
    protected MovimentoPeca movimento;
    protected Peca peca;
    protected int x;
    protected int y;

    public PecaCommand(MovimentoPeca movimento, Peca peca, int x, int y) {
        this.movimento = movimento;
        this.peca = peca;
        this.x = x;
        this.y = y;
    }

   
    
    
    
}
