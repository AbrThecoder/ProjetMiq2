package last_project_miq2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class util {


    public static double min(ArrayList<Double> A) {
        double min = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < min)
                min = A.get(i);
        }
        return min;
    }

    public static double max(ArrayList<Double> A) {
        double max = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max)
                max = A.get(i);
        }
        return max;
    }

    public static double max(double[] D) {
        double M = D[0];
        for (int i = 0; i < D.length; i++) {
            if (D[i] > M)
                M = D[i];
        }
        return M;
    }

    public static double min(double[] D) {
        double M = D[0];
        for (int i = 0; i < D.length; i++) {
            if (D[i] > M)
                M = D[i];
        }
        return M;
    }

    public static double min(double A, double B) {
        if (A < B)
            return A;
        else
            return B;

    }

    public static double max(double A, double B) {
        if (A < B)
            return B;
        else
            return A;

    }
}


