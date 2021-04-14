/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherdatadisplay.presenter;

import com.mycompany.weatherdatadisplay.model.banco;
import com.mycompany.weatherdatadisplay.model.dado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.XML;
import com.mycompany.weatherdatadisplay.colection.dadoColection;
import com.mycompany.weatherdatadisplay.principal;
import javax.swing.JTable;

/**
 *
 * @author Robinson
 */
import com.mycompany.weatherdatadisplay.view.TelaMain;
import java.util.Vector;

public class removerDados {

   

    public void update(dado dado) {
        atualizarTela.atualizarTabela(dado);

    }

     public void removerDados() {
        dado dado = new dado();
        TelaMain tela = principal.getTela();
        JTable tabela = tela.getRegistroTabela();

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        var row = tabela.getSelectedRow();

        org.json.JSONObject jsonObject = new org.json.JSONObject();
        Vector vetor = model.getDataVector().elementAt(row);

        String data;
        String temperatura, umidade, pressao;

        data = vetor.get(0).toString();
        temperatura = vetor.get(1).toString();
        umidade = vetor.get(2).toString();
        pressao = vetor.get(3).toString();
        
        String[] vetorRemove = new String[4];
        vetorRemove[0] = data;
        vetorRemove[1] = temperatura;
        vetorRemove[2] = umidade;
        vetorRemove[3] = pressao;        
        
        model.removeRow(row);
        dado.removeInformacoes(vetorRemove);
    }

}
