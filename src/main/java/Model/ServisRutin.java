package model;

public class ServisRutin extends LayananServis {
    private final String merkOli;
    private final double hargaOli;

    public ServisRutin(String kodeServis, String platNomor, String namaPelanggan, double biayaJasa, String merkOli, double hargaOli) {
        super(kodeServis, platNomor, namaPelanggan, biayaJasa);
        if (hargaOli < 0) {
            throw new IllegalArgumentException("Harga oli ga boleh negatif.");
        }
        this.merkOli = merkOli;
        this.hargaOli = hargaOli;
    }

    public String getMerkOli() { return merkOli; }
    public double getHargaOli() { return hargaOli; }

    @Override
    public double hitungTotalBiaya() {
        return getBiayaJasa() + hargaOli;
    }

    @Override
    public String getKategoriServis() {
        return "Servis Rutin + Ganti Oli";
    }

    @Override
    public String getDetailLayanan() {
        return "Oli: " + merkOli + " (Rp " + hargaOli + ")";
    }
}