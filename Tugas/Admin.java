package Tugas;

import java.util.Scanner;

public class Admin {
    private String usernameAdmin = "Admin496";
    private String passwordAdmin = "Password496";

    public void login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3; // Maksimal percobaan login

        while (attempts > 0) {
            System.out.print("Masukkan Username: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Masukkan Password: ");
            String inputPassword = scanner.nextLine();

            //validasi username dan password
            if (inputUsername.equals(usernameAdmin) && inputPassword.equals(passwordAdmin)) {
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
