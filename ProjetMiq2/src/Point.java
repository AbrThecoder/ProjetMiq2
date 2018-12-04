






public  class Point extends Figure  {
    
    double abscisse,ordonnee;
    
    //constructeurs
    
    
    
   
    public Point(double x, double y)
    {
	
	this.abscisse = x;
	this.ordonnee = y;
        
    }
    
    
    public double getX()
    {
	return this.abscisse;
    }

 
    public double getY()
    {
	return this.ordonnee;
    }
     
    public void setX(double x)
    {
	this.abscisse = x;
    }

    
    public void setY(double y)
    {
	this.ordonnee = y;
    }
    
        public  Point(){ 
            System.out.println("id Point");
            super.idFigure=Lire.S();
            
            System.out.println("entrer abcisse : ");
            this.abscisse=Lire.d();
            
            System.out.println("entrer ordonnee : ");
            this.ordonnee=Lire.d();
            
            
            }
    
       
    
      @Override
 public double minX(){
         return this.abscisse;
     }
    
    @Override
     public  double minY(){
         return this.ordonnee;
     }
    @Override
     public  double maxX(){
         return this.abscisse;
     }
    @Override
     public  double maxY(){
         return this.ordonnee;
     }
       
    
    @Override
    public String toString(){
        String text= "(Point:"+this.idFigure+",abscisse:"+this.abscisse+",ordonnee:"+this.ordonnee+")";
                
        return text;
        
    }
    
    
   
    @Override
        public  double distancePoint(Point p){
         return Math.sqrt(Math.pow(p.ordonnee-this.ordonnee, 2)+Math.pow(p.abscisse-this.abscisse, 2));
         
         
        }

    
        
        



    
        
        
        
        }

