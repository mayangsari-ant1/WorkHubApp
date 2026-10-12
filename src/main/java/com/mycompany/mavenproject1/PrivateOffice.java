/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 5, 6 & 7: MULTIPLE INTERFACE IMPLEMENTATION
public class PrivateOffice extends RuangKerja implements DapatDisewa, DapatDinilai {
    // MODUL 4: Encapsulation
    private int jumlahMeja;
    
    // MODUL 5: KEYWORD SUPER pada Constructor Subclass
    public PrivateOffice(String namaRuangan, String kodeRuang, double hargaSewaPerJam, int jumlahMeja) {
        super(namaRuangan, kodeRuang, hargaSewaPerJam); // Memanggil constructor Superclass
        this.jumlahMeja = jumlahMeja;
    }

    public int getJumlahMeja() {
        return this.jumlahMeja;
    }

    public void setJumlahMeja(int jumlahMeja) {
        if (jumlahMeja > 0) {
            this.jumlahMeja = jumlahMeja;
        }
    }

    // MODUL 5: METHOD OVERRIDING (@Override)
    @Override
    public void tampilkanInfo() {
        System.out.printf("[PRIVATE]   Kode: %-6s | Nama: %-22s | Harga/Jam: Rp%-10.2f | Kapasitas: %d Meja%n",
                          getKodeRuang(), getNamaRuangan(), getHargaSewaPerJam(), this.jumlahMeja);
    }

    @Override
    public void aturanPenggunaan() {
        System.out.println("-> Fasilitas: Akses keycard privat 24/7 dan mencakup meja kerja dedicated.");
    }
    
    // MODUL 6: OVERRIDING METHOD SIMULASI ATURAN
    @Override
    public void simulasiAturan() {
        System.out.println("-> [Simulasi Private Office]: Akses kartu kunci 24/7, Wi-Fi dedicated, dan penerimaan surat.");
    }
    // MODUL 7: OVERRIDING ABSTRACT METHOD DARI SUPERCLASS
    @Override
    public void hitungDendaKeterlambatan() {
        System.out.println("-> Aturan Denda: Rp 50.000 / jam overstay penggunaan office.");
    }
    // MODUL 7: OVERRIDING METHOD DARI INTERFACE DapatDisewa
    @Override
    public void prosesPenyewaanFisik() {
        System.out.println("-> [PROSES SEWA] Penyewa menandatangani kontrak bulanan & menerima smart keycard.");
    }
    // MODUL 7: OVERRIDING METHOD DARI INTERFACE DapatDinilai
    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [ULASAN SEWA] Private Office ini mendapat rating " + bintang + "/5 Bintang dari tenant.");
    }
}
