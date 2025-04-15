package Tugas;

import java.util.Scanner;

public class Mahasiswa {
    private String nameMahasiswa = "Farel Bayuputra Irawan"; // Nama default
    private String nimMahasiswa = "202410370110496"; // NIM default

    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3; // Maksimal percobaan login

        while (attempts > 0) {
            System.out.print("Masukkan nama: ");
            String CheckinputNama = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            String CheckinputNim = scanner.nextLine();

            if (CheckinputNama.equals(nameMahasiswa) && CheckinputNim.equals(nimMahasiswa)) {
                System.out.println("Login Berhasil!");
                break;
            } else {
                attempts--; //mengurangi jumlah percobaan login setiap kali login gagal.
                if (attempts > 0) {
                    System.out.println("Login Gagal! Sisa percobaan: " + attempts);
                } else {
                    System.out.println("Akses ditolak! Anda telah mencoba 3 kali.");
                }
            }
        }
    }
}
