package fr.insa.damien;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            EbaucheV1 ebaucheV1 = new EbaucheV1();
            ebaucheV1.setVisible(true);
            ebaucheV1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });

    }






}
