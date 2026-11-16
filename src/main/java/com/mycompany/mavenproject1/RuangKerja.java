/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;

public abstract class RuangKerja implements Serializable {
    private static final long serialVersionUID = 1L;
    private String namaRuangan;
    private String kodeRuang;
    private double hargaSewaPerJam;

    public static int totalRuanganDibuat = 0;

    public RuangKerja(String namaRuangan, String kodeRuang, double hargaSewaPerJam) throws Exception {
        if (hargaSewaPerJam <= 0) {
            throw new Exception("Harga sewa per jam harus lebih besar dari 0!");
        }
        this.namaRuangan = namaRuangan;
        this.kodeRuang = kodeRuang;
        this.hargaSewaPerJam = hargaSewaPerJam;
        totalRuanganDibuat++;
    }

    public String getNamaRuangan() { return this.namaRuangan; }
    public void setNamaRuangan(String namaRuangan) { this.namaRuangan = namaRuangan; }
    public String getKodeRuang() { return this.kodeRuang; }
    public void setKodeRuang(String kodeRuang) { this.kodeRuang = kodeRuang; }
    public double getHargaSewaPerJam() { return this.hargaSewaPerJam; }

    public void setHargaSewaPerJam(double hargaSewaPerJam) {
        if (hargaSewaPerJam > 0) {
            this.hargaSewaPerJam = hargaSewaPerJam;
        } else {
            System.out.println("[PERINGATAN] Harga sewa per jam harus lebih besar dari 0!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Kode: %-6s | Nama: %-22s | Harga/Jam: Rp%.2f", 
                          this.kodeRuang, this.namaRuangan, this.hargaSewaPerJam);
    }

    public void aturanPenggunaan() {
        System.out.println("-> Aturan Umum: Dilarang merokok dan wajib menjaga kebersihan ruangan.");
    }

    public void simulasiAturan() {
        System.out.println("-> [Simulasi Aturan Umum]: Seluruh pengguna wajib mematuhi jam operasional WorkHub.");
    }

    public abstract void hitungDendaKeterlambatan();
}