package perpustakaan; //Mengelompokkan kelas-kelas dalam namespace agar lebih terorganisir.

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    public void tampilkanInfo() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(String judul) { //metode dengan nama sama, tetapi parameter berbeda yaitu overloading.
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    @Override
    public void pinjamBuku(String judul, int durasi) { //metode dengan nama sama, tetapi parameter berbeda yaitu overloading.
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }
}
