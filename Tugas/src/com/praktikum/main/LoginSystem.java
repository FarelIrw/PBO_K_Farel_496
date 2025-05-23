package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.data.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        // user default
        userList.add(new Admin("Admin Utama", "0001", "Admin496", "Pass496"));
        userList.add(new Mahasiswa("Farel", "496"));
        userList.add(new Mahasiswa("Kumar", "600"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {  // loop supaya setelah logout kembali ke menu login
            System.out.println("==============================");
            System.out.println("   SELAMAT DATANG DI SISTEM   ");
            System.out.println("==============================");

            int tipe;
            do {
                System.out.println("1. Login sebagai Admin");
                System.out.println("2. Login sebagai Mahasiswa");
                System.out.println("0. Keluar Program");
                System.out.print("Pilih (1/2/0): ");

                try {
                    tipe = scanner.nextInt();
                    scanner.nextLine();
                    if (tipe != 1 && tipe != 2 && tipe != 0) {
                        System.out.println("Pilihan tidak valid!\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!\n");
                    scanner.nextLine();
                    tipe = -1;
                }
            } while (tipe != 1 && tipe != 2 && tipe != 0);

            if (tipe == 0) {
                System.out.println("Terima kasih telah menggunakan sistem. Program selesai.");
                break; // keluar dari while(true) -> program selesai
            }

            User user = loginProcess(tipe);

            if (user != null) {
                user.displayAppMenu(); // menu user (admin/mahasiswa)
                // Setelah logout, kembali ke awal loop dan tampilkan menu login lagi
            } else {
                System.out.println("Gagal login. Kembali ke menu awal.\n");
                // langsung kembali ke awal loop
            }
        }

        scanner.close();
    }



    public static User loginProcess(int tipe) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            try {
                if (tipe == 1) {
                    System.out.print("Username: ");
                    String usern = scanner.nextLine();
                    System.out.print("Password: ");
                    String pass = scanner.nextLine();

                    // cari di userList menggunakan for each atau enchanced loop
                    for (User u : userList) {
                        if (u instanceof Admin &&
                                ((Admin) u).getUsername().equals(usern) &&
                                ((Admin) u).getPassword().equals(pass)) {
                            ((Admin) u).displayInfo();
                            return u;
                        }
                    }

                } else { // Mahasiswa
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    for (User u : userList) {
                        if (u instanceof Mahasiswa &&
                                u.getNama().equals(nama) &&
                                u.getNim().equals(nim)) {
                            u.displayInfo();
                            return u;
                        }
                    }
                }

                attempts--;
                if (attempts > 0) {
                    System.out.println("Kredensial salah! Sisa percobaan: " + attempts);
                } else {
                    System.out.println("Akses ditolak! Sudah mencoba 3 kali.");
                }

            } catch (Exception e) {
                System.out.println("Terjadi error input, coba lagi.");
                scanner.nextLine();
            }
        }

        return null;
    }
}
