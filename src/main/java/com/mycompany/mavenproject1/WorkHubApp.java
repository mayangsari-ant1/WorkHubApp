/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkHubApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        WorkHub workHubUnila = new WorkHub("WorkHub Smart Manager");
        workHubUnila.bukaWorkHub();

        // DEMO DESERIALIZATION: Cek & muat data dari file .dat saat aplikasi dibuka
        boolean dataTersedia = workHubUnila.muatDataDariFile();

        // Jika file .dat belum ada (running pertama kali), isi data awal
        if (!dataTersedia) {
            try {
                workHubUnila.tambahRuangan(new PrivateOffice("Suite Executive A", "PO-01", 120000, 4));
                workHubUnila.tambahRuangan(new PrivateOffice("Startup Pod B", "PO-02", 200000, 8));
                workHubUnila.tambahRuangan(new MeetingRoom("Boardroom Alpha", "MR-01", 150000, 12));
                workHubUnila.tambahRuangan(new MeetingRoom("Auditorium Mini", "MR-02", 350000, 30));
                workHubUnila.tambahRuangan(new EventSpace("Grand Hall WorkHub", "ES-01", 750000, true));
            } catch (Exception e) {
                System.out.println("Gagal inisialisasi data ruangan: " + e.getMessage());
            }

            workHubUnila.tambahPenyewa(new Penyewa("ID-001", "Budi Santoso"));
            workHubUnila.tambahPenyewa(new Penyewa("ID-002", "Siti Aminah"));
            workHubUnila.tambahPenyewa(new Penyewa("ID-003", "Rizky Pratama"));
        }

        boolean isRunning = true;

        System.out.println("\n==================================================");
        System.out.println("   SISTEM MANAJEMEN WORKHUB CO-WORKING SPACE (M11)");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Ruangan");
            System.out.println("2. Lihat Daftar Ruangan");
            System.out.println("3. Cari Ruangan");
            System.out.println("4. Kelola Penyewa");
            System.out.println("5. Penyewaan");
            System.out.println("6. Baca File Log Transaksi (Demo File I/O Teks)");
            System.out.println("7. Simpan & Keluar");
            System.out.print("Pilih Menu: 1-7: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.println("\n-- PILIH TIPE RUANG KERJA --");
                        System.out.println("1. Private Office | 2. Meeting Room | 3. Event Space");
                        System.out.print("Pilihan Tipe (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Judul/Nama: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan Kode: ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Harga Sewa: ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jml Meja: ");
                            workHubUnila.tambahRuangan(new PrivateOffice(judul, kode, harga, scanner.nextInt()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran Kapasitas: ");
                            workHubUnila.tambahRuangan(new MeetingRoom(judul, kode, harga, scanner.nextInt()));
                        } else if (jenis == 3) {
                            System.out.print("Apakah Ada Sound System? (true/false): ");
                            workHubUnila.tambahRuangan(new EventSpace(judul, kode, harga, scanner.nextBoolean()));
                        } else {
                            System.out.println("Tipe tidak valid!");
                        }
                        scanner.nextLine();
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Ruang Kerja di WorkHub ---");
                        workHubUnila.lihatSemuaRuangan();
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Ruangan --");
                        System.out.print("Masukkan Judul: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            workHubUnila.cariRuangan(kataKunci);
                        } catch (RuanganTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Penyewa --");
                        System.out.println("1. Tambah Penyewa");
                        System.out.println("2. Cari Penyewa");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();
                            workHubUnila.tambahPenyewa(new Penyewa(id, nama));
                        } else if (menuA == 2) {
                            System.out.print("ID yg dicari: ");
                            workHubUnila.cariPenyewa(scanner.nextLine());
                        } else if (menuA == 3) {
                            workHubUnila.lihatSemuaPenyewa();
                        }
                        break;

                    case 5:
                        System.out.println("\n-- Sistem Penyewaan --");
                        System.out.print("Masukkan ID Penyewa: ");
                        String inputId = scanner.nextLine();

                        Penyewa peminjam = workHubUnila.getPenyewa(inputId);

                        if (peminjam == null) {
                            System.out.println("Gagal: Penyewa belum terdaftar!");
                        } else if (workHubUnila.getJumlahRuangan() == 0) {
                            System.out.println("Gagal: Belum ada ruangan yang bisa disewa.");
                        } else {
                            workHubUnila.lihatSemuaRuangan();
                            System.out.print("Pilih Nomor Ruangan yg ingin disewa: ");
                            int noRuang = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noRuang >= 0 && noRuang < workHubUnila.getJumlahRuangan()) {
                                RuangKerja itemSewa = workHubUnila.getRuanganInt(noRuang);
                                TransaksiPenyewaan.prosesPinjam(peminjam, itemSewa);
                            } else {
                                System.out.println("Nomor ruangan tidak valid!");
                            }
                        }
                        break;

                    case 6:
                        // DEMO FILE I/O READ (.txt)
                        workHubUnila.bacaLogTransaksi();
                        break;

                    case 7:
                        // DEMO SERIALIZATION (.dat)
                        System.out.println("Menyimpan sesi ke database internal...");
                        workHubUnila.simpanDataKeFile();
                        System.out.println("Terima kasih telah menggunakan Smart WorkHub!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] " + e.getMessage());
            }
        }
        scanner.close();
    }
}