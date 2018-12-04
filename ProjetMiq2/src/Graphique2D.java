


public class Graphique2D {

    
    public static void main(String[] args) {
       menu();
     }
    

    public static void menu(){
       /* ArrayList<Figure> lfigure=new ArrayList<>();
        ArrayList<Point> lpoint=new ArrayList<>();
        ArrayList<Segment> lsegment=new ArrayList<>();
       ArrayList<Polygone> lpolygone=new ArrayList<>();
        */
        boolean a=true;
        EnsembleFigure figures = new EnsembleFigure();
        System.out.println("Bonjour, je suis votre menu:");
        while(a){
            System.out.println("Que voulez vous faire?\n1-Créer une figure\n2-calcul des distances\n3-supprimer une figure\n4-"
                    + "Créer un sous ensemblefigure\n5-Sauvegarder l'ensemble des figures pour pouvoir les recréer après"
                    + "\n6-Lire et afficher le fichier et creer les figures correspondantes\n"
                    + "\n7-Supprimer à l'aide d'un identifiant\n8-quitter");
            
            int choix=Lire.i();
            if(choix==1){
               figures.ajouteFigure();
            }
            switch (choix) {
                case 2:
                    figures.AfficheFigure();
                    System.out.println("1-Distance entre un point et une figure\n2-Calcul de périmètre d'un polygone\n3-");
                    int c=Lire.i();
                    if(c==1){
                        Figure f=figures.choisirFigure();
                        System.out.println("Le point de votre choix:");
                        Point p =new Point();
                        
                        try{
                            System.out.println("La distance entre "+f+" et "+p+" est :"
                                    +f.distancePoint(p));
                        }
                        catch(IndexOutOfBoundsException e) {
                            System.out.println("l'index de la figure n'existe pas :( \n Ressayer? (n pour quitter; o pour ressayer)");
                            String choi=Lire.S();
                            if("n".equals(choi)){
                                System.out.println("Au revoir !");
                                System.exit(0);
                            }
                            else{
                                continue;
                            }
                            
                        }
                    }
                    else if(c==2){
                        figures.AfficheFigure();
                        Figure f=figures.choisirFigure();
                        System.out.println("Le périmètre de ce polygone est: "+Polygone.perimetrePolygone((Polygone) f));
                    }           break;
                case 3:
                    figures.AfficheFigure();
                    figures.supprimeFigure();
                    break;
                case 4:
                    System.out.println("Précisez le nombre de figures à tronquer :");
                    int n=Lire.i();
                    EnsembleFigure figures2=figures.SousEnsemble(n);
                    System.out.println("Voici le nouveaux sous ensemble:");
                    figures2.AfficheFigure();
                    System.out.println("il va etre stocker dans l'ensemble figure principal");
                    figures.lfigure.add(figures2);
                    break;
                case 5:
                    Figure f=figures.choisirFigure();
                    figures.EnregistreFigure(f);
                    figures.enregistreFigure(f);
                    System.out.println("Sauvegarde réussite");
                    break;
                case 6:
                     figures.afficheFigures();
                     System.out.println("Chargé avec succés, voici les figures enregistrées");
                     figures.AfficheFigure();
                    break;
                case 7:
                     figures.AfficheFigure();
                     figures.supprimebyID();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    break;
            }
            }
        /* 
        for (int i=0;i<lfigure.size();i++) {
            if("Point".equals(lfigure.get(i).getClass().getName())){
                lpoint.add((Point) lfigure.get(i));
            }
            else if("Segment".equals(lfigure.get(i).getClass().getName())){
                lsegment.add((Segment) lfigure.get(i));
            }
            else if("Polygone".equals(lfigure.get(i).getClass().getName())){
                lpolygone.add((Polygone) lfigure.get(i));
            }
            
        }
        System.out.println("liste des figures: "+lfigure+"\n"+"liste des points: "+lpoint+"\n"+"liste des segments: "
                +lsegment+"liste des polygones: "+lpolygone+"\n\n");
        */
        
        
        
        
        
        
        }
        
    }

    
   
  

    
    

   
    

