package fr.insa.damien;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Cercle extends Figure {

    //attributs
    private double rayon;
    private Point centre;
    //utils
    private static int compteurId = 0;
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    //constructeurs

    public Cercle(Point centre, double rayon) {
        this.rayon = rayon;
        this.centre = centre;
        super.setIdFig("Cercle_N°" + compteurId);
        compteurId++;
    }

    public Cercle(Point centre,double rayon, String id) {
        this.rayon = rayon;
        this.centre = centre;
        super.setIdFig(id);
    }

    public Cercle() {
        System.out.println("Centre du cercle : ");
        this.centre = new Point();
        System.out.println("Entrer le rayon du cercle");
        this.rayon = sc.nextDouble();
        super.setIdFig("Cercle_N°" + compteurId);
        compteurId++;
    }

    //methodes

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;}

    @Override
    public double distancePoint(Point A) {
        return abs(rayon - A.distancePoint(this.centre));
    }

    @Override
    public double maxX() {
        return centre.maxX() + rayon;
    }

    @Override
    public double minX() {
        return centre.maxX() - rayon;
    }

    @Override
    public double maxY() {
        return centre.maxY() + rayon;
    }

    @Override
    public double minY() {
        return centre.maxY() - rayon;
    }


    public String toTxt() { //methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        return "<Cercle>\n"+this.centre.toTxt()+this.rayon+"\n"+this.getIdFig()+"\n";
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "P=" + this.centre.toString() +
                ",r=" + this.rayon +
                ", idFig=" + super.getIdFig() + "}" ;
    }
}
