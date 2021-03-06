package projet.pkgfinal.s3;

import javax.swing.*;
import java.awt.*;

import static projet.pkgfinal.s3.util.max;
import static projet.pkgfinal.s3.util.min;


public class Segment extends Figure {
    //statics
    private static int compteurId = 0;
    //attributs
    private Point P0;
    private Point P1;

    //constructeurs

    public Segment(Point p0, Point p1, String id) {
        this.P0 = p0;
        this.P1 = p1;
        super.setIdFig(id);
    }

    public Segment(Point p0, Point p1) {
        this.P0 = p0;
        this.P1 = p1;
        compteurId++;
        super.setIdFig("Segment_N°" + compteurId);
    }

    public Segment() {
        System.out.println("Pour créer le segment nous allons créer 2 points");
        System.out.println("Point 1 :");
        this.P0 = new Point();
        System.out.println("Point 2 :");
        this.P1 = new Point();
        super.setIdFig("Segment_N°" + compteurId);
        compteurId++;
    }


    //methodes

    public double longueurSegment() {
        return this.P0.distancePoint(P1);
    }

    public double distancePoint(Point p3) {
        //cf documentation pdf
        double up = (p3.getX() - this.P0.getX()) * (this.P1.getX() - this.P0.getX()) + (p3.getY() - this.P0.getY()) * (this.P1.getX() - this.P0.getY());
        up /= Math.pow((this.P1.getX() - this.P0.getX()), 2) + Math.pow((this.P1.getY() - this.P0.getY()), 2);

        //3 cas differents selon up cf doc
        if (up < 0)
            return this.P0.distancePoint(p3);
        if (up > 1)
            return this.P1.distancePoint(p3);
        else {
            Point p4 = new Point(this.P0.getX() + up * (this.P1.getX() - this.P0.getX()),
                    this.P0.getY() + up * (this.P1.getY() - this.P0.getY()));
            return p3.distancePoint(p4);
        }
    }

    public Point getP0() {
        return P0;
    }

    public void setP0(Point P0) {
        this.P0 = P0;
    }

    public Point getP1() {
        return P1;
    }

    public void setP1(Point P1) {
        this.P1 = P1;
    }

    @Override
    public void zoom(float coefficient) {
        this.P0.zoom(coefficient);
        this.P1.zoom(coefficient);
    }

    @Override
    public void translater(Point point) {
        this.P0.translater(point);
        this.P1.translater(point);
    }

    @Override
    public void paint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.drawLine((int) P0.getX(), (int) P0.getY(), (int) P1.getX(), (int) P1.getY());
    }

    public void depaint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawLine((int) P0.getX(), (int) P0.getY(), (int) P1.getX(), (int) P1.getY());
    }

    @Override
    public double maxX() {
        return max(this.P0.getX(), this.P1.getX());
    }

    @Override
    public double minX() {
        return min(this.P0.getX(), this.P1.getX());
    }

    @Override
    public double maxY() {
        return max(this.P0.getY(), this.P1.getY());
    }

    @Override
    public double minY() {
        return min(this.P0.getY(), this.P1.getY());
    }

    @Override
    public String toTxt(String nl) {//methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        return "<Segment>" + nl + this.P0.toTxt(nl) + this.P1.toTxt(nl) + this.getIdFig() + nl;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "P0=" + P0 +
                ", P1=" + P1 +
                ", idFig='" + super.getIdFig() + '\'' +
                '}';
    }

}
