package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Masukkan Nama: ");
            String inputNama = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            String inputNim = scanner.nextLine();

            if (inputNama.equals(getNama()) && inputNim.equals(getNim())) {
                displayInfo();
                break;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Login Gagal! Sisa percobaan: " + attempts);
                } else {
                    System.out.println("Akses ditolak! Kamu telah mencoba 3 kali.");
                }
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("\n=== LOGIN BERHASIL SEBAGAI MAHASISWA ===");
        System.out.println("HALO SELAMAT DATANG KEMBALI!!!");
        System.out.println("Nama : " + getNama());
        System.out.println("NIM  : " + getNim());
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();

        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println(">> Laporan barang berhasil dikirim!");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil.\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
