/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ControleJogo;
import Controller.ControleJogoImp;
import Controller.FlorController;
import Controller.FlorObserver;
import Controller.JogadorController;
import Controller.Observador;
import Controller.PontuacaoController;
import Controller.PontuacaoObserver;
import Controller.RodadaController;
import Controller.RodadaObserver;
import Decorator.Coachar;
import Decorator.CoacharBase;
import Decorator.CoacharFrame;
import Model.ConexaoObserver;
import Model.Jogador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class TabuleiroView extends JFrame implements Observador, PontuacaoObserver, FlorObserver, RodadaObserver, ConexaoObserver {

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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }

    class PontuacaoTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 11;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return pontuacaoControle.getPontuacao(row, col);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }

    class TabuleiroRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            setIcon((ImageIcon) value);

            return this;
        }

    }

    class PontuacaoRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            setText(pontuacoes.getValueAt(row, column).toString());
            setBackground(Color.GREEN);

            return this;
        }

    }

    private ControleJogo controle;
    private PontuacaoController pontuacaoControle;
    private JogadorController jogador;
    private FlorController controleFlor;
    private RodadaController rodadaControle;

    private JTable tabuleiro;
    private JTable pontuacoes;

    private JPanel jPanelFlores;
    private JLabel valorFlorVermelha;
    private JLabel valorFlorAmarela;
    private JLabel mensagens;

    private int florSelecionada;
    private int linha;
    private int coluna;

    public TabuleiroView() throws Exception {
        Jogador.getInstance().getConexao().addObserver(this);
        this.controle = new ControleJogoImp();
        this.controle.inicializar();

        this.controle.addObservador(this);

        this.jogador = new JogadorController();

        pontuacaoControle = new PontuacaoController();
        pontuacaoControle.criarPontuacao();
        pontuacaoControle.addObservador(this);

        this.controleFlor = new FlorController();
        this.controleFlor.addObservador(this);
        this.controleFlor.addFlores(this.jogador.getCor());

        initComponents();
        this.controleFlor.carregaBotaoFlores();

        pontuacaoControle.modificarPontuacao("Amarelo", 0, 0);
        pontuacaoControle.modificarPontuacao("Vermelho", 0, 0);

        this.rodadaControle = new RodadaController();
        rodadaControle.addObservador(this);

        setTitle("Haru Ichiban");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();

    }

    private void initComponents() {

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JPanel pontuacao = new JPanel();

        pontuacoes = new JTable();
        pontuacoes.setModel(new PontuacaoTableModel());
        for (int x = 0; x < pontuacoes.getColumnModel().getColumnCount(); x++) {
            pontuacoes.getColumnModel().getColumn(x).setWidth(50);
            pontuacoes.getColumnModel().getColumn(x).setMinWidth(50);
            pontuacoes.getColumnModel().getColumn(x).setMaxWidth(50);
        }
        pontuacoes.setRowHeight(50);
        pontuacoes.setShowGrid(false);
        pontuacoes.setIntercellSpacing(new Dimension(1, 1));
        pontuacoes.setDefaultRenderer(Object.class, new PontuacaoRenderer());

        pontuacao.add(pontuacoes);

        // criar o tabuleiro e seus componentes
        JPanel JPanelTabuleiro = new JPanel();

        JLabel jardineiroVermelho = new JLabel();
        jardineiroVermelho.setIcon(new ImageIcon("imagens/chines-vermelho.png"));
        JLabel florVermelha = new JLabel();
        florVermelha.setIcon(new ImageIcon("imagens/rosa-vermelha.png"));
        valorFlorVermelha = new JLabel();

        JLabel jardineiroAmarelo = new JLabel();
        jardineiroAmarelo.setIcon(new ImageIcon("imagens/chines-amarelo.png"));
        JLabel florAmarela = new JLabel();
        florAmarela.setIcon(new ImageIcon("imagens/rosa-amarela.png"));
        valorFlorAmarela = new JLabel();

        mensagens = new JLabel();
        mensagens.setText("Aguardando outro jogador");

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

        tabuleiro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    linha = tabuleiro.getSelectedRow();
                    coluna = tabuleiro.getSelectedColumn();
                    try {
                        System.out.println(controle.getPecaTabuleiro(coluna, linha).getClass());
                        controle.colunaLinhaSelecionada(coluna, linha);

                    } catch (Exception ex) {
                        Logger.getLogger(TabuleiroView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        tabuleiro.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {

                    controle.pressTecla(e.getKeyCode());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.toString());
                }
            }
        });

        JPanelTabuleiro.add(florVermelha);
        JPanelTabuleiro.add(valorFlorVermelha);
        JPanelTabuleiro.add(jardineiroVermelho);

        JPanelTabuleiro.add(tabuleiro);

        JPanelTabuleiro.add(jardineiroAmarelo);
        JPanelTabuleiro.add(florAmarela);
        JPanelTabuleiro.add(valorFlorAmarela);
        JPanelTabuleiro.add("\n", mensagens);

        jPanelFlores = new JPanel();
        jPanelFlores.setBackground(Color.BLUE);

        painel.add(pontuacao, BorderLayout.NORTH);
        painel.add(JPanelTabuleiro);

        painel.add(jPanelFlores, BorderLayout.SOUTH);
        add(painel);

    }

    @Override
    public void modificarPontuacao(String corJogador, int pontos, int posicao) {

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

    @Override
    public void criarPontuacao() {

    }

    @Override
    public void addFlores(int i, int index) {

        JButton b = new JButton();
        b.setIcon(controleFlor.getFlor(index).getImagem());
        b.setText(String.valueOf(controleFlor.getFlor(index).getValor()));

        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        florSelecionada = Integer.parseInt(b.getText());
                        rodadaControle.escolherflor(florSelecionada);
                        controleFlor.usarFlor(florSelecionada);
                    } catch (IOException ex) {
                        Logger.getLogger(TabuleiroView.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TabuleiroView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

        jPanelFlores.add(b);

    }

    public void removerFloresJPanel() {
        jPanelFlores.removeAll();
        jPanelFlores.repaint();
        controleFlor.carregaBotaoFlores();
        jPanelFlores.revalidate();
        ;
    }

    @Override
    public void FloresEscolhidas(int valorJogadorAmarelo, int valorJogadorVermelho) {
        valorFlorVermelha.setText(String.valueOf(valorJogadorVermelho));
        valorFlorAmarela.setText(String.valueOf(valorJogadorAmarelo));
    }

    @Override
    public void FloresNãoEscolhidas(int valor) {
        if (jogador.getCor().equalsIgnoreCase("Amarelo")) {
            valorFlorAmarela.setText(String.valueOf(valor));
        } else if (jogador.getCor().equalsIgnoreCase("Vermelho")) {
            valorFlorVermelha.setText(String.valueOf(valor));

        }
    }

    @Override
    public void empate() {
        JOptionPane.showMessageDialog(null, "Empate entre as flores selecionadas");
        florSelecionada = -1;
        valorFlorAmarela.setText("");
        valorFlorVermelha.setText("");
    }

    @Override
    public void msgTipoJardineiro(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        controleFlor.usarFlor(florSelecionada);
        florSelecionada = -1;
        valorFlorAmarela.setText("");
        valorFlorVermelha.setText("");
    }

    @Override
    public void jardineiroJuniorEscura() {
        controle.JardineiroJuniorEscura();
    }

    @Override
    public void jardineiroSeniorcolocaPeca() {

    }

    @Override
    public void mensagem(String msg) {
        mensagens.setText(msg);
        this.repaint();
        this.validate();

    }

    @Override
    public void coachar() {
        Coachar coachar = new CoacharBase();

    }

    @Override
    public void removerSapos() {
       controle.removerSapos();
       tabuleiro.repaint();
       controle.enviarTabuleiro();
    }

    public static void main(String[] args) throws Exception {
        TabuleiroView t = new TabuleiroView();
        t.setVisible(true);
    }

}
