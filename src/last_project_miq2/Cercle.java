package last_project_miq2;


import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Cercle extends Figure {

    //utils
    private static int compteurId = 0;
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    //attributs
    private double rayon;
    private Point centre;

    //constructeurs

    public Cercle(Point centre, double rayon) {
        this.rayon = rayon;
        this.centre = centre;
        super.setIdFig("Cercle_N°" + compteurId);
        compteurId++;
    }

    public Cercle(Point centre, double rayon, String id) {
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

    public Cercle(Point centre, Point point) {
        this.centre = centre;
        this.rayon = centre.distancePoint(point);
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
        this.centre = centre;
    }

    @Override
    public void zoom(float coefficient) {
        this.centre.zoom(coefficient);
        this.rayon=((double)coefficient)*this.rayon;
    }

    @Override
    public void translater(Point point) {
        this.centre.translater(point);
    }

    @Override
    public void paint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.drawOval((int) (centre.getX() - this.rayon), (int) (centre.getY() - this.rayon), (int) rayon * 2, (int) rayon * 2);
    }

    public void depaint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawOval((int) (centre.getX() - this.rayon), (int) (centre.getY() - this.rayon), (int) rayon * 2, (int) rayon * 2);
    }

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

    @Override
    public String toTxt(String nl) { //methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        return "<Cercle>" + nl + this.centre.toTxt(nl) + this.rayon + nl + this.getIdFig() + nl;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "P=" + this.centre.toString() +
                ",r=" + this.rayon +
                ", idFig=" + super.getIdFig() + "}";
    }
}
