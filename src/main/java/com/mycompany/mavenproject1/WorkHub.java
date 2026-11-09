/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkHub {
    private String namaWorkHub;
    
    // KOMPOSISI: Objek internal yang hidup-matinya bergantung pada WorkHub
    private LoungeUtama loungeUtama;
    
    // AGREGASI: Menampung objek utama dan objek pendukung
    private ArrayList<RuangKerja> daftarRuangan;
    private HashMap<String, Penyewa> dataPenyewa;

    // CONSTRUCTOR WORKHUB
    public WorkHub(String namaWorkHub) {
        this.namaWorkHub = namaWorkHub;
        
        // INSTANSIASI KOMPOSISI (Internal)
        this.loungeUtama = new LoungeUtama("Lounge Utama WorkHub", 50);
        
        // INISIALISASI WADAH AGREGASI
        this.daftarRuangan = new ArrayList<>();
        this.dataPenyewa = new HashMap<>();
    }

    public void bukaWorkHub() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaWorkHub + " ***");
        loungeUtama.bukaLounge();
    }

    // METHOD AGREGASI: RUANG KERJA
    public void tambahRuangan(RuangKerja r) {
        daftarRuangan.add(r);
        System.out.println("Sukses! Ruangan berhasil ditambahkan. (Total Ruangan: " + daftarRuangan.size() + ")");
    }

    public void lihatSemuaRuangan() {
        if (daftarRuangan.isEmpty()) {
            System.out.println("Belum ada ruangan yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarRuangan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarRuangan.get(i).tampilkanInfo();
        }
    }

    public void cariRuangan(String nama) throws RuanganTidakDitemukanException {
        System.out.println("Mencari Ruangan dengan Nama: " + nama);
        boolean ditemukan = false;
        for (RuangKerja r : daftarRuangan) {
            if (r.getNamaRuangan().equalsIgnoreCase(nama)) {
                r.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new RuanganTidakDitemukanException("Gagal: Ruangan dengan nama '" + nama + "' tidak terdaftar.");
        }
    }

    // METHOD AGREGASI: PENYEWA
    public void tambahPenyewa(Penyewa p) {
        dataPenyewa.put(p.getIdPenyewa(), p);
        System.out.println("Berhasil menambahkan penyewa!");
    }

    public void cariPenyewa(String id) {
        if (dataPenyewa.containsKey(id)) {
            System.out.println("Ditemukan! Nama: " + dataPenyewa.get(id).getNama());
        } else {
            System.out.println("Penyewa dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPenyewa() {
        System.out.println("Total Penyewa Terdaftar: " + dataPenyewa.size());
        for (Penyewa p : dataPenyewa.values()) {
            System.out.println("- ID: " + p.getIdPenyewa() + " | Nama: " + p.getNama());
        }
    }

    // GETTER BANTUAN UNTUK ASOSIASI DAN CLI
    public Penyewa getPenyewa(String id) { return dataPenyewa.get(id); }
    public RuangKerja getRuanganInt(int index) { return daftarRuangan.get(index); }
    public int getJumlahRuangan() { return daftarRuangan.size(); }
}
