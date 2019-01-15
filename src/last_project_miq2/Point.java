package last_project_miq2;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Point extends Figure {
    //statics
    private static int compteurId = 0;
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    //attributs
    private double rayon; // utile uniquement pour l'affichage
    private double x;
    private double y;

    //constructeurs

    public Point(double x, double y, String id) {
        this.x = x;
        this.y = y;
        this.rayon=10;
        super.setIdFig(id);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.rayon=10;
        super.setIdFig("Point_N°" + compteurId);
        compteurId++;
    }

    public Point() {
        System.out.println("Création d'un Point : veuillez entrer l'abcsisse (x) et l'ordoonée (y) du point ");
        System.out.println("x=");
        this.x = sc.nextDouble(); // attention la locale fr pour les double est avec une virgule ex: double A =12,3;  fonctionne mais pas double A =12.3;
        System.out.println("y=");
        this.y = sc.nextDouble();
        super.setIdFig("Point_N°" + compteurId);
        compteurId++;
    }

    //methodes

    public double distancePoint(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void zoom(float coefficient) {
        this.rayon=this.rayon*coefficient;
        this.x=(int)((float)this.x*coefficient);
        this.y=(int)((float)this.y*coefficient);

    }

    @Override
    public void translater(Point point) {
        this.x -=point.getX();
        this.y-=point.getY();
    }

    @Override
    public void paint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.fillOval((int) x, (int) y, (int)this.rayon, (int)this.rayon);
    }

    @Override
    public double maxX() {
        return x;
    }

    @Override
    public double maxY() {
        return y;
    }

    @Override
    public double minX() {
        return x;
    }

    @Override
    public double minY() {
        return y;
    }

    @Override
    public String toTxt(String nl) {//methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        return "<Point>" + nl + this.x + nl + this.y + nl + this.getIdFig() + nl;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ",y=" + y +
                ",idFig='" + super.getIdFig() + '\'' +
                '}';
    }


}
