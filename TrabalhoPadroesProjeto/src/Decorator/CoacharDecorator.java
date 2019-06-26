/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author paulohenrique
 */
public abstract class CoacharDecorator implements Coachar{
    
    private Coachar coachar;

    public CoacharDecorator(Coachar coachar) {
        this.coachar = coachar;
    }
    
    @Override
	public void chamaJFrameCoachar() {

	}
}
