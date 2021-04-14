package com.mycompany.weatherdatadisplay.presenter;

import com.mycompany.weatherdatadisplay.principal;
import com.mycompany.weatherdatadisplay.model.banco;
import com.mycompany.weatherdatadisplay.model.dado;
import com.mycompany.weatherdatadisplay.view.TelaMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import org.json.XML;
import org.json.simple.JSONObject;

/**
 *
 * @author Robinson
 */
public class enviaDados {      
    
    
    
    public static int getIndex(){
        TelaMain tela = principal.getTela();
        return tela.getSelecionadoPeriodo().getSelectedIndex();
    }

    public void enviar(TelaMain tela){
        dado dado = new dado();
        String dados[] = new String[4];
        dados[0] = tela.getDadosTempoData().getText();
        dados[1] = tela.getDadosTempoTemperatura().getText();
        dados[2] = tela.getDadosTempoUmidade().getText();
        dados[3] = tela.getDadosTempoPressao().getText();
        dado.setInformacoes(dados);
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Data", tela.getDadosTempoData().getText());
        jsonObject.put("Temperatura", tela.getDadosTempoTemperatura().getText());
        jsonObject.put("Umidade", tela.getDadosTempoUmidade().getText());
        jsonObject.put("Pressão", tela.getDadosTempoPressao().getText());
        jsonObject.put("Tipo", "Inclusão");
        String xml = XML.toString(jsonObject);
        banco.getJsonArray().add(jsonObject);
        banco.getXMLArray().append("<log>").append(xml).append("</log>");
        
        tela.getDadosTempoData().setText("");
        tela.getDadosTempoUmidade().setText("");
        tela.getDadosTempoPressao().setText("");
        tela.getDadosTempoTemperatura().setText("");
    }
}
