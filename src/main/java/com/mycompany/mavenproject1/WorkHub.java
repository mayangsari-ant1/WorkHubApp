/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WorkHub {
    private String namaWorkHub;
    private LoungeUtama loungeUtama;
    private ArrayList<RuangKerja> daftarRuangan;
    private HashMap<String, Penyewa> dataPenyewa;

    public WorkHub(String namaWorkHub) {
        this.namaWorkHub = namaWorkHub;
        this.loungeUtama = new LoungeUtama("Lounge Utama WorkHub", 50);
        this.daftarRuangan = new ArrayList<>();
        this.dataPenyewa = new HashMap<>();
    }

    public void bukaWorkHub() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaWorkHub + " ***");
        loungeUtama.bukaLounge();
    }

    public void simpanDataKeFile() {
        try {
            FileOutputStream fileKeluar = new FileOutputStream("data_workhub.dat");
            ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar);

            mesinPembeku.writeObject(this.daftarRuangan);
            mesinPembeku.writeObject(this.dataPenyewa);

            mesinPembeku.close();
            System.out.println("-> [SYSTEM LOG] Seluruh data berhasil disimpan (Serialization) ke file data_workhub.dat!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public boolean muatDataDariFile() {
        try {
            File cekFile = new File("data_workhub.dat");
            if (!cekFile.exists()) return false;

            FileInputStream fileMasuk = new FileInputStream(cekFile);
            ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk);

            this.daftarRuangan = (ArrayList<RuangKerja>) mesinPembangkit.readObject();
            this.dataPenyewa = (HashMap<String, Penyewa>) mesinPembangkit.readObject();

            RuangKerja.totalRuanganDibuat = this.daftarRuangan.size();

            mesinPembangkit.close();
            System.out.println("-> [SYSTEM LOG] Data sistem berhasil dimuat ulang (Deserialization) dari penyimpanan!");
            return true;
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
            return false;
        }
    }

    public void bacaLogTransaksi() {
        System.out.println("\n--- Riwayat Log Transaksi WorkHub ---");
        try {
            File fileLog = new File("log_transaksi.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada catatan log transaksi.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membuka file log: " + e.getMessage());
        }
    }

    // METHOD AGREGASI
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

    public Penyewa getPenyewa(String id) { return dataPenyewa.get(id); }
    public RuangKerja getRuanganInt(int index) { return daftarRuangan.get(index); }
    public int getJumlahRuangan() { return daftarRuangan.size(); }
}