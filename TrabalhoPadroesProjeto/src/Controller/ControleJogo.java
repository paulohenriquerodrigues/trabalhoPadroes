package Controller;

import Model.Peca;
import javax.swing.Icon;

public interface ControleJogo {

    void inicializar() throws Exception;

    Icon getPeca(int col, int row) throws Exception;
    
    Peca getPecaTabuleiro(int col, int row) throws Exception;

    void pressTecla(int keyCode) throws Exception;
    
    void colunaLinhaSelecionada(int coluna, int linha);

    void addObservador(Observador obs);
    
    void JardineiroJuniorEscura();
    
    void jardineiroSeniorcolocaPeca(int coluna, int linha);

}
