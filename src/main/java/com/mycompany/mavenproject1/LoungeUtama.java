/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

public class LoungeUtama {
    private String namaLounge;
    private int kapasitasKursi;

    public LoungeUtama(String namaLounge, int kapasitasKursi) {
        this.namaLounge = namaLounge;
        this.kapasitasKursi = kapasitasKursi;
    }

    public void bukaLounge() {
        System.out.println("-> [" + namaLounge + "] dibuka. Kapasitas: " + kapasitasKursi + " kursi.");
    }
}