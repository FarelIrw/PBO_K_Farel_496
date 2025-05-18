import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    static Scanner input = new Scanner(System.in);
    //Menyimpan barang yang sudah ada dan yang baru ditambahkan
    static ArrayList<Barang> daftarBarang = new ArrayList<>();

    public static void main(String[] args) {
        // Tambahkan data awal
        daftarBarang.add(new Barang("Mykonos California", 50));
        daftarBarang.add(new Barang("Afnan 9 PM",30 ));
        daftarBarang.add(new Barang("Zimaya Sharaf Blend", 10));
        daftarBarang.add(new Barang("Mykonos Dark Secret",100 ));
        daftarBarang.add(new Barang("Lattafa Fakhar",5 ));
        daftarBarang.add(new Barang("LV IMAGINATION",200 ));

        int opsi;
        do {
            tampilkanMenu();
            opsi = mintaInputInt("Pilih opsi: ");
            switch (opsi) {
                case 1 -> tambahBarang();
                case 2 -> tampilkanSemuaBarang();
                case 3 -> kurangiStok();
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Opsi tidak valid!");
            }
        } while (opsi != 0);

        input.close(); // tutup scanner
    }

    static void tampilkanMenu() {
        System.out.println("\n==== MENU MANAJEMEN STOK PARFUM ====");
        System.out.println("1. Tambah Parfum Baru");
        System.out.println("2. Tampilkan Semua List Parfum");
        System.out.println("3. Kurangi Stok Parfum");
        System.out.println("0. Keluar");
    }

    public static void tambahBarang() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama Parfum: ");
            String nama = input.nextLine();

            System.out.print("Masukkan jumlah stok: ");
            int stok = input.nextInt();

            if (stok < 0) {
                throw new IllegalArgumentException("Stok tidak boleh negatif.");
            }

            Barang barangBaru = new Barang(nama, stok);
            daftarBarang.add(barangBaru);

            System.out.println("Parfum berhasil ditambahkan!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Input stok harus berupa angka.");
            input.nextLine(); // buang input yang salah

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan yang tak terduga: " + e.getMessage());
        }
    }


    static void tampilkanSemuaBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok Parfum kosong.");
        } else {
            System.out.println("\n=== DAFTAR Parfum ===");
            for (Barang b : daftarBarang) {
                System.out.println("- " + b.getNama() + " | Stok: " + b.getStok());
            }
        }
    }

    static void kurangiStok() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Tidak ada Parfum yang tersedia.");
            return;
        }

        // Tampilkan daftar barang dengan indeks
        System.out.println("\n=== PILIH PARFUM ===");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang b = daftarBarang.get(i);
            System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
        }

        try {
            int indeks = mintaInputInt("Masukkan nomor indeks Parfum: ");
            Barang barang = daftarBarang.get(indeks);

            int jumlah = mintaInputInt("Masukkan jumlah stok yang akan diambil: ");

            if (jumlah < 0) {
                System.out.println("Jumlah tidak boleh negatif.");
                return;
            }

            if (jumlah > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
            }

            barang.setStok(barang.getStok() - jumlah);
            System.out.println("Stok berhasil dikurangi.");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid!");
        } catch (StokTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Digunakan untuk menangkap dan menangani error jika exception terjadi saat user ingin mengurangi stok.

    static int mintaInputInt(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine(); // bersihkan buffer
            }
        }
    }
}
