/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 5: INHERITANCE (Superclass Utama)
public class RuangKerja {
    // MODUL 4: ENCAPSULATION & ACCESS MODIFIER
    // Field di-private untuk melindungi data internal
    private String namaRuangan;
    private String kodeRuang;
    private double hargaSewaPerJam;

    // MODUL 4: KEYWORD STATIC
    public static int totalRuanganDibuat = 0;

    // MODUL 3 & 4: CONSTRUCTOR & KEYWORD 'THIS'
    public RuangKerja(String namaRuangan, String kodeRuang, double hargaSewaPerJam) {
        this.namaRuangan = namaRuangan;
        this.kodeRuang = kodeRuang;
        this.hargaSewaPerJam = hargaSewaPerJam;
        
        totalRuanganDibuat++;
    }

    // MODUL 4: GETTER & SETTER (dengan Validasi Data)
    public String getNamaRuangan() {
        return this.namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getKodeRuang() {
        return this.kodeRuang;
    }

    public void setKodeRuang(String kodeRuang) {
        this.kodeRuang = kodeRuang;
    }

    public double getHargaSewaPerJam() {
        return this.hargaSewaPerJam;
    }

    public void setHargaSewaPerJam(double hargaSewaPerJam) {
        if (hargaSewaPerJam > 0) {
            this.hargaSewaPerJam = hargaSewaPerJam;
        } else {
            System.out.println("[PERINGATAN] Harga sewa per jam harus lebih besar dari 0!");
        }
    }

    // MODUL 3 & 5: METHOD BASE (Akan di-override oleh Subclass)
    public void tampilkanInfo() {
        // MODUL 2: System.out.printf() untuk format output terstruktur
        System.out.printf("Kode: %-6s | Nama: %-22s | Harga/Jam: Rp%.2f", 
                          this.kodeRuang, this.namaRuangan, this.hargaSewaPerJam);
    }

    public void aturanPenggunaan() {
        System.out.println("-> Aturan Umum: Dilarang merokok dan wajib menjaga kebersihan ruangan.");
    }
    
    // MODUL 6: METHOD UNTUK DYNAMIC BINDING / RUNTIME POLYMORPHISM
    public void simulasiAturan() {
    System.out.println("-> [Simulasi Aturan Umum]: Seluruh pengguna wajib mematuhi jam operasional WorkHub.");
    }
}
    
