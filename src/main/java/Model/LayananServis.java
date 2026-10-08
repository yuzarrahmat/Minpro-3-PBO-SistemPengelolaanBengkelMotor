package model;

import service.LayananBengkel;

public abstract class LayananServis implements LayananBengkel {
    private final String kodeServis;
    private final String platNomor;
    private final String namaPelanggan;
    private double biayaJasa;

    public LayananServis(String kodeServis, String platNomor, String namaPelanggan, double biayaJasa) {
        this.kodeServis = kodeServis;
        this.platNomor = platNomor;
        this.namaPelanggan = namaPelanggan;
        setBiayaJasa(biayaJasa);
    }

    public String getKodeServis() { return kodeServis; }
    public String getPlatNomor() { return platNomor; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public double getBiayaJasa() { return biayaJasa; }

    public void setBiayaJasa(double biayaJasa) {
        if (biayaJasa < 0) {
            throw new IllegalArgumentException("Biaya jasa ga boleh negatif.");
        }
        this.biayaJasa = biayaJasa;
    }

    public abstract String getDetailLayanan();
}