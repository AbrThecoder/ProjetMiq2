/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last_project_miq2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;


/**
 *
 * @author mouadabrini
 */
public class Fenetre extends javax.swing.JFrame {
    boolean b = false;
    String ajouteFigure = "";
    EnsembleFigure ensembleFigure = new EnsembleFigure();
    int test = 0;
    Point ptest = new Point(200, 200);
    private ArrayList<Point> pointArrayList = new ArrayList<>();
    private ArrayList<Point> pointArrayList1 = new ArrayList<>();
    private ArrayList<Segment> SegArr = new ArrayList<>();
    private ArrayList<Rectangle> RectArr = new ArrayList<>();
    private ArrayList<Cercle> CercArr = new ArrayList<>();
    private EnsembleFigure trseg = new EnsembleFigure();
    /**
     * Creates new form Fenetre
     */
    public Fenetre() {
        initComponents();
    }
public static int readInt(BufferedReader bufferedReader) throws IOException { // Convertit la ligne suivante et renvoie un entier
        return Integer.valueOf(bufferedReader.readLine());

    }

    public static int readInteger(BufferedReader bufferedReader) throws IOException {// Convertit la ligne suivante et renvoie un double
        String str = bufferedReader.readLine() ;
        return (int)((double)Double.valueOf(str));

    }

    public static Point readPoint(BufferedReader bufferedReader) throws IOException {//Convertit les 4 prochaines lignes en un point retourné
        bufferedReader.readLine();
        return new Point(readInteger(bufferedReader), readInteger(bufferedReader), bufferedReader.readLine());

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
                    ensembleFigure.add(new Point(readInteger(bufferedReader), readInteger(bufferedReader), bufferedReader.readLine()));
                    break;

                case "<Segment>":
                    ensembleFigure.add(new Segment(readPoint(bufferedReader), readPoint(bufferedReader), bufferedReader.readLine()));
                    break;
                case "<Cercle>":
                    ensembleFigure.add(new Cercle(readPoint(bufferedReader), readInteger(bufferedReader), bufferedReader.readLine()));
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

                case "<Rectangle>":
                    ensembleFigure.add(new Rectangle(readPoint(bufferedReader), readPoint(bufferedReader), bufferedReader.readLine()));
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
        EnsembleFigure ensembleFigure = new EnsembleFigure();
        while (true) {
            String str = bufferedReader.readLine();
            if (str == null)
                break;
                //throw new Error("Le fichier est fini sans finir un ensembleFigure");
            /*if (str.equals("</EnsembleFigure>")) {
                ensembleFigure.setIdFig(bufferedReader.readLine());
                break;
            }*/
            switch (str) {
                case "<Point>":
                    ensembleFigure.add(new Point(readInteger(bufferedReader), readInteger(bufferedReader), bufferedReader.readLine()));
                    break;

                case "<Segment>":
                    ensembleFigure.add(new Segment(readPoint(bufferedReader), readPoint(bufferedReader), bufferedReader.readLine()));
                    break;
                case "<Cercle>":
                    ensembleFigure.add(new Cercle(readPoint(bufferedReader), readInteger(bufferedReader), bufferedReader.readLine()));
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
    
    public static void writeFile(EnsembleFigure ensembleFigure, String repertory) throws IOException {//Convertit un Ensemble figure en un fichier txt
        FileWriter fileWriter = new FileWriter(repertory);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = ensembleFigure.toTxt(System.lineSeparator());
        System.out.println(str);
        bufferedWriter.write(str);
        bufferedWriter.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        quitter = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        enregistrer = new javax.swing.JMenuItem();
        enregistrer_sous = new javax.swing.JMenuItem();
        ouvrir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Point = new javax.swing.JMenuItem();
        segment = new javax.swing.JMenuItem();
        rectangle = new javax.swing.JMenuItem();
        triangle = new javax.swing.JMenuItem();
        cercle = new javax.swing.JMenuItem();
        polygone = new javax.swing.JMenuItem();
        polyligne = new javax.swing.JMenuItem();
        mode = new javax.swing.JMenu();
        click = new javax.swing.JRadioButtonMenuItem();
        revenir = new javax.swing.JMenu();
        arriere = new javax.swing.JMenuItem();
        effacer = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        zoomplus = new javax.swing.JMenuItem();
        zoommoins = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                displayPanelMouseMoved(evt);
            }
        });
        displayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                displayPanelMouseReleased(evt);
            }
        });
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        jMenuBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuBar1KeyPressed(evt);
            }
        });

        quitter.setText("Fichier");


        jMenuItem1.setText("Quitter");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });
        quitter.add(jMenuItem1);

        enregistrer.setText("Enregistrer");
        enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerActionPerformed();
            }
        });
        quitter.add(enregistrer);

        enregistrer_sous.setText("Enregistrer sous");
        enregistrer_sous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrer_sousActionPerformed();
            }
        });
        quitter.add(enregistrer_sous);
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        ouvrir.setText("Ouvrir");
        ouvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirActionPerformed();
            }
        });
        quitter.add(ouvrir);

        jMenuBar1.add(quitter);

        jMenu2.setText("Ajouter");

        Point.setText("Point");
        Point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PointActionPerformed(evt);
            }
        });
        jMenu2.add(Point);

        segment.setText("Segment");
        segment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segmentActionPerformed(evt);
            }
        });
        jMenu2.add(segment);

        rectangle.setText("Rectangle");
        rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleActionPerformed(evt);
            }
        });
        jMenu2.add(rectangle);

        triangle.setText("Triangle");
        triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleActionPerformed(evt);
            }
        });
        jMenu2.add(triangle);

        cercle.setText("Cercle");
        cercle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercleActionPerformed(evt);
            }
        });
        jMenu2.add(cercle);

        polygone.setText("Polygone");
        polygone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polygoneActionPerformed(evt);
            }
        });
        jMenu2.add(polygone);

        polyligne.setText("Polyligne");
        polyligne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polyligneActionPerformed(evt);
            }
        });
        jMenu2.add(polyligne);

        jMenuBar1.add(jMenu2);

        mode.setText("Mode interactif");

        click.setSelected(true);
        click.setText("Activé");
        mode.add(click);

        jMenuBar1.add(mode);

        revenir.setText("Revenir");

        arriere.setText("En arrière");
        arriere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arriereActionPerformed();
            }
        });
        revenir.add(arriere);

        effacer.setText("Effacer tout");
        effacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacerActionPerformed(evt);
            }
        });
        revenir.add(effacer);

        jMenuBar1.add(revenir);

        jMenu1.setText("zoom");

        zoomplus.setText("zoom +");
        zoomplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomplusActionPerformed(evt);
            }
        });
        jMenu1.add(zoomplus);

        zoommoins.setText("zoom -");
        zoommoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoommoinsActionPerformed(evt);
            }
        });
        jMenu1.add(zoommoins);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void enregistrer_sousActionPerformed() {//GEN-FIRST:event_enregistrer_sousActionPerformed
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jFileChooser.setDialogTitle("Choose a directory to save your file: ");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnValue = jFileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jFileChooser.getSelectedFile().isDirectory()) {
                try {
                    writeFile(ensembleFigure, jFileChooser.getSelectedFile().toString() + "\\Dessin2D.txt");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } else{

                try {
                    writeFile(ensembleFigure, jFileChooser.getSelectedFile().toString());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error");
                }

            }
            
        }
    }//GEN-LAST:event_enregistrer_sousActionPerformed

    private void segmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segmentActionPerformed
        if (!click.isSelected()) {
            
            JFrame frm=null;
            SegmentPanel segment_panel = new SegmentPanel(frm,true);
            segment_panel.setVisible(true);
            segment_panel.dispose();
            ensembleFigure.add(segment_panel.S);
        } 
        else {
            ajouteFigure = "Segment";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
        
    }//GEN-LAST:event_segmentActionPerformed

    private void polyligneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polyligneActionPerformed
        if (!click.isSelected()) {
            
            JFrame frm=null;
            CoordPolyl segment_panel = new CoordPolyl(frm,true);
            segment_panel.setVisible(true);
            segment_panel.dispose();
            ensembleFigure.add(segment_panel.p);
        } 
        else{
        ajouteFigure = "Polyligne";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
    }//GEN-LAST:event_polyligneActionPerformed

    private void triangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleActionPerformed
        if (!click.isSelected()) {
            JFrame frm = null;    
            CoordTr coord = new CoordTr(frm, true);
            coord.setVisible(true);        
            coord.dispose();
            ensembleFigure.add(coord.T);
        }
        else{
        ajouteFigure = "Triangle";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
       
    }//GEN-LAST:event_triangleActionPerformed

    private void enregistrerActionPerformed() {//GEN-FIRST:event_enregistrerActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();

        try {
            String path = System.getProperty("user.dir") + "\\FichiersSauvegardes\\Dessin2D_" + dateFormat.format(date) + ".txt";
            System.out.println(path);
            writeFile(ensembleFigure, path);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");

        }
    }//GEN-LAST:event_enregistrerActionPerformed

    private void PointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PointActionPerformed
        if (!click.isSelected()) {
            JFrame frm = null;    // to fool compiler to allow null as first arg
            CoordPoint coord = new CoordPoint(frm, true);
            coord.setVisible(true);           
            coord.dispose();
            ensembleFigure.add(coord.p);
        } 
        else {
            ajouteFigure = "Point";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
       
    }//GEN-LAST:event_PointActionPerformed

    private void rectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleActionPerformed
        if (!click.isSelected()) {
            JFrame frm = null;    
            CoordRect coord = new CoordRect(frm, true);
            coord.setVisible(true);        
            coord.dispose();
            ensembleFigure.add(coord.R);
        }
        else{
        ajouteFigure = "Rectangle";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
    }//GEN-LAST:event_rectangleActionPerformed

    private void cercleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercleActionPerformed
        if (!click.isSelected()) {
            JFrame frm = null;    
            CoordCercle coord = new CoordCercle(frm, true);
            coord.setVisible(true);        
            coord.dispose();
            ensembleFigure.add(coord.c);
        }
        else{
        ajouteFigure = "Cercle";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
    }//GEN-LAST:event_cercleActionPerformed

    private void polygoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polygoneActionPerformed
        if (!click.isSelected()) {
            JFrame frm = null;    
            CoordPolyg coord = new CoordPolyg(frm, true);
            coord.setVisible(true);        
            coord.dispose();
            ensembleFigure.add(coord.p);
        }
        else{
        ajouteFigure = "Polygone";
        }
        ensembleFigure.paint(displayPanel);
        pointArrayList.clear();
    }//GEN-LAST:event_polygoneActionPerformed

    private void displayPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayPanelMouseReleased
         if (click.isSelected()) {

            switch (ajouteFigure) {
                case "Point":
                    ensembleFigure.add(new Point(evt.getX(), evt.getY()));
                    ensembleFigure.paint(displayPanel);
                    break;
                case "Segment":
                    Point p = new Point(evt.getX(), evt.getY());
                    pointArrayList1.add(p);


                    break;
                case "Rectangle":
                    pointArrayList1.add(new Point(evt.getX(), evt.getY()));
                    if (pointArrayList.size() == 2) {
                        ensembleFigure.add(new Rectangle(pointArrayList.get(0), pointArrayList.get(1)));
                        pointArrayList.clear();
                    }
                    break;
                case "Triangle":
                    pointArrayList.add(new Point(evt.getX(), evt.getY()));
                    if (pointArrayList.size() == 3) {
                        ensembleFigure.add(new Triangle(pointArrayList.get(0), pointArrayList.get(1), pointArrayList.get(2)));
                        pointArrayList.clear();
                    }
                    break;
                case "Cercle":
                    pointArrayList1.add(new Point(evt.getX(), evt.getY()));
                    if (pointArrayList.size() == 2) {
                        ensembleFigure.add(new Cercle(pointArrayList.get(0), pointArrayList.get(1)));
                        pointArrayList.clear();
                    }
                    break;
                case "Polygone":
                    pointArrayList.add(new Point(evt.getX(), evt.getY()));
                    break;
                case "Polyligne":
                    pointArrayList.add(new Point(evt.getX(), evt.getY()));
                    break;

                case "zoom+":
                    ensembleFigure.translater(new Point(evt.getX(),evt.getY()));
                    ensembleFigure.zoom(2.5f);
                    ensembleFigure.translater(new Point(-evt.getX(),-evt.getY()));
                    Graphics graphics =displayPanel.getGraphics();
                    Graphics2D graphics2D = (Graphics2D)graphics;
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.fillRect(0,0,1920,1080);
                    break;
                case "zoom-":
                    ensembleFigure.translater(new Point(evt.getX(),evt.getY()));
                    ensembleFigure.zoom(0.4f);
                    ensembleFigure.translater(new Point(-evt.getX(),-evt.getY()));
                    graphics =displayPanel.getGraphics();
                    graphics2D = (Graphics2D)graphics;
                    graphics2D.setColor(Color.WHITE);
                    graphics2D.fillRect(0,0,1920,1080);
                    break;

                default:
                    return;

            }
        }
        ensembleFigure.paint(displayPanel);

    }//GEN-LAST:event_displayPanelMouseReleased

    private void displayPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayPanelMouseMoved
        if (click.isSelected()) {
            switch (ajouteFigure) {
                case "Segment":
                    if (pointArrayList1.size() == 2) {
                        Segment s1 = new Segment(pointArrayList1.get(0), pointArrayList1.get(1));
                        s1.paint(displayPanel);
                        ensembleFigure.add(s1);
                        pointArrayList1.clear();
                    }
                    if (pointArrayList1.size() == 1) {
                        Graphics graphics2D = displayPanel.getGraphics();
                        graphics2D.setColor(Color.WHITE);
                        Point p = new Point(evt.getX(), evt.getY());
                        Segment s = new Segment(pointArrayList1.get(0), p);
                        SegArr.add(s);
                        SegArr.get(0).depaint(displayPanel);
                        s.paint(displayPanel);
                        if (SegArr.size() == 2) {
                            SegArr.remove(0);
                        }
                    }

                    break;

                case "Rectangle":
                    if (pointArrayList1.size() == 2) {
                        Rectangle r = new Rectangle(pointArrayList1.get(0), pointArrayList1.get(1));
                        r.paint(displayPanel);
                        ensembleFigure.add(r);
                        pointArrayList1.clear();
                    }

                    if (pointArrayList1.size() == 1) {
                        Point p = new Point(evt.getX(), evt.getY());
                        Rectangle r1 = new Rectangle(pointArrayList1.get(0), p);
                        RectArr.add(r1);
                        RectArr.get(0).depaint(displayPanel);
                        r1.paint(displayPanel);
                        if (RectArr.size() == 2) {
                            RectArr.remove(0);
                        }
                    }
                    break;
                case "Cercle":
                    if (pointArrayList1.size() == 2) {
                        Cercle c = new Cercle(pointArrayList1.get(0), pointArrayList1.get(1));
                        c.paint(displayPanel);
                        ensembleFigure.add(c);
                        pointArrayList1.clear();
                    }
                    if (pointArrayList1.size() == 1) {
                        Point p = new Point(evt.getX(), evt.getY());
                        Cercle c1 = new Cercle(pointArrayList1.get(0), p);
                        CercArr.add(c1);
                        CercArr.get(0).depaint(displayPanel);
                        c1.paint(displayPanel);
                        if (CercArr.size() == 2) {
                            CercArr.remove(0);
                        }

                    }
                    break;
            }
        }
        ensembleFigure.paint(displayPanel);
    }//GEN-LAST:event_displayPanelMouseMoved

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        int a=JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment quitter");
        if(a==JOptionPane.YES_OPTION){
            this.dispose();
        }

    }//GEN-LAST:event_quitterActionPerformed

    private void ouvrirActionPerformed() {//GEN-FIRST:event_ouvrirActionPerformed
       JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jFileChooser.setDialogTitle("Choose a directory to open your file: ");
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnValue = jFileChooser.showOpenDialog(null);

        if (jFileChooser.getSelectedFile().isFile()){
            try {
                ensembleFigure = readFile(jFileChooser.getSelectedFile().toString());
                ensembleFigure.paint(displayPanel);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Error");

        }
    }//GEN-LAST:event_ouvrirActionPerformed

    private void arriereActionPerformed() {//GEN-FIRST:event_arriereActionPerformed
        ensembleFigure.remove(ensembleFigure.size()-1);
        displayPanel.paint(displayPanel.getGraphics());
        ensembleFigure.paint(displayPanel);
    }//GEN-LAST:event_arriereActionPerformed

    private void displayPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayPanelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ajouteFigure.equals("Polygone")) {
            ensembleFigure.add(new Polygone(pointArrayList));
            pointArrayList.clear();

        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ajouteFigure.equals("Polyligne")) {
            ensembleFigure.add(new Polyligne(pointArrayList));
            pointArrayList.clear();

        }
        ensembleFigure.paint(displayPanel);

        if (evt.getKeyCode() == KeyEvent.VK_S && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
            //^S
            enregistrerActionPerformed();
           
        }
        if ((evt.getKeyCode() == KeyEvent.VK_S) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) && ((evt.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            // ^+S
            enregistrer_sousActionPerformed();


        }

        if (evt.getKeyCode() == KeyEvent.VK_Z && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
            //^Z
          arriereActionPerformed();
        }

        if (evt.getKeyCode() == KeyEvent.VK_O && (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
            //^O-
            ouvrirActionPerformed();
        }
    }//GEN-LAST:event_displayPanelKeyPressed

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuBar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1KeyPressed

    private void effacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacerActionPerformed
        ensembleFigure.clear();
        displayPanel.paint(displayPanel.getGraphics());
        ensembleFigure.paint(displayPanel);
    }//GEN-LAST:event_effacerActionPerformed

    private void zoomplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomplusActionPerformed
        // TODO add your handling code here:
        ajouteFigure="zoom+";
    }//GEN-LAST:event_zoomplusActionPerformed

    private void zoommoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoommoinsActionPerformed
        // TODO add your handling code here:
        ajouteFigure="zoom-";

    }//GEN-LAST:event_zoommoinsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Point;
    private javax.swing.JMenuItem arriere;
    private javax.swing.JMenuItem cercle;
    private javax.swing.JRadioButtonMenuItem click;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JMenuItem effacer;
    private javax.swing.JMenuItem enregistrer;
    private javax.swing.JMenuItem enregistrer_sous;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu mode;
    private javax.swing.JMenuItem ouvrir;
    private javax.swing.JMenuItem polygone;
    private javax.swing.JMenuItem polyligne;
    private javax.swing.JMenu quitter;
    private javax.swing.JMenuItem rectangle;
    private javax.swing.JMenu revenir;
    private javax.swing.JMenuItem segment;
    private javax.swing.JMenuItem triangle;
    private javax.swing.JMenuItem zoommoins;
    private javax.swing.JMenuItem zoomplus;
    // End of variables declaration//GEN-END:variables

   
}
