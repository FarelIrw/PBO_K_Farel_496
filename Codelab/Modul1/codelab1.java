package Codelab.Modul1;
import java.util.Scanner;
import java.time.LocalDate;

public class codelab1 {
    public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);

    // Meminta pengguna untuk memasukkan data
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Masukkan tahun lahir: ");
        int year = scanner.nextInt();

     // Tutup Scanner
     scanner.close();

     // Logika if else dan perhitungan umur

        // umur
        int yearnow = LocalDate.now().getYear();
        int age = yearnow - year;

        // Penentuan gender
        String genderStr;
        if (gender == 'L' || gender == 'l') {
            genderStr = "Laki-laki";
        } else if (gender == 'P' || gender == 'p') {
            genderStr = "Perempuan";
        }else {
            genderStr = "Tidak Valid";
        }

        // Hasil
        System.out.println("\nData Diri: ");
        System.out.println("Nama          : "+ name);
        System.out.println("Jenis Kelamin : "+ genderStr);
        System.out.println("Umur          : "+ age);
    }
}
