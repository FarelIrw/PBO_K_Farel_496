package Codelab.Modul2.Codelab1;

public class Main {
    public static void main(String[] args) {
        // membuat variabel hewan 1 dan 2
        hewan hewan1 = new hewan();
        hewan hewan2 = new hewan();

        // menambahkan nilai atau keterangan dalam variabel hewan 1
        hewan1.Nama = "Kucing";
        hewan1.Jenis = "Mamalia";
        hewan1.Suara = "Miauuu";
        hewan1.Kaki = "4";

        // menambahkan nilai atau keterengan dalam variable hewan 2
        hewan2.Nama = "Anjing";
        hewan2.Jenis = "Mamalia";
        hewan2.Suara = "Guk... Guk...";
        hewan2.Kaki = "4";

        // Memanggil method
        hewan1.tampilkaninfo();
        hewan2.tampilkaninfo();
    }
}
