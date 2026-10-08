package com.mycompany.bengkelsystem.main;

import controller.BengkelController;
import model.PerbaikanBerat;
import model.ServisRutin;
import view.BengkelView;

public class Main {
    public static void main(String[] args) {
        BengkelController controller = new BengkelController();

        String k1 = controller.generateKodeServis();
        controller.tambahServis(new ServisRutin(k1, "KT 1234 AB", "Ryu", 30000, "Shell Advance 10W-40", 65000));

        String k2 = controller.generateKodeServis();
        controller.tambahServis(new PerbaikanBerat(k2, "KT 5678 CD", "Budi", 100000, "V-Belt & Roller CVT", 250000));

        BengkelView view = new BengkelView(controller);
        view.start();
    }
}