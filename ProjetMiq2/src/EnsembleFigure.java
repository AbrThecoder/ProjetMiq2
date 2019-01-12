
/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
*/
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class EnsembleFigure  extends Figure implements Serializable {
    
    ArrayList<Figure> lfigure=new ArrayList<>();
    String idEnsemble;
    public void AfficheFigure(){
        System.out.println(this.lfigure);
    }
    public Figure choisirFigure(){
        this.AfficheFigure();
        System.out.println("index de la figure voulue");
        int n=Lire.i();
        return this.lfigure.get(n);
    }
    public void supprimeFigure(){
        System.out.println("index de la figure à supprimer");
        int n=Lire.i();
        this.lfigure.remove(n);
    }
    public void supprimebyindex(int n){
        this.lfigure.remove(n);
    }
    public void supprimebyID(){
        System.out.println("ID de la figure à supprimer");
        String id=Lire.S();
        for(int i=0;i<this.lfigure.size();i++){
            if(this.lfigure.get(i).idFigure.equals(id)){ 
                supprimebyindex(i);
            }
        }
        
    }
    public EnsembleFigure SousEnsemble(int n){
        EnsembleFigure figures1 =new EnsembleFigure();
                for(int i=0;i<n;i++){
                    System.out.println("index "+(i+1)+" :");
                    int p=Lire.i();
                    figures1.lfigure.add(this.lfigure.get(p));
                    this.lfigure.remove(p);
                }
        
        return figures1;
    }
    public void ajouteFigure(){
         Figure f = new Point(0,0);
        System.out.println("Selectionnez une figure\n1-Point\n2-Segment\n3-Polygone\n4-Triangle\n5-Cercle\n6-Polyligne");
        int choix=Lire.i();     
        switch (choix) {
            case 1:
                f =new Point();
                this.lfigure.add(f);
                break;
            case 2:
                f =new Segment();
                this.lfigure.add(f);
                break;
            case 3:
                f =new Polygone();
                this.lfigure.add(f);
                break;
            case 4:
                f =new Triangle();
                this.lfigure.add(f);
                break;
            case 5:
                f =new Cercle();
                this.lfigure.add(f);
                break;
            case 6:
                f =new Polyligne();
                this.lfigure.add(f);
                break;
            default:
                break;
        }
        
    }
    public void EnregistreFigure(Figure f) {

		try {

			FileOutputStream fileOut = new FileOutputStream("FichierFigures.txt");
			ObjectOutputStream objectout = new ObjectOutputStream(fileOut);
                        for(int i=0;i<this.lfigure.size();i++){
                          objectout.writeObject(this.lfigure.get(i)); 
                        }
			objectout.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    public void afficheFigures() {

		try {

			FileInputStream fi = new FileInputStream(new File("FichierFigures.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
                        while(fi.available()!=0){
                         Figure read=  (Figure) oi.readObject(); 
                         this.lfigure.add(read);
                        }
			oi.close();
                         Set<Figure> unique = new LinkedHashSet<>(this.lfigure);
                         this.lfigure.clear();
                         this.lfigure.addAll(unique);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    public void enregistreFigure(Figure f){
        try
       {    
       BufferedWriter fichierFigures=new BufferedWriter(new FileWriter("dessin.txt",true));
       String f1=f.toString();
       f1=f1.replace("Point:", "");
       f1=f1.replace("abscisse", "");
       f1=f1.replace("ordonnee", "");
       f1=f1.replace(':','-');
       f1=f1.replace("(", "");
       f1=f1.replace(")", "");
       f1=f1.replace(",","");
       fichierFigures.write(f1);
       fichierFigures.newLine();
       fichierFigures.close();
           System.out.println("enregistrée avec succés");
       } 
       catch (IOException err)
            {System.out.println ("Erreur :\n"+err);}
    }
   /* public void afficheFiguress(Figure f){
        try{
           BufferedReader lecture =new BufferedReader(new FileReader("dessin.txt"));
           String lignelue="";
           while(lignelue!=null){
           lignelue=lecture.readLine();
           if(lignelue==null){
               break;
           }
            System.out.println(lignelue);
           }
           lecture.close();
           
       }
       catch(IOException e){
           System.out.println("erreur: "+e);
           
       }
    }
    */
     


    @Override
    public double distancePoint(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double minX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double minY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double maxX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double maxY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

