package Tugas;

import java.util.Scanner;

public class Admin extends User {
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
            System.out.print("Masukkan Username: ");
            String inputUser = scanner.nextLine();

            System.out.print("Masukkan Password: ");
            String inputPass = scanner.nextLine();

            if (inputUser.equals(username) && inputPass.equals(password)) {
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
        System.out.println("Selamat datang, " + getNama());
    }
}
