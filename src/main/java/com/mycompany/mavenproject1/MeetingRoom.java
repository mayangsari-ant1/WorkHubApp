/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 5: INHERITANCE (Subclass 2 menggunakan 'extends')
public class MeetingRoom extends RuangKerja {
    // MODUL 4: Encapsulation
    private int kapasitasProyektor; 

    // MODUL 5: KEYWORD SUPER pada Constructor
    public MeetingRoom(String namaRuangan, String kodeRuang, double hargaSewaPerJam, int kapasitasProyektor) {
        super(namaRuangan, kodeRuang, hargaSewaPerJam);
        this.kapasitasProyektor = kapasitasProyektor;
    }

    public int getKapasitasProyektor() {
        return this.kapasitasProyektor;
    }

    public void setKapasitasProyektor(int kapasitasProyektor) {
        if (kapasitasProyektor > 0) {
            this.kapasitasProyektor = kapasitasProyektor;
        }
    }

    // MODUL 5: METHOD OVERRIDING (@Override)
    @Override
    public void tampilkanInfo() {
        System.out.printf("[MEETING]   Kode: %-6s | Nama: %-22s | Harga/Jam: Rp%-10.2f | Kapasitas: %d Orang%n",
                          getKodeRuang(), getNamaRuangan(), getHargaSewaPerJam(), this.kapasitasProyektor);
    }

    @Override
    public void aturanPenggunaan() {
        System.out.println("-> Fasilitas: Dilengkapi proyektor 4K, smart TV, dan sound system perapatan.");
    }
    
    // MODUL 6: OVERRIDING METHOD SIMULASI ATURAN
    @Override
    public void simulasiAturan() {
        System.out.println("-> [Simulasi Meeting Room]: Wajib reservasi H-1 jam, dilengkapi Proyektor 4K & Whiteboard.");
    }
}