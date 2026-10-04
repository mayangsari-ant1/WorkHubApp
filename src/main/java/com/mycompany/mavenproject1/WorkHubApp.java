/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 2: IMPORT STATEMENT
import java.util.Scanner;

public class WorkHubApp {

    // MODUL 4: METHOD OVERLOADING (Metode 1 - Parameter String)
    public static void cariRuangan(String nama, RuangKerja[] daftar, int jumlah) {
        System.out.println("\n[PENCARIAN] Berdasarkan Nama Ruangan: " + nama);
        boolean ditemukan = false;
        // MODUL 2: Perulangan for
        for (int i = 0; i < jumlah; i++) {
            // MODUL 2: Percabangan if
            if (daftar[i].getNamaRuangan().equalsIgnoreCase(nama)) {
                System.out.print("Hasil Ditemukan -> ");
                daftar[i].tampilkanInfo(); // Memanggil method hasil Overriding
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Ruangan dengan nama '" + nama + "' tidak ditemukan.");
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

    // MODUL 2: MAIN METHOD (Entry Point Program)
    public static void main(String[] args) {
        // MODUL 2: SCANNER & ARRAY INSTANTIATION
        try (Scanner scanner = new Scanner(System.in)) {
            RuangKerja[] daftarRuangan = new RuangKerja[15]; // Array untuk menampung Polimorfisme Objek
            int jumlahRuangan = 0;

            // DATA AWAL (4 Objek Awal)
            daftarRuangan[jumlahRuangan++] = new PrivateOffice("Suite Executive A", "PO-01", 120000, 4);
            daftarRuangan[jumlahRuangan++] = new PrivateOffice("Startup Pod B", "PO-02", 200000, 8);
            daftarRuangan[jumlahRuangan++] = new MeetingRoom("Boardroom Alpha", "MR-01", 150000, 12);
            daftarRuangan[jumlahRuangan++] = new MeetingRoom("Auditorium Mini", "MR-02", 350000, 30);

            boolean isRunning = true;

            System.out.println("==================================================");
            System.out.println("  SISTEM MANAJEMEN WORKHUB CO-WORKING SPACE (M2-M5)");
            System.out.println("==================================================");

            // MODUL 2: PERULANGAN (while loop)
            while (isRunning) {
                System.out.println("\n=== MENU UTAMA WORKHUB ===");
                System.out.println("1. Tambah Ruangan Baru");
                System.out.println("2. Tampilkan Seluruh Data Ruangan");
                System.out.println("3. Cari Ruangan (Fitur Overloading)");
                System.out.println("4. Keluar Sistem");
                System.out.print("Pilih Menu (1-4): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan buffer enter

                // MODUL 2: PERCABANGAN (switch-case standar)
                switch (pilihan) {
                    case 1:
                        if (jumlahRuangan < daftarRuangan.length) {
                            System.out.println("\n-- PILIH TIPE RUANG KERJA --");
                            System.out.println("1. Private Office");
                            System.out.println("2. Meeting Room");
                            System.out.print("Pilihan Tipe (1/2): ");
                            int tipe = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Kode Ruang     : ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan Nama Ruangan   : ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan Harga Sewa/Jam : ");
                            double harga = scanner.nextDouble();
                            scanner.nextLine();

                            // MODUL 2: PERCABANGAN (if-else)
                            if (tipe == 1) {
                                System.out.print("Masukkan Jumlah Meja Kerja: ");
                                int meja = scanner.nextInt();
                                scanner.nextLine();
                                
                                // MODUL 3: Instansiasi Objek Subclass 1
                                daftarRuangan[jumlahRuangan] = new PrivateOffice(nama, kode, harga, meja);
                                jumlahRuangan++;
                                System.out.println("-> [SUKSES] Data Private Office Berhasil Ditambahkan!");
                            } else if (tipe == 2) {
                                System.out.print("Masukkan Kapasitas Orang: ");
                                int kap = scanner.nextInt();
                                scanner.nextLine();
                                
                                // MODUL 3: Instansiasi Objek Subclass 2
                                daftarRuangan[jumlahRuangan] = new MeetingRoom(nama, kode, harga, kap);
                                jumlahRuangan++;
                                System.out.println("-> [SUKSES] Data Meeting Room Berhasil Ditambahkan!");
                            } else {
                                System.out.println("Tipe tidak valid! Penambahan dibatalkan.");
                            }
                        } else {
                            System.out.println("[PERINGATAN] Kapasitas penyimpanan data ruangan penuh!");
                        }
                        break;

                    case 2:
                        System.out.println("\n-------------------------------------------------------------------------------------------");
                        System.out.println("                              DAFTAR RUANG KERJA WORKHUB                                   ");
                        System.out.println("-------------------------------------------------------------------------------------------");
                        
                        if (jumlahRuangan == 0) {
                            System.out.println("Belum ada data ruangan yang terdaftar.");
                        } else {
                            // MODUL 2: PERULANGAN FOR & PENAKSESAN ARRAY
                            for (int i = 0; i < jumlahRuangan; i++) {
                                System.out.print((i + 1) + ". ");
                                // MODUL 5: Memanggil Method Overriding
                                daftarRuangan[i].tampilkanInfo();
                                daftarRuangan[i].aturanPenggunaan();
                                System.out.println();
                            }
                            // MODUL 4: PEMANGGILAN VARIABEL STATIC
                            System.out.println("===========================================================================================");
                            System.out.println("* Total Objek Ruangan Berhasil Dibuat (Static Counter): " + RuangKerja.totalRuanganDibuat);
                            System.out.println("===========================================================================================");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n-- FITUR PENCARIAN (OVERLOADING METHOD) --");
                        System.out.println("1. Cari berdasarkan Nama Ruangan (String)");
                        System.out.println("2. Cari berdasarkan Batas Maksimal Harga Sewa (Double)");
                        System.out.print("Pilih opsi pencarian (1/2): ");
                        int opsiCari = scanner.nextInt();
                        scanner.nextLine();

                        if (opsiCari == 1) {
                            System.out.print("Masukkan Nama Ruangan: ");
                            String namaKunci = scanner.nextLine();
                            // Pemanggilan Overloading 1
                            cariRuangan(namaKunci, daftarRuangan, jumlahRuangan);
                        } else if (opsiCari == 2) {
                            System.out.print("Masukkan Batas Maksimal Harga Sewa: ");
                            double hargaKunci = scanner.nextDouble();
                            scanner.nextLine();
                            // Pemanggilan Overloading 2
                            cariRuangan(hargaKunci, daftarRuangan, jumlahRuangan);
                        } else {
                            System.out.println("Opsi pilihan pencarian tidak valid.");
                        }
                        System.out.print("\nTekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen WorkHub!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan menu tidak valid. Silakan pilih angka 1-4.");
                        break;
                }
            }
        }
    }
}