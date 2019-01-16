package projet.pkgfinal.s3;

import javax.swing.*;
import java.util.ArrayList;

import static projet.pkgfinal.s3.util.max;
import static projet.pkgfinal.s3.util.min;

public class EnsembleFigure extends Figure {

    //attributs
    private static int compteurId = 0;
    //utils
    private ArrayList<Figure> figures = new ArrayList<>();

    //Constructeurs

    public EnsembleFigure() {
        super.setIdFig("EnsembleFigure_N°" + compteurId);
        compteurId++;
    }

    public EnsembleFigure(ArrayList<Figure> figures) {
        this.figures = figures;
        super.setIdFig("EnsembleFigure_N°" + compteurId);
        compteurId++;
    }

    public EnsembleFigure(ArrayList<Figure> figures, String id) {
        this.figures = figures;
        super.setIdFig("EnsembleFigure_N°" + compteurId);
        super.setIdFig(id);
    }

    //methodes

    public void afficheFigure() {
        /*
        for (int i= 0 ; i<figures.size() ; i++){
            System.out.println("index" + i + "\t" + figures.get(i));
        */
        System.out.println(this);
    }

    public ArrayList<Figure> getAll() { //retourne toutes les figures
        return figures;
    }

    public void setAll(ArrayList<Figure> figures) { //change toute la liste de figure par un autre entrée
        this.figures = figures;
    }

    public Figure get(int index) { //retourne la figure a un indice donné
        return figures.get(index);
    }

    public void remove(int index) {// retire la figure a aun indice donné
        figures.remove(index);
    }

    public void clear() { //retire toutes les figures
        figures.clear();
    }

    public void add(Figure addedFig) { //ajoute une figure a l'ensemble
        figures.add(addedFig);
    }

    public int size() { //retourne le nombre de figure presente dans la liste
        return figures.size();
    }


    @Override
    public void zoom(float coefficient) {
        for (int i = 0; i < figures.size(); i++) {
            this.figures.get(i).zoom(coefficient);
        }
    }

    @Override
    public void translater(Point point) {
        for (int i = 0; i < this.figures.size(); i++) {
            this.figures.get(i).translater(point);
        }
    }

    @Override
    public void paint(JPanel jPanel) {
        for (int i = 0; i < this.figures.size(); i++) {
            this.figures.get(i).paint(jPanel);
        }
    }

    public void depaint(JPanel jPanel) {
        this.figures.clear();
        for (int i = 0; i < this.figures.size(); i++) {
            this.figures.get(i).paint(jPanel);
        }
        jPanel.repaint();
    }


    @Override
    public double distancePoint(Point A) {
        ArrayList<Double> dist = new ArrayList<Double>();
        for (int i = 0; i < figures.size(); i++) {
            dist.add(figures.get(i).distancePoint(A));
        }
        return min(dist);
    }

    @Override
    public double maxX() {
        ArrayList<Double> maxsX = new ArrayList<Double>();
        for (int i = 0; i < figures.size(); i++) {
            if (!(figures.get(i) instanceof EnsembleFigure))
                maxsX.add(figures.get(i).maxX());
            else {
                for (int j = 0; j < ((EnsembleFigure) figures.get(i)).size(); i++) {
                    maxsX.add(figures.get(i).maxX());
                }
            }

        }
        return max(maxsX);
    }

    @Override
    public double minX() {
        ArrayList<Double> minsX = new ArrayList<Double>();
        for (int i = 0; i < figures.size(); i++) {
            minsX.add(figures.get(i).minX());
        }
        return min(minsX);
    }

    @Override
    public double maxY() {
        ArrayList<Double> maxsY = new ArrayList<Double>();
        for (int i = 0; i < figures.size(); i++) {
            maxsY.add(figures.get(i).maxY());
        }
        return max(maxsY);
    }

    @Override
    public double minY() {
        ArrayList<Double> minsY = new ArrayList<Double>();
        for (int i = 0; i < figures.size(); i++) {
            minsY.add(figures.get(i).minY());
        }
        return min(minsY);
    }

    @Override
    public String toTxt(String nl) { //methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        String str = "<EnsembleFigure>" + nl;
        for (int i = 0; i < this.size(); i++) {
            str += this.get(i).toTxt(nl);
        }
        str += "</EnsembleFigure>" + nl + this.getIdFig() + nl;
        return str;
    }

    @Override
    public String toString() {
        String str = "EnsembleFigure[";
        if (this.size() > 0) {
            for (int i = 0; i < this.size(); i++) {
                str += this.get(i).toString() + ", ";
            }
            str = str.substring(0, str.length() - 2);
            str += ", ";
        }
        str += "idFig='" + super.getIdFig() + "']";
        return str;
    }
}