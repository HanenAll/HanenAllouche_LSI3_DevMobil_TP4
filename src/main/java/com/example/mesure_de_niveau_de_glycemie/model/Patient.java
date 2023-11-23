package com.example.mesure_de_niveau_de_glycemie.model;

public class Patient {
    private int age;
    private float vGlycemie;
    private boolean jeune;

    private String response;

    //Flèche "Update" Controller --> Model
    public Patient(int age, float vGlycemie, boolean jeune) {
        this.age = age;
        this.vGlycemie = vGlycemie;
        this.jeune = jeune;
        calculer();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVGlycemie(float vGlycemie) {
        this.vGlycemie = vGlycemie;
    }

    public void setJeune(boolean jeune) {
        this.jeune = jeune;
    }

    public int getAge() {
        return age;
    }

    public float getvGlycemie() {
        return vGlycemie;
    }

    public boolean getJeune() {
        return jeune;
    }

    //Flèche "Notify" Model --> Controller
    public String getResponse() {
        return response;
    }
    public void calculer() {

        if (jeune) {
            if (age >= 13) {
                if (vGlycemie < 5.0)
                    response = "Niveau de glycémie est trop bas";
                else if (vGlycemie >= 5.0 && vGlycemie <= 7.2)
                    response = "Niveau de glycémie est normale";
                else
                    response = "Niveau de glycémie est trop élevé";
            } else if (age >= 6 && age <= 12) {
                if (vGlycemie < 5.0)
                    response = "Niveau de glycémie est trop bas";
                else if (vGlycemie >= 5.0 && vGlycemie <= 10.0)
                    response = "Niveau de glycémie est normale";
                else
                    response = "Niveau de glycémie est trop élevé";
            } else if (age < 6) {
                if (vGlycemie < 5.5)
                    response = "Niveau de glycémie est trop bas";
                else if (vGlycemie >= 5.5 && vGlycemie <= 10.0)
                    response = "Niveau de glycémie est normale";
                else
                    response = "Niveau de glycémie est trop élevé";
            }
        } else {
            if (vGlycemie > 10.5)
                response = "Niveau de glycémie est trop élevé";
            }
        }
}
