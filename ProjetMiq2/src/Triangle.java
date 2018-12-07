
import java.util.ArrayList;
import java.util.Collections;


public class Triangle extends Figure{
    ArrayList<Point> lpoint=new ArrayList<>();
    
    public Triangle(){
        System.out.println("id Triangle");
        super.idFigure=Lire.S();
        System.out.println("Nous avons besoin de 3 points. Créons-les !");
        for(int i=0;i<3;i++){
            System.out.println((i+1)+"ème point");
            Point p =new Point();
            this.lpoint.add(p);
        }
        
     
}
    public ArrayList abscisses(){
        ArrayList<Double> ab=new ArrayList<>();
     for(int i=0;i<lpoint.size();i++){
         ab.add(lpoint.get(i).abscisse);
     }
     return ab;
    }
    public ArrayList ordonnees(){
        ArrayList<Double> ord=new ArrayList<>();
     for(int i=0;i<lpoint.size();i++){
         ord.add(lpoint.get(i).ordonnee);
     }
     return ord;
    }
    
    @Override
    public  double distancePoint(Point p){
         return 1;     
        }
    @Override
 public double minX(){
     
     return (double) Collections.min(abscisses());
     }
    
    @Override
     public  double minY(){
         return (double) Collections.min(ordonnees());
     }
    @Override
     public  double maxX(){
         return (double) Collections.max(abscisses());
     }
    @Override
     public  double maxY(){
         return (double) Collections.max(ordonnees());
     }
    @Override
     public String toString(){
           String text= "(Triangle:"+this.idFigure+","+"sommets: "+this.lpoint+")";
        return text;
    }
    
}
