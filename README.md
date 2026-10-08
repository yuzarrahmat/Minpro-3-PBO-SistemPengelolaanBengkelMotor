# Minpro-3-PBO-SistemPengelolaanBengkelMotor

**Nama:** Yuzar Rahmat Rafi Alhaq  
**NIM:** 2509116025  
**Kelas:** Sistem Informasi A '2025  

---

## 1. Deskripsi Singkat Program
Sistem Pengelolaan Bengkel Motor adalah aplikasi berbasis *Command Line Interface* (CLI) Java yang dirancang untuk mengelola operasional servis kendaraan roda dua. Aplikasi ini memfasilitasi pencatatan antrean servis (Servis Rutin/Ganti Oli dan Perbaikan Berat), pembaruan biaya jasa, perhitungan total transaksi otomatis, serta cetak struk pembayaran. Seluruh arsitektur telah diperbarui menerapkan arsitektur **Model-View-Controller (MVC)**, **Abstraction**, **Polymorphism**, serta **Interface** sebagai Nilai Tambah.

---

## 2. Penjelasan Struktur Package
Proyek ini mengadopsi pola arsitektur **MVC** dengan pemisahan tanggung jawab yang jelas (*Separation of Concerns*):
* `model`: Berisi kelas entitas data utama (`LayananServis`, `ServisRutin`, `PerbaikanBerat`).
* `service`: Berisi kontrak antarmuka interface (`LayananBengkel`).
* `controller`: Mengelola logika bisnis, manipulasi antrean data, dan kalkulasi (`BengkelController`).
* `view`: Bertanggung jawab penuh atas tampilan antarmuka CLI (`BengkelView`).
* `util`: Modul bantu untuk menangani validasi masukan aman (`InputValidator`).
* `main`: Titik awal (*entry point*) eksekusi program (`Main`).

---

## 3. Penjelasan Alur Program
1. **Inisialisasi**: Kelas `Main` menginisialisasi `BengkelController`, menyiapkan data antrean awal (*dummy data*), lalu menjalankan `BengkelView`.
2. **Lihat Antrean** Menu 1 menampilkan daftar antrean kendaraan beserta rincian kategori dan kalkulasi biaya.
3. **Tambah Antrean**: Menu 2 (Servis Rutin) & Menu 3 (Perbaikan Berat) meminta data masukan yang secara otomatis divalidasi oleh `InputValidator` untuk membendung input kosong dan nominal negatif.
4. **Update Biaya Jasa**: Menu 4 memperbarui biaya jasa servis berdasarkan kode transaksi secara dinamis.
5. **Proses Selesai**: Menu 5 mencetak struk transaksi berbasis polymorphism, lalu menghapus data terkait dari antrean.

---

## 4. Penjelasan Penerapan Encapsulation dan Inheritance
* **Encapsulation**: Atribut kunci (`kodeServis`, `platNomor`, `namaPelanggan`) bersifat `private final` tanpa *setter* untuk menjaga integritas data imutabel (*dead code setter* telah dihapus). Atribut `biayaJasa` dikontrol oleh *setter* dengan logika validasi bernilai $\ge 0$.
* **Inheritance**: Abstract class `LayananServis` bertindak sebagai Superclass yang diwarisi oleh dua Subclass spesifik, yaitu `ServisRutin` dan `PerbaikanBerat` (`extends LayananServis`).

---

## 5. Penjelasan Penerapan Polymorphism dan Abstraction
* **Abstraction**: `LayananServis` diklasifikasikan sebagai `abstract class` yang memiliki `abstract method` `getDetailLayanan()`.
* **Polymorphism**: 
  - *Method Overriding*: Subclass `ServisRutin` dan `PerbaikanBerat` meng-override `hitungTotalBiaya()`, `getKategoriServis()`, dan `getDetailLayanan()`.
  - *Method Overloading*: `BengkelController` menerapkan overloading pada method `tambahServis(LayananServis s)` dan `tambahServis(LayananServis s, String catatanTeknisi)`.

---

## 6. Penjelasan Letak Penerapan Nilai Tambah (Interface)
* **Interface**: Terletak pada file `service/LayananBengkel.java`.
* **Deskripsi**: Menyediakan kontrak abstrak `hitungTotalBiaya()` dan `getKategoriServis()`. Diterapkan oleh abstract class `LayananServis` (`implements LayananBengkel`) dan diwujudkan kodenya secara spesifik pada subclass turunan.

---

## 7. Bukti Tangkapan Layar Pengujian Program

### 1. Menu Utama & Daftar Antrean Awal
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/332330ec-9566-4675-8233-6d3b2dfa7dba" />


### 2. Pendaftaran Servis Rutin & Ganti Oli
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/19ba18aa-cdf4-4357-8878-780982ddb4a6" />

### 3. Pendaftaran Perbaikan Berat
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/d5ba096e-f108-4bf2-bcd4-6e102c6474d6" />

### 4. Pembaruan Biaya Jasa
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/a796a076-c096-4193-a914-030a7dec516f" />

### 5. Selesai Servis & Struk Pembayaran
<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/59fa4448-3012-4b10-963a-e17da13a4594" />

### 6. Pengujian Validasi Input
<img width="326" height="219" alt="image" src="https://github.com/user-attachments/assets/67a8b0c5-68a8-4011-a65e-e9ed95bf3363" />

