/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Pecas.Flores;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author paulohenrique
 */
public class FlorController {

    private List<FlorObserver> observadores = new ArrayList<>();
    private List<Flores> flores = new ArrayList<>();

    int[] valores = new int[8];

    public void addFlores(String cor) {

        Random gera = new Random();
        int i = 0;
        while (i < valores.length) {
            valores[i] = gera.nextInt(8) + 1;
            boolean existe = false;
            for (int j = 0; j < i; j++) {
                if (valores[i] == valores[j]) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                if ("Amarelo".equals(cor)) {
                    Flores flor = new Flores(cor, valores[i], new ImageIcon("imagens/rosa-amarela.png"));
                    flores.add(flor);
                } else {
                    Flores flor = new Flores(cor, valores[i], new ImageIcon("imagens/rosa-vermelha.png"));
                    flores.add(flor);
                }
                i++;
            }
        }
    }

    public void carregaBotaoFlores() {
        if (flores.size() > 2) {
            for (int i = 0; i < 3; i++) {
                addFloresOBS(flores.get(i).getValor(), i);
            }
        } else {
            for (int i = 0; i < flores.size(); i++) {
                addFloresOBS(flores.get(i).getValor(), i);
            }
        }
    }

    public List<Flores> getFlores() {
        return flores;
    }

    public Flores getFlor(int i) {
        Flores f = flores.get(i);
        return f;
    }

    public void addFloresOBS(int i, int index) {
        observadores.forEach((obs) -> {
            obs.addFlores(i, index);
        });
    }

    public void removerFloresJPanel() {
        observadores.forEach((obs) -> {
            obs.removerFloresJPanel();
        });
    }

    public void addObservador(FlorObserver obs) {
        observadores.add(obs);
    }

    public void usarFlor(int valor) {
        for (int i = 0; i < flores.size(); i++) {
            if (valor == flores.get(i).getValor()) {
                flores.remove(i);
                i = 10;

            }
        }
        removerFloresJPanel();

    }

}
