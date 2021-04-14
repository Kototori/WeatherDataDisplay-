package com.mycompany.weatherdatadisplay.model;

import com.mycompany.weatherdatadisplay.presenter.atualizarTela;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Robinson
 */
public class tabelModelObserver implements IModelObserver {
    
    private  static int anterior;
    private int atual;
       
    public tabelModelObserver(){
        anterior = 0;
    }
    
    public void update(ArrayList<dado> dado) {
        atual = dado.size();
        if (anterior < atual && dado.size() > 0){
            atualizarTela.atualizarTabela(dado.get(dado.size()-1));
        }
      
    }
}
