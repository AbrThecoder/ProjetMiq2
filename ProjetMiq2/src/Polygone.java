import java.util.*; 
public class Polygone extends Figure {
    ArrayList<Point> lpoint=new ArrayList<>();
    
    public  Polygone(){
        System.out.println("id Polygone");
            super.idFigure=Lire.S();
        System.out.println("Pour Creer un polygone il vous faudra trois points min");
        System.out.println("Entrer le nombre de sommets désirés (minimum 3 points)");
        int n=Lire.i();
        for(int i=0;i<n;i++){
            System.out.println((i+1)+"ème point");
            Point p =new Point();
            this.lpoint.add(p);
        }
    }
    public ArrayList abscisses(int n){
        ArrayList<Double> ab=new ArrayList<>();
     for(int i=0;i<n;i++){
         ab.add(lpoint.get(i).abscisse);
     }
     return ab;
    }
    public ArrayList ordonnees(int n){
        ArrayList<Double> ord=new ArrayList<>();
     for(int i=0;i<n;i++){
         ord.add(lpoint.get(i).ordonnee);
     }
     return ord;
    }
    @Override
     public String toString(){
        String text= "(Polygone"+this.idFigure+","+"sommets: "+this.lpoint+")";
        return text;
    }
    @Override
        public  double distancePoint(Point p){
         return 1;     
        }
     
   @Override
 public double minX(){
     
     return (double) Collections.min(abscisses(this.lpoint.size()));
     }
    
    @Override
     public  double minY(){
         return (double) Collections.min(ordonnees(this.lpoint.size()));
     }
    @Override
     public  double maxX(){
         return (double) Collections.max(abscisses(this.lpoint.size()));
     }
    @Override
     public  double maxY(){
         return (double) Collections.max(ordonnees(this.lpoint.size()));
     }
     public static double perimetrePolygone(Polygone P){
         double p=0;
         for(int i=0;i<P.lpoint.size()-1;i++){
             p=p+(P.lpoint.get(i).distancePoint(P.lpoint.get(i+1)));
             
         }
         p=p+(P.lpoint.get(0).distancePoint(P.lpoint.get(P.lpoint.size()-1)));
      return p;
     }
        
 }
    
    
    
    

