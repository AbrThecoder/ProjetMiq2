/*
 * Created by JFormDesigner on Wed Dec 12 10:12:18 CET 2018
 */

package fr.insa.damien;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MenuEvent;

import net.miginfocom.swing.*;

/**
 * @author DamienCM
 */
public class EbaucheV1 extends JFrame {
    public EbaucheV1() {
        initComponents();
    }

    String ajoutFigure = "";
    ArrayList<Point> pointArrayList = new ArrayList<>();
    EnsembleFigure ensembleFigure = new EnsembleFigure();

    private void NouveauActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void OuvrirActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void EnregistrerActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void UndoActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void RedoActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ZoomPlusActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ZoomMoinsActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ZoomBoiteActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void AjouterPointActionPerformed(ActionEvent e) {
        ajoutFigure = "Point";
        pointArrayList.clear();
    }

    private void AjouterSegmentActionPerformed(ActionEvent e) {
        ajoutFigure = "Segment";
        pointArrayList.clear();
    }

    private void AjouterRectangleActionPerformed(ActionEvent e) {
        ajoutFigure = "Rectangle";
        pointArrayList.clear();
    }

    private void AjouterTriangleActionPerformed(ActionEvent e) {
        ajoutFigure = "Triangle";
        pointArrayList.clear();

    }

    private void AjouterCercleActionPerformed(ActionEvent e) {
        ajoutFigure = "Cercle";
        pointArrayList.clear();
    }

    private void AjouterPolygoneActionPerformed(ActionEvent e) {
        ajoutFigure = "Polygone";
        pointArrayList.clear();
    }

    private void AjouterPolyligneActionPerformed(ActionEvent e) {
        ajoutFigure = "Polyligne";
        pointArrayList.clear();
    }

    private void displayPanelMouseReleased(MouseEvent e) {
        switch (ajoutFigure) {
            case "Point":
                ensembleFigure.add(new Point(e.getX(), e.getY()));

                break;
            case "Segment":
                pointArrayList.add(new Point(e.getX(), e.getY()));
                if (pointArrayList.size() == 2) {
                    ensembleFigure.add(new Segment(pointArrayList.get(0), pointArrayList.get(1)));
                    pointArrayList.clear();
                }

                break;
            case "Rectangle":
                pointArrayList.add(new Point(e.getX(), e.getY()));
                if (pointArrayList.size() == 2) {
                    ensembleFigure.add(new Rectangle(pointArrayList.get(0), pointArrayList.get(1)));
                    pointArrayList.clear();
                }
                break;
            case "Triangle":
                pointArrayList.add(new Point(e.getX(), e.getY()));
                if (pointArrayList.size() == 3) {
                    ensembleFigure.add(new Triangle(pointArrayList.get(0), pointArrayList.get(1), pointArrayList.get(2)));
                    pointArrayList.clear();
                }
                break;
            case "Cercle":
                pointArrayList.add(new Point(e.getX(), e.getY()));
                if (pointArrayList.size() == 2) {
                    ensembleFigure.add(new Cercle(pointArrayList.get(0), pointArrayList.get(1)));
                    pointArrayList.clear();
                }
                break;
            case "Polygone":
                pointArrayList.add(new Point(e.getX(), e.getY()));
                break;
            case "Polyligne":
                break;
            default:
                return;

        }
        ensembleFigure.paint(displayPanel);

    }

    private void displayPanelKeyPressed(KeyEvent e) {

    }

    private void thisKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER && ajoutFigure.equals("Polygone")) {
            ensembleFigure.add(new Polygone(pointArrayList));
            pointArrayList.clear();
            System.out.println("abc");
        }
        ensembleFigure.paint(displayPanel);

    }

    private void AjouterActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void AjouterMenuDeselected(MenuEvent e) {
        ensembleFigure.paint(displayPanel);
        System.out.println("Menu deselectioné");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - DamienCM
        menuBar1 = new JMenuBar();
        Fichier = new JMenu();
        Nouveau = new JMenuItem();
        Ouvrir = new JMenuItem();
        Enregistrer = new JMenuItem();
        Edit = new JMenu();
        Undo = new JMenuItem();
        Redo = new JMenuItem();
        Zoom = new JMenu();
        ZoomPlus = new JMenuItem();
        ZoomMoins = new JMenuItem();
        ZoomBoite = new JMenuItem();
        Ajouter = new JMenu();
        AjouterPoint = new JMenuItem();
        AjouterSegment = new JMenuItem();
        AjouterRectangle = new JMenuItem();
        AjouterTriangle = new JMenuItem();
        AjouterCercle = new JMenuItem();
        AjouterPolygone = new JMenuItem();
        AjouterPolyligne = new JMenuItem();
        displayPanel = new JPanel();

        //======== this ========
        setTitle("graphique2D");
        setMinimumSize(new Dimension(1900, 1000));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                thisKeyPressed(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]",
            // rows
            "[]"));

        //======== menuBar1 ========
        {

            //======== Fichier ========
            {
                Fichier.setText("Fichier");

                //---- Nouveau ----
                Nouveau.setText("Nouveau");
                Nouveau.addActionListener(e -> {
			NouveauActionPerformed(e);
			NouveauActionPerformed(e);
		});
                Fichier.add(Nouveau);

                //---- Ouvrir ----
                Ouvrir.setText("Ouvrir");
                Ouvrir.addActionListener(e -> {
			OuvrirActionPerformed(e);
			OuvrirActionPerformed(e);
		});
                Fichier.add(Ouvrir);

                //---- Enregistrer ----
                Enregistrer.setText("Enregistrer");
                Enregistrer.addActionListener(e -> {
			EnregistrerActionPerformed(e);
			EnregistrerActionPerformed(e);
		});
                Fichier.add(Enregistrer);
            }
            menuBar1.add(Fichier);

            //======== Edit ========
            {
                Edit.setText("Edit");

                //---- Undo ----
                Undo.setText("Undo");
                Undo.addActionListener(e -> {
			UndoActionPerformed(e);
			UndoActionPerformed(e);
		});
                Edit.add(Undo);

                //---- Redo ----
                Redo.setText("Redo");
                Redo.addActionListener(e -> {
			RedoActionPerformed(e);
			RedoActionPerformed(e);
		});
                Edit.add(Redo);
            }
            menuBar1.add(Edit);

            //======== Zoom ========
            {
                Zoom.setText("Zoom");

                //---- ZoomPlus ----
                ZoomPlus.setText("Zoom +");
                ZoomPlus.addActionListener(e -> {
			ZoomPlusActionPerformed(e);
			ZoomPlusActionPerformed(e);
		});
                Zoom.add(ZoomPlus);

                //---- ZoomMoins ----
                ZoomMoins.setText("Zoom -");
                ZoomMoins.addActionListener(e -> {
			ZoomMoinsActionPerformed(e);
			ZoomMoinsActionPerformed(e);
		});
                Zoom.add(ZoomMoins);

                //---- ZoomBoite ----
                ZoomBoite.setText("Zoom Boite");
                ZoomBoite.addActionListener(e -> {
			ZoomBoiteActionPerformed(e);
			ZoomBoiteActionPerformed(e);
		});
                Zoom.add(ZoomBoite);
            }
            menuBar1.add(Zoom);

            //======== Ajouter ========
            {
                Ajouter.setText("Ajouter");

                //---- AjouterPoint ----
                AjouterPoint.setText("Point");
                AjouterPoint.addActionListener(e -> {
			AjouterPointActionPerformed(e);
			AjouterPointActionPerformed(e);
		});
                Ajouter.add(AjouterPoint);

                //---- AjouterSegment ----
                AjouterSegment.setText("Segment");
                AjouterSegment.addActionListener(e -> {
			AjouterSegmentActionPerformed(e);
			AjouterSegmentActionPerformed(e);
		});
                Ajouter.add(AjouterSegment);

                //---- AjouterRectangle ----
                AjouterRectangle.setText("Rectangle");
                AjouterRectangle.addActionListener(e -> {
			AjouterRectangleActionPerformed(e);
			AjouterRectangleActionPerformed(e);
		});
                Ajouter.add(AjouterRectangle);

                //---- AjouterTriangle ----
                AjouterTriangle.setText("Triangle");
                AjouterTriangle.addActionListener(e -> {
			AjouterTriangleActionPerformed(e);
			AjouterTriangleActionPerformed(e);
		});
                Ajouter.add(AjouterTriangle);

                //---- AjouterCercle ----
                AjouterCercle.setText("Cercle");
                AjouterCercle.addActionListener(e -> {
			AjouterCercleActionPerformed(e);
			AjouterCercleActionPerformed(e);
		});
                Ajouter.add(AjouterCercle);

                //---- AjouterPolygone ----
                AjouterPolygone.setText("Polygone");
                AjouterPolygone.addActionListener(e -> {
			AjouterPolygoneActionPerformed(e);
			AjouterPolygoneActionPerformed(e);
		});
                Ajouter.add(AjouterPolygone);

                //---- AjouterPolyligne ----
                AjouterPolyligne.setText("Polyligne");
                AjouterPolyligne.addActionListener(e -> {
			AjouterPolyligneActionPerformed(e);
			AjouterPolyligneActionPerformed(e);
		});
                Ajouter.add(AjouterPolyligne);
            }
            menuBar1.add(Ajouter);
        }
        setJMenuBar(menuBar1);

        //======== displayPanel ========
        {
            displayPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    displayPanelMouseReleased(e);
                }
            });

            // JFormDesigner evaluation mark
            displayPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), displayPanel.getBorder())); displayPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            displayPanel.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));
        }
        contentPane.add(displayPanel, "cell 0 0,dock center");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - DamienCM
    private JMenuBar menuBar1;
    private JMenu Fichier;
    private JMenuItem Nouveau;
    private JMenuItem Ouvrir;
    private JMenuItem Enregistrer;
    private JMenu Edit;
    private JMenuItem Undo;
    private JMenuItem Redo;
    private JMenu Zoom;
    private JMenuItem ZoomPlus;
    private JMenuItem ZoomMoins;
    private JMenuItem ZoomBoite;
    private JMenu Ajouter;
    private JMenuItem AjouterPoint;
    private JMenuItem AjouterSegment;
    private JMenuItem AjouterRectangle;
    private JMenuItem AjouterTriangle;
    private JMenuItem AjouterCercle;
    private JMenuItem AjouterPolygone;
    private JMenuItem AjouterPolyligne;
    private JPanel displayPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
