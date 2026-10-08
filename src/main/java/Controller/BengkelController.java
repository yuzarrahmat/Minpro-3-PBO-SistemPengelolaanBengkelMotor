package controller;

import model.LayananServis;
import java.util.ArrayList;
import java.util.List;

public class BengkelController {
    private final List<LayananServis> daftarAntrean = new ArrayList<>();
    private int counterKode = 1;

    public String generateKodeServis() {
        return String.format("SRV-%03d", counterKode++);
    }

    public boolean tambahServis(LayananServis s) {
        return daftarAntrean.add(s);
    }

    public boolean tambahServis(LayananServis s, String catatanTeknisi) {
        boolean success = daftarAntrean.add(s);
        if (success) {
            System.out.println("[LOG TEKNISI]: " + catatanTeknisi);
        }
        return success;
    }

    public List<LayananServis> getAllAntrean() {
        return new ArrayList<>(daftarAntrean);
    }

    public LayananServis cariByKode(String kodeServis) {
        for (LayananServis s : daftarAntrean) {
            if (s.getKodeServis().equalsIgnoreCase(kodeServis)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateBiayaJasa(String kodeServis, double biayaJasaBaru) {
        LayananServis s = cariByKode(kodeServis);
        if (s != null) {
            s.setBiayaJasa(biayaJasaBaru);
            return true;
        }
        return false;
    }

    public boolean selesaikanServis(String kodeServis) {
        LayananServis s = cariByKode(kodeServis);
        if (s != null) {
            return daftarAntrean.remove(s);
        }
        return false;
    }
}