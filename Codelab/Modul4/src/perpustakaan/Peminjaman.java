package perpustakaan; //Mengelompokkan kelas-kelas dalam namespace agar lebih terorganisir.

public interface Peminjaman { //Peminjaman adalah interface yang mendefinisikan tiga method:
    void pinjamBuku(String judul);
    void pinjamBuku(String judul, int durasi);
    void kembalikanBuku(String judul);
}
