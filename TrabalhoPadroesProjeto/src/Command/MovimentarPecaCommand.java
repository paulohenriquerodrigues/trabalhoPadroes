/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Model.Peca;

/**
 *
 * @author paulohenrique
 */
public class MovimentarPecaCommand {
    //coluna
    private int x;
    
    //linha 
    private int y;
    
    private Peca peca;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    

    public void moverCima(Peca peca, int y){
        setY(y--);
        System.out.println(getY());
    }
    
    public void zerarDeslocamento() {
        setX(0);
        setY(0);
    }
   
}
