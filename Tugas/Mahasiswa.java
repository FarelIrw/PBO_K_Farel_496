package Tugas;

import java.util.Scanner;

public class Mahasiswa extends User {

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
}
