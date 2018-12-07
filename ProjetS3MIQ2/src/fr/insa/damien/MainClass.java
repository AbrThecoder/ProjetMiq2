package fr.insa.damien;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {

        menu();


    }

    public static EnsembleFigure menu() throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        EnsembleFigure ret = new EnsembleFigure();  // on est obligé d'entrer un tableau our pouvoir choisir de visualiser, ou de calculer la distance
        String reponse;

        while (true) {

            System.out.println("" +
                    "\n1)  Ajouter un ensemble de figure" +
                    "\n2)  Ajouter une figure" +
                    "\n3)  Afficher l'ensemble" +
                    "\n4)  Afficher une figure" +
                    "\n5)  Afficher les coordonées extremes d'une figure" +
                    "\n6)  Afficher les coordonees extreme de l'ensemble" +
                    "\n7)  Supprimer une figure" +
                    "\n8)  Supprimer l'ensemble" +
                    "\n9)  Grouper l'ensemble" +
                    "\n10) Eclater un ensemble de figure" +
                    "\n11) Calculer la distance entre une figure et un point" +
                    "\n12) Sauvegarder l'ensemble dans un fichier" +
                    "\n13) Lire un fichier" +
                    "\nq)  Pour quitter\n");
            reponse = sc.nextLine();

            switch (reponse) {
                case "1":
                    ret.add(entreEnsembleFigure());
                    break;
                case "2":
                    ret.add(entreFigure());
                    break;
                case "3":
                    System.out.println(ret);
                    break;
                case "4":
                    System.out.println(ret.get(indiceFig(ret)));
                    break;
                case "5":
                    int i = indiceFig(ret);
                    System.out.println("Pour la figure suivante : " + ret.get(i));
                    System.out.println("xmax=" + ret.get(i).maxX());
                    System.out.println("xmin=" + ret.get(i).minX());
                    System.out.println("ymax=" + ret.get(i).maxY());
                    System.out.println("ymin=" + ret.get(i).maxY());
                    break;
                case "6":
                    System.out.println("Parmi l'ensemble de toutes les figures :");
                    System.out.println("xmax=" + ret.maxX());
                    System.out.println("xmin=" + ret.minX());
                    System.out.println("ymax=" + ret.maxY());
                    System.out.println("ymin=" + ret.minY());
                    break;
                case "7":
                    ret.remove(indiceFig(ret));
                    break;
                case "8":
                    ret.clear();
                    break;
                case "9":
                    ArrayList<Figure> temp = new ArrayList<>(ret.getAll());
                    ret.clear();
                    ret.add(new EnsembleFigure(temp));
                    System.out.println("L'ensemble à été groupé");
                    break;
                case "10":
                    i = indiceFig(ret);
                    if (ret.get(i) instanceof EnsembleFigure) {
                        for (int j = 0; j < ((EnsembleFigure) ret.get(i)).size(); j++) {
                            ret.add(((EnsembleFigure) ret.get(i)).get(j));
                        }
                        ret.remove(i);
                    } else
                        throw new IllegalArgumentException("Erreur l'élement à l'indice entré n'est pas un EnsembleFigure");
                    break;
                case "11":
                    System.out.println("Calcul de la distance entre une figure et un point");
                    i = indiceFig(ret);
                    Point tmp = new Point();
                    System.out.println("La distance entre " + ret.get(i) + " et " + tmp + " est de :" + ret.get(i).distancePoint(tmp));
                    break;
                case "12":
                    System.out.println("Indiquez le nom et chemin d'acces du fichier que vous voulez creer (ou entree pour par default)\n Attention cela supprimera l'ancien Fichier");
                    String repertory = sc.nextLine();
                    if (repertory.equals("")) {
                        writeFile(ret, System.getProperty("user.dir") + "/src/fr/insa/damien/data");
                    } else {
                        writeFile(ret, repertory);
                    }
                    break;
                case "13":
                    System.out.println("Indiquez le nom et chemin d'acces du fichier que vous voulez creer (ou entree pour par default)");
                    repertory = sc.nextLine();
                    if (repertory.equals("")) {
                        ret.add(readFile(System.getProperty("user.dir") + "/src/fr/insa/damien/data"));
                    } else {
                        ret.add(readFile(repertory));
                    }
                    break;
                case "q":
                    System.out.println("Fermeture du programme.");
                    break;
                default:
                    throw new IllegalArgumentException("Valeur du menu incorrecte Entrée");
            }

            if (reponse.equals("q"))
                break;
        }

        return ret;

    }

    public static EnsembleFigure entreEnsembleFigure() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        EnsembleFigure ret = new EnsembleFigure();
        while (true) {
            System.out.println("Voulez-vous ajouter une figure ? (o/n)");
            String str = sc.nextLine();
            switch (str) {
                case "o":
                    ret.add(entreFigure());
                    break;
                case "n":
                    return ret;
                default:
                    throw new IllegalArgumentException("Vous devez entrer o / n ");
            }
        }
    }

    public static Figure entreFigure() { // demande d'entrer une figure a l'utilisateur et la retourne
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String reponse;
        System.out.println("Création d'une figure :\n" +
                "1) Point \n" +
                "2) Segment \n" +
                "3) Cercle \n" +
                "4) Triangle \n" +
                "5) Polygone \n" +
                "6) Polyligne \n");
        reponse = sc.nextLine();
        switch (reponse) {
            case "1":
                return new Point();
            case "2":
                return new Segment();
            case "3":
                return new Cercle();
            case "4":
                return new Triangle();
            case "5":
                return new Polygone();
            case "6":
                return new Polyligne();
            default:
                throw new IllegalArgumentException("Mauvaise valeure entrée");
        }
    }

    public static int indiceFig(EnsembleFigure ret) { // Demande l'indice et le renvoie
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Entrez l'indice de la figure : ");
        int i = sc.nextInt();
        sc.nextLine();
        if (i >= ret.size())
            throw new IndexOutOfBoundsException("Erreur l'indice entree est trop grand");
        return i;
    }

    public static int readInt(BufferedReader bufferedReader) throws IOException { // Convertit la ligne suivante et renvoie un entier
        return Integer.valueOf(bufferedReader.readLine());

    }

    public static double readDouble(BufferedReader bufferedReader) throws IOException {// Convertit la ligne suivante et renvoie un double
        return Double.valueOf(bufferedReader.readLine());

    }

    public static Point readPoint(BufferedReader bufferedReader) throws IOException {//Convertit les 4 prochaines lignes en un point retourné
        bufferedReader.readLine();
        return new Point(readDouble(bufferedReader), readDouble(bufferedReader), bufferedReader.readLine());

    }

    public static EnsembleFigure readEnsembleFigure(BufferedReader bufferedReader) throws IOException {
        //Lorsque q'une balise <EnsembleFigure> est rencontrée parcoure le fichier pour retourner l'ensemble figure.
        EnsembleFigure ensembleFigure = new EnsembleFigure();
        while (true) {
            String str = bufferedReader.readLine();
            if (str == null)
                throw new Error("Le fichier est fini sans finir un ensembleFigure");
            if (str.equals("</EnsembleFigure>")) {
                ensembleFigure.setIdFig(bufferedReader.readLine());
                break;
            }
            switch (str) {
                case "<Point>":
                    ensembleFigure.add(new Point(readDouble(bufferedReader), readDouble(bufferedReader), bufferedReader.readLine()));
                    break;

                case "<Segment>":
                    ensembleFigure.add(new Segment(readPoint(bufferedReader), readPoint(bufferedReader), bufferedReader.readLine()));
                    break;
                case "<Cercle>":
                    ensembleFigure.add(new Cercle(readPoint(bufferedReader), readDouble(bufferedReader), bufferedReader.readLine()));
                    break;
                case "<Triangle>":
                    ensembleFigure.add(new Triangle(readPoint(bufferedReader), readPoint(bufferedReader), readPoint(bufferedReader), bufferedReader.readLine()));
                    break;
                case "<Polygone>":
                    int size = readInt(bufferedReader);
                    ArrayList<Point> listP = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        listP.add(readPoint(bufferedReader));
                    }
                    ensembleFigure.add(new Polygone(listP, bufferedReader.readLine()));
                    break;
                case "<Polyligne>":
                    size = readInt(bufferedReader);
                    listP = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        listP.add(readPoint(bufferedReader));
                    }
                    ensembleFigure.add(new Polyligne(listP, bufferedReader.readLine()));
                    break;

                case "<EnsembleFigure>":
                    ensembleFigure.add(readEnsembleFigure(bufferedReader));
                    break;
                default:
                    throw new Error("Fichier illisible ou corrompu ou pas au bon format");
            }

        }
        return ensembleFigure;
    }

    public static EnsembleFigure readFile(String repertory) throws IOException {//Retourne un fichier sous forme d'ensembleFigure
        FileReader fileReader = new FileReader(repertory);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        if (!bufferedReader.readLine().equals("<EnsembleFigure>")) {
            throw new Error("Le fichier doit commencer par <EnsembleFigure>");
        } else {
            return readEnsembleFigure(bufferedReader);
        }
    }

    public static void writeFile(EnsembleFigure ensembleFigure, String repertory) throws IOException {//Convertit un Ensemble figure en un fichier txt
        FileWriter fileWriter = new FileWriter(repertory);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = ensembleFigure.toTxt();
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
}


