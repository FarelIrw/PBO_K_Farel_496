package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    private String username;
    private String password;


    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Masukkan Username Admin: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Masukkan Password Admin: ");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
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
        System.out.println("\n=== LOGIN BERHASIL SEBAGAI ADMIN ===");
        System.out.println("HALO SELAMAT DATANG ADMIN!");
    }

    @Override
    public void manageReports() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MANAJEMEN LAPORAN BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        if (LoginSystem.reportedItems.isEmpty()) {
                            System.out.println("Belum ada laporan barang.");
                        } else {
                            int index = 0;
                            for (Item item : LoginSystem.reportedItems) {
                                System.out.println(index++ + ". " + item.getItemName() + " - " + item.getDescription() + " - " + item.getLocation() + " (" + item.getStatus() + ")");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("=== Daftar Barang yang Belum Diambil ===");
                        ArrayList<Integer> reportedIndexes = new ArrayList<>();
                        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                            if (LoginSystem.reportedItems.get(i).getStatus().equals("Reported")) {
                                System.out.println(i + ". " + LoginSystem.reportedItems.get(i).getItemName());
                                reportedIndexes.add(i);
                            }
                        }

                        if (reportedIndexes.isEmpty()) {
                            System.out.println("Tidak ada barang dengan status 'Reported'.");
                            break;
                        }

                        System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");

                        try {
                            int idx = scanner.nextInt();
                            scanner.nextLine();

                            Item item = getItemByIndex(idx);
                            if (item != null && item.getStatus().equals("Reported")) {
                                item.setStatus("Claimed");
                                System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
                            } else {
                                System.out.println("Indeks tidak valid atau barang sudah 'Claimed'.");
                            }


                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                            scanner.nextLine();
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid! Pilih indeks dari daftar yang tersedia.");
                        }


                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }

        } while (pilihan != 0);
    }

    public Item getItemByIndex(int index) {
        try {
            return LoginSystem.reportedItems.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index item di luar jangkauan!");
            return null;
        }
    }



    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MANAJEMEN MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                        break;
                    case 2:
                        System.out.print("NIM Mahasiswa yang akan dihapus: ");
                        String targetNim = scanner.nextLine();
                        boolean found = false;

                        for (int i = 0; i < LoginSystem.userList.size(); i++) {
                            User u = LoginSystem.userList.get(i);
                            if (u instanceof Mahasiswa && u.getNim().equals(targetNim)) {
                                LoginSystem.userList.remove(i);
                                found = true;
                                System.out.println("Mahasiswa berhasil dihapus.");
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }

        } while (pilihan != 0);
    }


    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Pengguna");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    manageReports();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout berhasil.\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}