/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 5: INHERITANCE (Subclass 1 menggunakan 'extends')
public class PrivateOffice extends RuangKerja {
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
}
