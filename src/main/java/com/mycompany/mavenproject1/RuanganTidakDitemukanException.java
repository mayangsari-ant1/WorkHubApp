/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

// MODUL 9: CUSTOM EXCEPTION (Turunan dari class Exception)
public class RuanganTidakDitemukanException extends Exception {
    public RuanganTidakDitemukanException(String message) {
        super(message);
    }
}