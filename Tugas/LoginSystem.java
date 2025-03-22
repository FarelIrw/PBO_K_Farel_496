package Tugas;
import java.util.Scanner;

public class LoginSystem {
   public static void main (String[] args) {// Function main atau utama
        Scanner scanner = new Scanner(System.in);

        // Membuat menu login
        System.out.println("Pilih login yang akan dipilih:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");

        //Input user menentukan pilihan
        System.out.print("Masukkan pilihan: ");
        int option = scanner.nextInt();

        //Logika if else untuk mengarahkan ke menu yang dipilih
        if (option == 1 ){
            admin();
        } else if (option == 2) {
            mahasiswa();
        }else {
            System.out.println("Pilihan tidak Valid!");
        }
    }

    // Function untuk pilihan pertama atau admin
    static void admin (){
        Scanner scanner = new Scanner(System.in);// Objek scanner untuk menerima input user

        //String untuk menyimpan data username dan password
        String usernameAdmin = "Admin496";
        String passAdmin = "password496";

        // Input user
        System.out.printf("Masukkan Username: ");;
        String checkusernameadmin = scanner.nextLine();

        System.out.printf("Masukkan Password: ");
        String checkpassadmin = scanner.nextLine();

        // Logika untuk pengecekan apakah cocok atau tidak
        if (checkusernameadmin.equals(usernameAdmin) && checkpassadmin.equals(passAdmin)){
            System.out.println("Selamat Login berhasil!");
        }else{// jika tidak cocok maka sistem akan mengarahkan ke statment yang ada didalam else
            System.out.println("Tidak cocok!");
        }
    }

    // Function untuk opsi pilihan kedua atau mahasiswa
    static void mahasiswa (){
        Scanner scanner = new Scanner(System.in);//Kode ini digunakan untuk membaca input dari pengguna melalui keyboard di Java.

        String nameMahasiswa = "Farel Bayuputra Irawan";
        String nimMahasiswa = "202410370110496";

        System.out.printf("Masukkan nama: ");
        String checknama = scanner.nextLine();

        System.out.printf("Masukkan NIM:");
        String checknim = scanner.nextLine();

        if (checknama.equals(nameMahasiswa) && checknim.equals(nimMahasiswa)){
            System.out.println("Login Berhasil!!");
            System.out.printf("Nama : "+nameMahasiswa);
            System.out.printf("\nNIM  : "+nimMahasiswa);
        }else {
            System.out.println("Login tidak berhasil! Nama atau NIM salah!");
        }
    }
}
