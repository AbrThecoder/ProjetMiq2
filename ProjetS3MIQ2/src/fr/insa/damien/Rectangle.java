package fr.insa.damien;

import javax.swing.*;

import java.awt.*;

import static fr.insa.damien.util.max;
import static fr.insa.damien.util.min;

public class Rectangle extends Figure{

    private Point p0;
    private Point p1;
    private static int compteurId = 0;

    public Rectangle(Point p0, Point p1) {
        this.p0 = p0;
        this.p1 = p1;
        super.setIdFig("Rectangle_N°"+compteurId);
        compteurId++;
    }


    @Override
    public void paint(JPanel jPanel){
        Graphics2D graphics2D = (Graphics2D)jPanel.getGraphics();
        Point corner1 =new Point(min(p0.getX(),p1.getX()),min(p0.getY(),p1.getY()));
        Point corner2=new Point(max(p0.getX(),p1.getX()),max(p0.getY(),p1.getY()));
        graphics2D.drawRect((int)corner1.getX(),(int)corner1.getY(),(int)(corner2.getX()-corner1.getX()),(int)(corner2.getY()-corner1.getY()));
    }

    @Override
    public double distancePoint(Point A) {
        return 0;
    }

    @Override
    public double maxX() {
        return max(p0.getX(),p1.getX());
    }

    @Override
    public double minX() {
        return min(p0.getX(),p1.getX());
    }

    @Override
    public double maxY() {
        return max(p0.getY(),p1.getY());
    }

    @Override
    public double minY() {
        return min(p0.getY(),p1.getY());
    }

    @Override
    public String toTxt() {
        return null;
    }

    @Override
    public String toString() {
        return "Rectangle{p0="+p0.toString()+","+p1.toString()+",id="+ super.getIdFig() +"}";
    }
}
