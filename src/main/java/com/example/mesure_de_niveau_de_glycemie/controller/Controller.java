package com.example.mesure_de_niveau_de_glycemie.controller;

import android.database.ContentObservable;

import com.example.mesure_de_niveau_de_glycemie.model.Patient;

public final class Controller {
    private static Controller instance = null;
    private static Patient patient;
    public static Controller getInstance(){
        if(Controller.instance==null){
            return Controller.instance=new Controller();
        }
        else
            return Controller.instance;
    }
    private Controller(){
        super();
    }
    // fleche "update" controller --> Model
    public void CreatePatient(int age,float vGlycemie,boolean isFasting){
        patient=new Patient(age, vGlycemie, isFasting);
    }
    // fleche "Notify" model --> controller
    public String getResponse(){
        return patient.getResponse();}
}
