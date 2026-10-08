package model;

public class PerbaikanBerat extends LayananServis {
    private final String namaSparepart;
    private final double hargaSparepart;

    public PerbaikanBerat(String kodeServis, String platNomor, String namaPelanggan, double biayaJasa, String namaSparepart, double hargaSparepart) {
        super(kodeServis, platNomor, namaPelanggan, biayaJasa);
        if (hargaSparepart < 0) {
            throw new IllegalArgumentException("Harga sparepart ga boleh negatif.");
        }
        this.namaSparepart = namaSparepart;
        this.hargaSparepart = hargaSparepart;
    }

    public String getNamaSparepart() { return namaSparepart; }
    public double getHargaSparepart() { return hargaSparepart; }

    @Override
    public double hitungTotalBiaya() {
        return getBiayaJasa() + hargaSparepart;
    }

    @Override
    public String getKategoriServis() {
        return "Perbaikan Berat";
    }

    @Override
    public String getDetailLayanan() {
        return "Sparepart: " + namaSparepart + " (Rp " + hargaSparepart + ")";
    }
}