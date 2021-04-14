package com.mycompany.weatherdatadisplay;

import com.mycompany.weatherdatadisplay.model.dado;
import com.mycompany.weatherdatadisplay.presenter.enviaDados;
import com.mycompany.weatherdatadisplay.presenter.removerDados;
import com.mycompany.weatherdatadisplay.view.TelaMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Robinson
 */
public class principal {

    private static TelaMain tela;

    public static TelaMain getTela() {
        return tela;
    }

    public static void main(String args[]) {
        tela = new TelaMain();
        enviaDados incluir = new enviaDados();
        removerDados remove = new removerDados();

        tela.getIncluirDados().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluir.enviar(tela);
            }
        });

        tela.getRemoverBotao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove.removerDados();
            }
        });

    }
}
