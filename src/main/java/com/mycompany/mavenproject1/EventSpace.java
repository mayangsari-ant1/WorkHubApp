/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 6: SUBCLASS BARU (EventSpace)
public class EventSpace extends RuangKerja {
    private boolean adaSoundSystem;

    public EventSpace(String namaRuangan, String kodeRuang, double hargaSewaPerJam, boolean adaSoundSystem) {
        super(namaRuangan, kodeRuang, hargaSewaPerJam);
        this.adaSoundSystem = adaSoundSystem;
    }

    public boolean isAdaSoundSystem() {
        return this.adaSoundSystem;
    }

    public void setAdaSoundSystem(boolean adaSoundSystem) {
        this.adaSoundSystem = adaSoundSystem;
    }

    @Override
    public void tampilkanInfo() {
        String fasilitasSound = adaSoundSystem ? "Include Sound System" : "Tanpa Sound System";
        System.out.printf("[EVENT]     Kode: %-6s | Nama: %-22s | Harga/Jam: Rp%-10.2f | Fasilitas: %s%n",
                          getKodeRuang(), getNamaRuangan(), getHargaSewaPerJam(), fasilitasSound);
    }

    @Override
    public void aturanPenggunaan() {
        System.out.println("-> Fasilitas: Area hall luas, panggung mini, dan pencahayaan khusus event.");
    }

    @Override
    public void simulasiAturan() {
        System.out.println("-> [Simulasi Event Space]: Acara maksimal hingga pukul 22.00 WIB, wajib DP 50% H-3 acara.");
    }
}