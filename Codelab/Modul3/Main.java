package Codelab.Modul3;

public class Main {
    public static void main(String[] args) {
        KarakterGame KarakterUmum = new KarakterGame("Karakter Umum",100);
        Pahlawan Jett = new Pahlawan("Jett",150);
        Musuh Iso = new Musuh("Iso", 200);

        System.out.println("Status awal:");
        System.out.println(Jett.getNama() + " Memiliki Kesehatan: " + Jett.getKesehatan());
        System.out.println(Iso.getNama()+ " Memiliki Kesehatan: " + Iso.getKesehatan());

        // Memanggil method serang untuk mensimulasikan pertarungan
        System.out.println("Pertarungan dimulai!");
        Jett.serang(Iso); // Brimstone menyerang Viper menggunakan pedang
        Iso.serang(Jett); // Viper menyerang Brimstone menggunakan sihir
    }
}
