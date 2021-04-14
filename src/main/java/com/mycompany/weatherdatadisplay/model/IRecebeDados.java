package com.mycompany.weatherdatadisplay.model;
import com.mycompany.weatherdatadisplay.view.TelaMain;
/**
 *
 * @author Robinson
 */
public interface IRecebeDados {
        public void notificar ();
        public void registrar (IModelObserver ob);
        
}
