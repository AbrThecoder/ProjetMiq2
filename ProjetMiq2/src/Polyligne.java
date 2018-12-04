
import java.util.ArrayList;


public class Polyligne extends Figure {
    ArrayList<Segment> lsegment=new ArrayList<>();
    public Polyligne(){
        
        System.out.println("id Polyligne");
            super.idFigure=Lire.S();
        System.out.println("Pour Creer une polyligne il vous faudra 2 segments minimum");
        System.out.println("Entrer le nombre de segments désirés (minimum 2 segments)");
        int n=Lire.i();
        for(int i=0;i<n;i++){
            System.out.println((i+1)+"ème segment");
            Segment p =new Segment();
            this.lsegment.add(p);
        }
    
    }
    @Override
     public String toString(){
        String text= "(Polyligne:"+this.idFigure+","+"segments: "+this.lsegment+")";
        return text;
    }

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

