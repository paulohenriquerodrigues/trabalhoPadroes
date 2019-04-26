/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControleJogo;
import Controller.ControleJogoImp;
import Controller.FlorController;
import Controller.Observador;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author paulohenrique
 */
public class Tabuleiro2 extends JFrame implements Observador{

  
    class TabuleiroTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 5;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controle.getPeca(col, row);
            } catch (Exception ex) {
                Logger.getLogger(Tabuleiro2.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
        }
        
    }
    
    
        class TabuleiroRenderer extends DefaultTableCellRenderer {
            protected JButton button;



        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            button = new JButton((ImageIcon) value);

            button.addActionListener((e) -> {
                                JOptionPane.showMessageDialog(null, "Teste");
                                
             

            });

                       
    return button;
                
        }

    }  
    
    
        private ControleJogo controle;
        private FlorController controleFlor;
        private JTable tabuleiro;
        
        public Tabuleiro2() throws Exception {
        this.controle = new ControleJogoImp();
        this.controle.inicializar();
        this.controle.addObservador(this);
        
        controleFlor = new FlorController();
        controleFlor.addFlores("Amarelo");
        
        setTitle("Haru Ichiban");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
        pack();
            
        }
        
        private void initComponents() {
            
        JPanel j = new JPanel();
        for(int i = 0; i < controleFlor.getFloresAmarelas().size(); i++){
            JButton b = new JButton();
        b.setIcon(controleFlor.getFlorAmarela(i).getImagem());
        b.setText(String.valueOf(controleFlor.getFlorAmarela(i).getValor()));
        j.add(b);
        add(j, SOUTH);
        }    

        // criar o tabuleiro e seus componentes
        tabuleiro = new JTable();
        tabuleiro.setModel(new TabuleiroTableModel());
        for (int x = 0; x < tabuleiro.getColumnModel().getColumnCount(); x++) {
            tabuleiro.getColumnModel().getColumn(x).setWidth(100);
            tabuleiro.getColumnModel().getColumn(x).setMinWidth(100);
            tabuleiro.getColumnModel().getColumn(x).setMaxWidth(100);
        }
        tabuleiro.setRowHeight(100);
        tabuleiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabuleiro.setShowGrid(false);
        tabuleiro.setIntercellSpacing(new Dimension(1, 1));
        tabuleiro.setDefaultRenderer(Object.class, new TabuleiroRenderer());
        
        

        

        add(tabuleiro, CENTER);

        
        

        
    }
        
        
    @Override
    public void mudouTabuleiro() {
        tabuleiro.repaint();
    }

    @Override
    public void iniciouJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fimDeJogo(String msgErro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

        
       public static void main(String[] args) throws Exception {
        Tabuleiro2 t = new Tabuleiro2();
        t.setVisible(true);
    }
 
        
         
       
    
        
}
