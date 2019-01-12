/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last_project_miq2;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class fen_princ extends javax.swing.JFrame {
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
    // Variables declaration - do not modify
    private javax.swing.JMenu Ajouter;
    private javax.swing.JMenuItem Cercle;
    private javax.swing.JMenuItem Point;
    private javax.swing.JMenuItem Polygone;
    private javax.swing.JMenuItem Polyligne;
    private javax.swing.JMenuItem Rectangle;
    private javax.swing.JMenuItem Segment;
    private javax.swing.JMenuItem Triangle;
    private javax.swing.JMenuItem arriere;
    private javax.swing.JMenuItem avant;
    private javax.swing.JRadioButtonMenuItem click;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JMenuItem enregistrer;
    private javax.swing.JMenuItem enregistrer_sous;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem ouvrir;
    private javax.swing.JMenuItem quitter;

    public fen_princ() {
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
            java.util.logging.Logger.getLogger(fen_princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fen_princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fen_princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fen_princ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fen_princ mafenetre = new fen_princ();
                mafenetre.setVisible(true);
                mafenetre.setTitle("Graphique2D");
                mafenetre.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        mafenetre.thisKeyPressed(e);
                    }
                });
            }
        });
    }

    public void ensembleFigureAdd(double X, double Y, String ID) {
        this.ensembleFigure.add(new Point(X, Y, ID));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        displayPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        quitter = new javax.swing.JMenuItem();
        enregistrer = new javax.swing.JMenuItem();
        ouvrir = new javax.swing.JMenuItem();
        enregistrer_sous = new javax.swing.JMenuItem();
        Ajouter = new javax.swing.JMenu();
        click = new javax.swing.JRadioButtonMenuItem();
        Point = new javax.swing.JMenuItem();
        Segment = new javax.swing.JMenuItem();
        Rectangle = new javax.swing.JMenuItem();
        Triangle = new javax.swing.JMenuItem();
        Cercle = new javax.swing.JMenuItem();
        Polygone = new javax.swing.JMenuItem();
        Polyligne = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        arriere = new javax.swing.JMenuItem();
        avant = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                displayPanelMouseDragged(evt);
            }

            public void mouseMoved(java.awt.event.MouseEvent evt) {
                displayPanelMouseMoved(evt);
            }
        });
        displayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayPanelMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                displayPanelMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                displayPanelMouseReleased(evt);
            }
        });
        displayPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
                displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1900, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
                displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1000, Short.MAX_VALUE)
        );

        jMenuBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuBar1KeyPressed(evt);
            }
        });

        jMenu1.setText("Fichier");

        quitter.setText("Quitter");
        jMenu1.add(quitter);

        enregistrer.setText("Enregistrer");
        enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerActionPerformed();
            }
        });
        jMenu1.add(enregistrer);

        ouvrir.setText("Ouvrir");
        ouvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirActionPerformed(evt);
            }
        });
        jMenu1.add(ouvrir);

        enregistrer_sous.setText("Enregistrer sous");
        enregistrer_sous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrer_sousActionPerformed();
            }
        });
        enregistrer_sous.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enregistrer_sousKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                enregistrer_sousKeyReleased(evt);
            }
        });
        jMenu1.add(enregistrer_sous);

        jMenuBar1.add(jMenu1);

        Ajouter.setText("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        click.setSelected(true);
        click.setText("click");
        Ajouter.add(click);

        Point.setText("Point");
        Point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PointActionPerformed(evt);
            }
        });
        Ajouter.add(Point);

        Segment.setText("Segment");
        Segment.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SegmentMouseMoved(evt);
            }
        });
        Segment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegmentActionPerformed(evt);
            }
        });
        Ajouter.add(Segment);

        Rectangle.setText("Rectangle");
        Rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RectangleActionPerformed(evt);
            }
        });
        Ajouter.add(Rectangle);

        Triangle.setText("Triangle");
        Triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TriangleActionPerformed(evt);
            }
        });
        Ajouter.add(Triangle);

        Cercle.setText("Cercle");
        Cercle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CercleActionPerformed(evt);
            }
        });
        Ajouter.add(Cercle);

        Polygone.setText("Polygone");
        Polygone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PolygoneActionPerformed(evt);
            }
        });
        Ajouter.add(Polygone);

        Polyligne.setText("Polyligne");
        Polyligne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PolyligneActionPerformed(evt);
            }
        });
        Ajouter.add(Polyligne);

        jMenuBar1.add(Ajouter);

        jMenu2.setText("Revenir");

        arriere.setText("En arrière (ctrl+z)");
        arriere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arriereActionPerformed();
            }
        });
        arriere.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                arriereKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                arriereKeyReleased(evt);
            }
        });
        jMenu2.add(arriere);

        avant.setText("En avant");
        avant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avantActionPerformed(evt);
            }
        });
        jMenu2.add(avant);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void PointActionPerformed(java.awt.event.ActionEvent evt) {

        if (!click.isSelected()) {
            JFrame frm = null;    // to fool compiler to allow null as first arg
            COORD coord = new COORD(frm, true);
            coord.setVisible(true);            // waits here until user closes window
            System.out.println("after jd");
            coord.dispose();
            ensembleFigure.add(coord.p);


        } else {
            ajouteFigure = "Point";
        }

        pointArrayList.clear();
        System.out.println(ensembleFigure.getAll());

    }

    private void CercleActionPerformed(java.awt.event.ActionEvent evt) {
        ajouteFigure = "Cercle";
        pointArrayList.clear();
    }

    private void displayPanelMouseReleased(java.awt.event.MouseEvent evt) {

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
                default:
                    return;

            }
        }
        ensembleFigure.paint(displayPanel);


    }

    private void TriangleActionPerformed(java.awt.event.ActionEvent evt) {
        ajouteFigure = "Triangle";
        pointArrayList.clear();
    }

    private void SegmentActionPerformed(java.awt.event.ActionEvent evt) {


        if (!click.isSelected()) {
            pointArrayList.clear();
            Segment_Panel segment_panel = new Segment_Panel();
            segment_panel.setVisible(true);
            ensembleFigure.add(segment_panel.S);
        } else {
            ajouteFigure = "Segment";
        }
        System.out.println(ensembleFigure.getAll());

    }

    private void RectangleActionPerformed(java.awt.event.ActionEvent evt) {
        ajouteFigure = "Rectangle";
        pointArrayList.clear();
    }

    private void PolygoneActionPerformed(java.awt.event.ActionEvent evt) {
        ajouteFigure = "Polygone";
        pointArrayList.clear();

    }

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {

    }

    private void displayPanelKeyPressed(java.awt.event.KeyEvent evt) {

    }

    private void PolyligneActionPerformed(java.awt.event.ActionEvent evt) {
        ajouteFigure = "Polyligne";
        pointArrayList.clear();
    }

    private void displayPanelMouseMoved(java.awt.event.MouseEvent evt) {
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

    }

    private void SegmentMouseMoved(java.awt.event.MouseEvent evt) {

    }

    private void displayPanelMouseDragged(java.awt.event.MouseEvent evt) {

    }

    private void displayPanelMousePressed(java.awt.event.MouseEvent evt) {

    }

    private void displayPanelMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void enregistrerActionPerformed() {

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

    }

    private void ouvrirActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void arriereActionPerformed() {
        ensembleFigure.remove(ensembleFigure.size()-1);
        displayPanel.paint(displayPanel.getGraphics());
        ensembleFigure.paint(displayPanel);
    }

    private void avantActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void arriereKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void arriereKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void enregistrer_sousActionPerformed() {
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
            } else if (jFileChooser.getSelectedFile().isFile()){

                try {
                    writeFile(ensembleFigure, jFileChooser.getSelectedFile().toString());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error");
                }

            }
            else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }

    private void enregistrer_sousKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void enregistrer_sousKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void effacerActionPerformed(java.awt.event.ActionEvent evt){
        ensembleFigure.clear();
        displayPanel.paint(displayPanel.getGraphics());
        ensembleFigure.paint(displayPanel);
    }
    // End of variables declaration                   

    private void thisKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && ajouteFigure.equals("Polygone")) {
            ensembleFigure.add(new Polygone(pointArrayList));
            pointArrayList.clear();

        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && ajouteFigure.equals("Polyligne")) {
            ensembleFigure.add(new Polyligne(pointArrayList));
            pointArrayList.clear();

        }
        ensembleFigure.paint(displayPanel);

        if (e.getKeyCode() == KeyEvent.VK_S && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
            //^S
            enregistrerActionPerformed();
        }
        if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0) && ((e.getModifiers() & KeyEvent.SHIFT_MASK) != 0)) {
            // ^+S
            enregistrer_sousActionPerformed();

        }

        if (e.getKeyCode() == KeyEvent.VK_Z && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
            //^Z
            arriereActionPerformed();
        }

    }
}
