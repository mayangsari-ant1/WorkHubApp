/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 9: IMPORT LIBRARY COLLECTION FRAMEWORK & EXCEPTION
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkHubApp {

    // MODUL 9: DITAMBAHKAN ArrayList, throws, dan throw Custom Exception
    public static void cariRuangan(String nama, ArrayList<RuangKerja> daftar) throws RuanganTidakDitemukanException {
        System.out.println("\n[PENCARIAN] Berdasarkan Nama Ruangan: " + nama);
        boolean ditemukan = false;
        
        // Perulangan menggunakan daftar.size() dan daftar.get(i)
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNamaRuangan().equalsIgnoreCase(nama)) {
                System.out.print("Hasil Ditemukan -> ");
                daftar.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        
        // Menggunakan 'throw' Custom Exception jika tidak ditemukan
        if (!ditemukan) {
            throw new RuanganTidakDitemukanException("Gagal: Ruangan dengan nama '" + nama + "' tidak terdaftar di sistem WorkHub!");
        }
    }
    // MODUL 4: METHOD OVERLOADING (Metode 2 - Parameter Double)
    public static void cariRuangan(double maxHarga, RuangKerja[] daftar, int jumlah) {
        System.out.printf("%n[PENCARIAN] Berdasarkan Maksimal Harga Sewa/Jam: Rp%.2f%n", maxHarga);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHargaSewaPerJam() <= maxHarga) {
                System.out.print("Hasil Ditemukan -> ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada ruangan dengan harga di bawah Rp" + maxHarga);
        }
    }
    
    // MODUL 6: DYNAMIC BINDING & RUNTIME POLYMORPHISM (Parameter Tipe Superclass)
    public static void eksekusiSimulasi(RuangKerja r) {
        r.simulasiAturan();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // MODUL 9: KODE BARU (Mengganti Array biasa dengan ArrayList & HashMap)
        ArrayList<RuangKerja> daftarRuangan = new ArrayList<>();
        HashMap<String, String> dataPenyewa = new HashMap<>();

        // MODUL 9: DATA AWAL (Menggunakan method .add() dan .put())
        try {
            daftarRuangan.add(new PrivateOffice("Suite Executive A", "PO-01", 120000, 4));
            daftarRuangan.add(new PrivateOffice("Startup Pod B", "PO-02", 200000, 8));
            daftarRuangan.add(new MeetingRoom("Boardroom Alpha", "MR-01", 150000, 12));
            daftarRuangan.add(new MeetingRoom("Auditorium Mini", "MR-02", 350000, 30));
            daftarRuangan.add(new EventSpace("Grand Hall WorkHub", "ES-01", 750000, true));
        } catch (Exception e) {
            System.out.println("Gagal inisialisasi data awal: " + e.getMessage());
        }

        // Menambahkan data awal HashMap untuk Penyewa
        dataPenyewa.put("ID-001", "Budi Santoso");
        dataPenyewa.put("ID-002", "Siti Aminah");
        dataPenyewa.put("ID-003", "Rizky Pratama");

            boolean isRunning = true;

            System.out.println("==================================================");
            System.out.println("  SISTEM MANAJEMEN WORKHUB CO-WORKING SPACE (M2-M5)");
            System.out.println("==================================================");

            while (isRunning) {
            System.out.println("\n=== MENU UTAMA WORKHUB ===");
            System.out.println("1. Tambah Ruangan Baru (ArrayList)");
            System.out.println("2. Tampilkan Seluruh Data Ruangan");
            System.out.println("3. Cari Ruangan (Demo Custom Exception)");
            System.out.println("4. Kelola Data Penyewa (Demo HashMap)");
            System.out.println("5. Keluar Sistem");
            System.out.print("Pilih Menu (1-5): ");

            // MODUL 9: DIBUNGKUS BLOK TRY-CATCH UNTUK MENANGKAP ERROR INPUT SCANNER
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.println("\n-- PILIH TIPE RUANG KERJA --");
                        System.out.println("1. Private Office");
                        System.out.println("2. Meeting Room");
                        System.out.println("3. Event Space");
                        System.out.print("Pilihan Tipe (1/2/3): ");
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Kode Ruang     : ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Ruangan   : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Harga Sewa/Jam : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (tipe == 1) {
                            System.out.print("Masukkan Jumlah Meja Kerja: ");
                            int meja = scanner.nextInt();
                            scanner.nextLine();
                            daftarRuangan.add(new PrivateOffice(nama, kode, harga, meja));
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Kapasitas Orang: ");
                            int kap = scanner.nextInt();
                            scanner.nextLine();
                            daftarRuangan.add(new MeetingRoom(nama, kode, harga, kap));
                        } else if (tipe == 3) {
                            System.out.print("Apakah Ada Sound System? (true/false): ");
                            boolean sound = scanner.nextBoolean();
                            scanner.nextLine();
                            daftarRuangan.add(new EventSpace(nama, kode, harga, sound));
                        } else {
                            System.out.println("Tipe tidak valid! Penambahan dibatalkan.");
                        }

                        System.out.println("Sukses! Ruangan berhasil ditambahkan. (Total Ruangan: " + daftarRuangan.size() + ")");
                        break;

                    case 2:
                        System.out.println("\n-------------------------------------------------------------------------------------------");
                        System.out.println("                                DAFTAR RUANG KERJA WORKHUB                                  ");
                        System.out.println("-------------------------------------------------------------------------------------------");
                        
                        if (daftarRuangan.isEmpty()) {
                            System.out.println("Belum ada data ruangan yang terdaftar.");
                        } else {
                            for (int i = 0; i < daftarRuangan.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarRuangan.get(i).tampilkanInfo();
                                daftarRuangan.get(i).aturanPenggunaan();
                                eksekusiSimulasi(daftarRuangan.get(i));
                                daftarRuangan.get(i).hitungDendaKeterlambatan();

                                if (daftarRuangan.get(i) instanceof DapatDisewa) {
                                    DapatDisewa itemSewa = (DapatDisewa) daftarRuangan.get(i);
                                    itemSewa.prosesPenyewaanFisik();
                                }

                                if (daftarRuangan.get(i) instanceof DapatDinilai) {
                                    DapatDinilai itemRating = (DapatDinilai) daftarRuangan.get(i);
                                    itemRating.beriRating(5);
                                }

                                System.out.println();
                            }
                            System.out.println("===========================================================================================");
                            System.out.println("* Total Objek Ruangan Berhasil Dibuat (Static Counter): " + RuangKerja.totalRuanganDibuat);
                            System.out.println("===========================================================================================");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Ruangan (Demo Custom Exception) --");
                        System.out.print("Masukkan Nama Ruangan: ");
                        String kataKunci = scanner.nextLine();

                        // MODUL 9: TRY-CATCH-FINALLY UNTUK CUSTOM EXCEPTION
                        try {
                            cariRuangan(kataKunci, daftarRuangan);
                        } catch (RuanganTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> [FINALLY] Sesi pencarian ruangan selesai dieksekusi.");
                        }
                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Data Penyewa (Demo HashMap) --");
                        System.out.println("1. Tambah Penyewa Baru");
                        System.out.println("2. Cari Penyewa via ID");
                        System.out.println("3. Tampilkan Semua Penyewa");
                        System.out.print("Pilih (1-3): ");
                        int menuPenyewa = scanner.nextInt();
                        scanner.nextLine();

                        if (menuPenyewa == 1) {
                            System.out.print("Masukkan ID Penyewa (sebagai Key)  : ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String namaPenyewa = scanner.nextLine();

                            dataPenyewa.put(id, namaPenyewa);
                            System.out.println("-> [SUKSES] Berhasil menambahkan data penyewa!");
                        } else if (menuPenyewa == 2) {
                            System.out.print("Masukkan ID Penyewa yang dicari: ");
                            String searchId = scanner.nextLine();

                            if (dataPenyewa.containsKey(searchId)) {
                                System.out.println("-> [DITEMUKAN] Nama Penyewa: " + dataPenyewa.get(searchId));
                            } else {
                                System.out.println("-> [GAGAL] Penyewa dengan ID '" + searchId + "' tidak terdaftar.");
                            }
                        } else if (menuPenyewa == 3) {
                            System.out.println("\nTotal Penyewa Terdaftar: " + dataPenyewa.size());
                            for (String keyId : dataPenyewa.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataPenyewa.get(keyId));
                            }
                        } else {
                            System.out.println("Pilihan sub-menu tidak valid.");
                        }
                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 5:
                        System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen WorkHub!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan menu tidak valid. Silakan pilih angka 1-5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan format angka.");
                scanner.nextLine(); // Clear buffer scanner
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}