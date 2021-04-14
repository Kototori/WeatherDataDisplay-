/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherdatadisplay.colection;

import com.mycompany.weatherdatadisplay.model.IModelObserver;
import com.mycompany.weatherdatadisplay.model.IRecebeDados;
import com.mycompany.weatherdatadisplay.model.mediaModelObserver;
import com.mycompany.weatherdatadisplay.model.tabelModelObserver;
import com.mycompany.weatherdatadisplay.model.dado;
import com.mycompany.weatherdatadisplay.model.ultimaAtualizacaoObserver;
import java.util.ArrayList;

/**
 *
 * @author Robinson
 */
public class dadoColection implements IRecebeDados {
    
    private ArrayList<IModelObserver> observers;
    private ArrayList<dado> dadoObservers;

    public ArrayList<dado> getDadoObservers() {
        return dadoObservers;
    }
     
    private static dadoColection instances;
    
    private ultimaAtualizacaoObserver ob1 = new ultimaAtualizacaoObserver();
    private mediaModelObserver ob2 = new mediaModelObserver();
    private tabelModelObserver ob3 = new tabelModelObserver();
    
    private dadoColection (){
        observers = new ArrayList<IModelObserver>();
        dadoObservers = new ArrayList<dado>();
        registrar(ob1);
        registrar(ob2);
        registrar(ob3);
    }
    
    
    public  void notificar (){
        for (int i = 0; i < observers.size(); i++){
            IModelObserver ob = observers.get(i);
            ob.update(dadoObservers);
        }
    }
    
    public void registrar (IModelObserver ob){
        observers.add(ob);
    }
    
    public void add (dado dado){
        dadoObservers.add(dado);
        notificar();
    }
    
    public void remove (dado dado){
        
        for (int i = 0; i < dadoObservers.size(); i++){
            if (dadoObservers.get(i).getData().equals(dado.getData())){
                dadoObservers.remove(i);
                notificar();
            }
        }
    }
    
    public static dadoColection getIntances (){
        if (instances == null){
            instances = new dadoColection();
        }
        
        return instances;
    }
}
