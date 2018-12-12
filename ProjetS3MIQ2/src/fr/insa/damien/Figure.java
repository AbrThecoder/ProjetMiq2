package fr.insa.damien;

import javax.swing.*;

public abstract class Figure {

    //attributs
    private String idFig; // definit dans les subclasses

    //constructeurs : aucun

    //methodes

    //non abstraites

    public String getIdFig() {
        return idFig;
    }

    public void setIdFig(String idFig) {
        this.idFig = idFig;
    }

    //abstraites

    public abstract void paint(JPanel jPanel);

    public abstract double distancePoint(Point A);

    public abstract double maxX();

    public abstract double minX();

    public abstract double maxY();

    public abstract double minY();

    public abstract String toTxt(); //methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme

    public abstract String toString();

}
