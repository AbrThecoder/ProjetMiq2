package fr.insa.damien;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

import static fr.insa.damien.util.*;

public class Polyligne extends Figure {

    private ArrayList<Point> listP = new ArrayList<>();
    private static int compteurId = 0;
    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    //constructeurs

    public Polyligne(ArrayList<Point> listP, String id) {
        this.listP = listP;
        super.setIdFig(id);
        if (listP.size() < 3)
            throw new IllegalArgumentException("Il faut 3 point minimum pour faire un polygone");
    }

    public Polyligne(ArrayList<Point> listP) {
        this.listP = listP;
        super.setIdFig("Polygone_N°" + compteurId);
        compteurId++;
        if (listP.size() < 3)
            throw new IllegalArgumentException("Il faut 3 point minimum pour faire un polygone");
    }

    public Polyligne() {
        System.out.println("Création d'une serie de points pour former le Polyligne : ");
        for (int i = 0; i < 2; i++)
            listP.add(new Point());
            while (true){
            System.out.println("Voulez vous ajouter un autre point ?(o/n)");
            String rep = sc.nextLine();
            switch(rep) {
                case "o":
                    listP.add(new Point());
                    break;
                case "n" :
                    break;
                default:
                    throw new IllegalArgumentException("Vous devez entrer \"o\" ou \"n\"");
                }
            if (rep.equals("n"))
                break;
            }
        super.setIdFig("Polyligne_N°" + compteurId);
        compteurId++;
    }

    //methodes

    public double longeurPolyligne() { //retoune la longueur du polyligne
        double perimetre = 0;
        System.out.println(this.listP.size());
        for (int i = 0; i < this.listP.size() - 1; i++)
            perimetre += this.listP.get(i).distancePoint(this.listP.get(i + 1));
        return perimetre;
    }

    public ArrayList<Point> getListP() { // retourne la liste de point formant le polyligne
        return listP;
    }

    public void setListP(ArrayList<Point> listP) { //remplace la liste de point formant le polyligne
        this.listP = listP;
    }

    @Override
    public double distancePoint(Point A) {
        ArrayList<Double> L = new ArrayList<>();
        for (int i = 0; i < listP.size() - 1; i++) {
            L.add(new Segment(listP.get(i), listP.get(i + 1)).distancePoint(A));
        }
        return min(L);
    }

    @Override
    public double maxX() {
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i < this.listP.size(); i++)
            A.add(this.listP.get(i).getX());
        return max(A);
    }

    @Override
    public double minX() {
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i < this.listP.size(); i++)
            A.add(this.listP.get(i).getX());
        return min(A);
    }

    @Override
    public double maxY() {
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i < this.listP.size(); i++)
            A.add(this.listP.get(i).getY());
        return max(A);
    }

    @Override
    public double minY() {
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i < this.listP.size(); i++)
            A.add(this.listP.get(i).getY());
        return min(A);
    }

    @Override
    public String toTxt() { //methode permettant d'ecrire dans le "language" de l'algorithme utilisé pour lire les fichiers avec le programme
        String str= "<Polyligne>\n"+this.listP.size()+"\n";
        for(int i = 0 ; i<listP.size(); i++){
            str+=this.listP.get(i).toTxt();
        }
        str+=this.getIdFig()+"\n";
        return str;
    }

    @Override
    public String toString() {
        String str = "Polyligne{";
        for (int i = 0; i < this.listP.size(); i++) {
            str += this.listP.get(i).toString()+",";
        }
        str += " idFig='" + super.getIdFig() + "'}";
        return str;
    }

}
