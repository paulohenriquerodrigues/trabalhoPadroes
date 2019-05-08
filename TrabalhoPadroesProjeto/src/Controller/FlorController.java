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
    private List<Flores> floresAmarelas = new ArrayList<>();
    private List<Flores> floresVermelhas = new ArrayList<>();

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
                if (cor == "Amarelo") {
                    Flores flor = new Flores(cor, valores[i], new ImageIcon("imagens/rosa-amarela.png"));
                    floresAmarelas.add(flor);
                } else {
                    Flores flor = new Flores(cor, valores[i], new ImageIcon("imagens/rosa-vermelha.png"));
                    floresVermelhas.add(flor);
                    
                }
                i++;
            }
        }
        if("Amarelo".equals(cor)){
        for(int z = 0; z < floresAmarelas.size(); z++){
            System.out.println(z);
        }
        }else{
        for(int z = 0; z < floresVermelhas.size(); z++){
        addFloresOBS(z);
        }
        }
    }

    public List<Flores> getFloresAmarelas() {
        return floresAmarelas;
    }

    public List<Flores> getFloresVermelhas() {
        return floresVermelhas;
    }

    public Flores getFlorAmarela(int i) {
        Flores f = floresAmarelas.get(i);
        return f;
    }
    
    public Flores getFlorVermelha(int i) {
        Flores f = floresVermelhas.get(i);
        return f;
    }

    public void addFloresOBS(int i) {
        for (FlorObserver obs : observadores) {
             obs.addFlores(i);
        }
    }

    public void addObservador(FlorObserver obs) {
        observadores.add(obs);
    }

}
