public class Cercle extends Figure{
    double rayon;
    Point centre;
    public Cercle(){
        System.out.println("id Cercle");
            super.idFigure=Lire.S();
        System.out.println("Le centre du cercle: ");
        this.centre = new Point();
        System.out.println("Le rayon du cercle: ");
        this.rayon = Lire.d();   
    }
    @Override
    public  double distancePoint(Point p){
        double dist=0;
        dist=this.rayon+this.centre.distancePoint(p);
         return dist;     
        }
    @Override
 public double minX(){
         return (this.centre.abscisse-this.rayon);
     }
    
    @Override
     public  double minY(){
         return this.centre.ordonnee-this.rayon;
     }
    @Override
     public  double maxX(){
         return this.centre.abscisse+this.rayon;
     }
    @Override
     public  double maxY(){
         return this.centre.ordonnee+this.rayon;
     }
    @Override
     public String toString(){
           String text= "(Cercle"+this.idFigure+","+"centre: "+this.centre+") ,"+"rayon: "+this.rayon+")";
        return text;
    }
    
}
