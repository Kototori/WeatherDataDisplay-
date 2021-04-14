package com.mycompany.weatherdatadisplay.model;

import com.mycompany.weatherdatadisplay.presenter.atualizarTela;
import com.mycompany.weatherdatadisplay.presenter.enviaDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Robinson
 */
public class mediaModelObserver implements IModelObserver {

    private ArrayList<dado> dadoObservers;

    public mediaModelObserver() {
        dadoObservers = new ArrayList<dado>();
    }

    private int count;
    private float mediaTemperatura;
    private float mediaUmidade;
    private float mediaPressao;
    LocalDate date = LocalDate.now();
    private String dataAtual = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String[] dataSplit = dataAtual.split("/");

    public void update(ArrayList<dado> dado) {

        if (dado.size() > 0) {

            mediaTemperatura = 0;
            mediaUmidade = 0;
            mediaPressao = 0;
            count = 0;

            for (int i = 0; i < dado.size(); i++) {
                mediaTemperatura = ((dado.get(i).getTemperatura()) + mediaTemperatura);
                mediaUmidade = (dado.get(i).getUmidade() + mediaUmidade);
                mediaPressao = (dado.get(i).getPressao() + mediaPressao);
                count++;
            }
            mediaTemperatura = mediaTemperatura / count;
            mediaUmidade = mediaUmidade / count;
            mediaPressao = mediaPressao / count;

            atualizarTela.atualizarMedia(dataAtual, mediaTemperatura, mediaUmidade, mediaPressao);
            atualizarTela.numeroLeituras(count);
        } else {
            atualizarTela.atualizarMedia("-",0,0,0);
        }
    }
}
