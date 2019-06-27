/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import Model.Jogador;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author paulohenrique
 */
public class ViewCoachar extends JFrame {

    public ViewCoachar(Color c) {
        this.setSize(300, 300);
        JButton coachar = new JButton();
        coachar.setText("Coachar");
        coachar.setBackground(c);
        
       

        coachar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Jogador.getInstance().getConexao().getPartida().coachar();
                dispose();
            }
        });
        
        this.add(coachar);
        this.repaint();
        this.setLocationRelativeTo(null);

    }
    
        

}
