/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

public class TransaksiPenyewaan {
    public static void prosesPinjam(Penyewa penyewa, RuangKerja ruangan) {
        System.out.println("\n===== STRUK TRANSAKSI SEWA WORKHUB =====");
        System.out.println("Penyewa  : " + penyewa.getNama() + " (" + penyewa.getIdPenyewa() + ")");
        System.out.println("Ruangan  : " + ruangan.getNamaRuangan() + " [" + ruangan.getKodeRuang() + "]");
        System.out.println("Harga    : Rp " + ruangan.getHargaSewaPerJam() + " / jam");
        System.out.println("Status   : Transaksi Penyewaan Berhasil Dicatat di Sistem.");
        
        ruangan.aturanPenggunaan();
        
        if (ruangan instanceof DapatDisewa) {
            ((DapatDisewa) ruangan).prosesPenyewaanFisik();
        }
        System.out.println("========================================");
    }
}
