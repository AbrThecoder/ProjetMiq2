package projet.pkgfinal.s3;

import javax.swing.*;
import java.awt.*;

import static projet.pkgfinal.s3.util.max;
import static projet.pkgfinal.s3.util.min;


public class Triangle extends Figure {

    private static int compteurId = 0;
    private Point P0;
    private Point P1;
    private Point P2;

    //constructeurs

    public Triangle(Point p0, Point p1, Point p2) {
        P0 = p0;
        P1 = p1;
        P2 = p2;
        super.setIdFig("Triangle_N°" + compteurId);
        compteurId++;
    }

    public Triangle(Point p0, Point p1, Point p2, String id) {
        P0 = p0;
        P1 = p1;
        P2 = p2;
        super.setIdFig(id);
    }

    public Triangle() {
        System.out.println("Création de trois points pour generer un triangle \n" +
                "Point 1 :");
        P0 = new Point();
        System.out.println("Point 2 : ");
        P1 = new Point();
        System.out.println("Point 3 :");
        P2 = new Point();
        super.setIdFig("Triangle_N°" + compteurId);
        compteurId++;
    }

    //methodes

    public double perimetre() {
        return P0.distancePoint(P1) + P1.distancePoint(P2) + P2.distancePoint(P0);
    }

    public Point getP0() {
        return P0;
    }

    public void setP0(Point p0) {
        P0 = p0;
    }

    public Point getP1() {
        return P1;
    }

    public void setP1(Point p1) {
        P1 = p1;
    }

    public Point getP2() {
        return P2;
    }

    public void setP2(Point p2) {
        P2 = p2;
    }

    @Override
    public void zoom(float coefficient) {
        this.P0.zoom(coefficient);
        this.P1.zoom(coefficient);
        this.P2.zoom(coefficient);

    }

    @Override
    public void translater(Point point) {
        this.P0.translater(point);
        this.P1.translater(point);
        this.P2.translater(point);
    }

    @Override
    public void paint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        int xs[] = {(int) this.P0.getX(), (int) this.P1.getX(), (int) this.P2.getX()};
        int ys[] = {(int) this.P0.getY(), (int) this.P1.getY(), (int) this.P2.getY()};
        graphics2D.drawPolygon(xs, ys, 3);
    }

    @Override
    public double distancePoint(Point A) {
        return min(new double[]{(new Segment(P0, P1)).distancePoint(A), (new Segment(P1, P2)).distancePoint(A), (new Segment(P2, P0)).distancePoint(A)});
    }

    @Override
    public double maxX() {
        return max(new double[]{P0.getX(), P1.getX(), P2.getX()});
    }

    @Override
    public double minX() {
        return min(new double[]{P0.getX(), P1.getX(), P2.getX()});
    }

    @Override
    public double maxY() {
        return max(new double[]{P0.getY(), P1.getY(), P2.getY()});
    }

    @Override
    public double minY() {
        return min(new double[]{P0.getY(), P1.getY(), P2.getY()});
    }

    @Override
    public String toTxt(String nl) {//methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        return "<Triangle>" + nl + this.P0.toTxt(nl) + this.P1.toTxt(nl) + this.P2.toTxt(nl) + this.getIdFig() + nl;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "P0=" + P0 +
                ",P1=" + P1 +
                ",P2=" + P2 +
                ", idFig=" + super.getIdFig() + "}";
    }
}
