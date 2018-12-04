
import java.io.Serializable;





    public abstract class Figure implements Serializable  {
    String idFigure;
    double maxX,maxY,minX,minY;
    
    
    
    public  Figure(){
        
    }
   
      public abstract double distancePoint(Point p);  
      
      public abstract double minX();
      public abstract double minY();
      public abstract double maxX();
      public abstract double maxY();
    
}
