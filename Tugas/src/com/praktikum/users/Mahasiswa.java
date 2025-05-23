package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
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
        String nama = scanner.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(nama, deskripsi, lokasi);
        LoginSystem.reportedItems.add(item);
        System.out.println("Laporan barang berhasil dikirim!");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("=== Daftar Laporan Barang ===");
        for (Item item : LoginSystem.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println("- " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation());
            }
        }
    }

    public void viewReportedItemByIndex() {
        Scanner scanner = new Scanner(System.in);
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("=== Daftar Laporan Barang ===");
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            System.out.println(i + ". " + LoginSystem.reportedItems.get(i).getItemName());
        }

        System.out.print("Masukkan nomor laporan yang ingin dilihat: ");

        try {
            int idx = scanner.nextInt();
            scanner.nextLine();

            Item item = LoginSystem.reportedItems.get(idx); // <- bisa throw IndexOutOfBoundsException
            System.out.println("Detail Laporan:");
            System.out.println("Nama Barang: " + item.getItemName());
            System.out.println("Deskripsi: " + item.getDescription());
            System.out.println("Lokasi: " + item.getLocation());
            System.out.println("Status: " + item.getStatus());

        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.nextLine(); // clear buffer
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nomor laporan tidak valid!");
        }
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("3. Lihat Detail Laporan Berdasarkan Nomor");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline

                switch (pilihan) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 3:
                        viewReportedItemByIndex();
                        break;
                    case 0:
                        System.out.println("Logout berhasil.\n");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear buffer
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

}