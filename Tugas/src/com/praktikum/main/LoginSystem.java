package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat objek admin dan mahasiswa dengan data awal
        Admin admin = new Admin("Admin Utama", "0001", "Admin496", "Password496");
        Mahasiswa mahasiswa = new Mahasiswa("Farel Bayuputra Irawan", "202410370110496");
        User user;

        while (true) {
            System.out.println("\n==============================");
            System.out.println("   SELAMAT DATANG DI SISTEM   ");
            System.out.println("==============================");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.print("Pilih (1/2): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // flush newline

            if (pilihan == 1) {
                user = admin;
                break;
            } else if (pilihan == 2) {
                user = mahasiswa;
                break;
            } else {
                System.out.println("Pilihan tidak valid! Silakan pilih 1 atau 2.\n");
            }
        }

        user.login();
        user.displayAppMenu();
    }
}
