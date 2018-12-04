
public class Segment extends Figure {
    Point debut,fin;
    
    
  

 public Segment(Point debut, Point fin)
    {
	
	this.debut = debut;
	this.fin = fin;
        
    }

    @Override
    public String toString(){
        String text= "(Segment:"+super.idFigure+",origine:"+this.debut+",extrémité:"+this.fin+")";
        return text;
        
    }

    
 public  Segment(){
     System.out.println("id Segment");
     super.idFigure=Lire.S();
     this.debut=new Point();
     this.fin=new Point();
     
 }
     
    @Override
 public double minX(){
         return this.debut.abscisse;
     }
    
    @Override
     public  double minY(){
         return this.debut.ordonnee;
     }
    @Override
     public  double maxX(){
         return this.fin.abscisse;
     }
    @Override
     public  double maxY(){
         return this.fin.ordonnee;
     }
     
    @Override
 public  double distancePoint(Point p){
            double x1,x2,x3,x4,y1,y2,y3,y4,up,dist;
            dist=0;
            x1=this.debut.abscisse;
            x2=this.fin.abscisse;
            x3=p.abscisse;
            y1=this.debut.ordonnee;
            y2=this.fin.ordonnee;
            y3=p.ordonnee;
            
            
            up=((x3-x1)*(x2-x1)+(y3-y1)*(y2-y1))/(Math.pow(x2-x1, 2)+Math.pow(y2-y1,2));
            Point p4=new Point(x1+up*(x2-x1),y1+up*(y2-y1));   
            
            if(up<0){
                dist=p.distancePoint(this.fin);
            }
            
            else if(up>1){
                dist=p.distancePoint(this.debut);
            }
            else if(0<=up && up<=1){
                dist=p.distancePoint(p4);
            }
         return dist;
        }
}
