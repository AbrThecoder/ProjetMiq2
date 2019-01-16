package projet.pkgfinal.s3;

import javax.swing.*;
import java.awt.*;

import static projet.pkgfinal.s3.util.max;
import static projet.pkgfinal.s3.util.min;

public class Rectangle extends Figure {

    private static int compteurId = 0;
    private Point p0;
    private Point p1;

    public Rectangle(Point p0, Point p1) {
        this.p0 = p0;
        this.p1 = p1;
        super.setIdFig("Rectangle_N°" + compteurId);
        compteurId++;
    }

    public Rectangle(Point p0, Point p1, String id) {
        this.p0 = p0;
        this.p1 = p1;
        super.setIdFig(id);
    }

    @Override
    public void zoom(float coefficient) {
        this.p0.zoom(coefficient);
        this.p1.zoom(coefficient);

    }

    @Override
    public void translater(Point point) {
        this.p0.translater(point);
        this.p1.translater(point);
    }

    @Override
    public void paint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        Point corner1 = new Point(min(p0.getX(), p1.getX()), min(p0.getY(), p1.getY()));
        Point corner2 = new Point(max(p0.getX(), p1.getX()), max(p0.getY(), p1.getY()));
        graphics2D.drawRect((int) corner1.getX(), (int) corner1.getY(), (int) (corner2.getX() - corner1.getX()), (int) (corner2.getY() - corner1.getY()));

    }

    public void depaint(JPanel jPanel) {
        Graphics2D graphics2D = (Graphics2D) jPanel.getGraphics();
        graphics2D.setColor(Color.WHITE);
        Point corner1 = new Point(min(p0.getX(), p1.getX()), min(p0.getY(), p1.getY()));
        Point corner2 = new Point(max(p0.getX(), p1.getX()), max(p0.getY(), p1.getY()));
        graphics2D.drawRect((int) corner1.getX(), (int) corner1.getY(), (int) (corner2.getX() - corner1.getX()), (int) (corner2.getY() - corner1.getY()));
    }

    @Override
    public double distancePoint(Point A) {
        return 0;
    }

    @Override
    public double maxX() {
        return max(p0.getX(), p1.getX());
    }

    @Override
    public double minX() {
        return min(p0.getX(), p1.getX());
    }

    @Override
    public double maxY() {
        return max(p0.getY(), p1.getY());
    }

    @Override
    public double minY() {
        return min(p0.getY(), p1.getY());
    }

    @Override
    public String toTxt(String nl) {
        return "<Rectangle>" + nl + this.p0.toTxt(nl) + this.p1.toTxt(nl) + this.getIdFig() + nl;
    }

    @Override
    public String toString() {
        return "Rectangle{p0=" + p0.toString() + "," + p1.toString() + ",id=" + super.getIdFig() + "}";
    }
}
