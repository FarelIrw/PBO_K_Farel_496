package Tugas;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih login yang akan dipilih:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");

            System.out.print("Masukkan pilihan (1 atau 2): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline setelah nextInt

            if (option == 1) {
                Admin admin = new Admin();
                admin.login();
                break; // Keluar setelah login berhasil
            } else if (option == 2) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.login();
                break; // Keluar setelah login berhasil
            } else {
                System.out.println("Pilihan tidak Valid! Silakan pilih 1 atau 2.");
                break;
            }
        }
    }
}
