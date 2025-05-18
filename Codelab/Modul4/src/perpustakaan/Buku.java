package perpustakaan; //Mengelompokkan kelas-kelas dalam namespace agar lebih terorganisir.

//CLass Buku adalah kelas abstrak yang mendefinisikan struktur dasar dari buku (judul dan penulis).
//Tidak bisa langsung dibuat objeknya, hanya bisa diwarisi (inherited).
public abstract class Buku {
    protected String judul;
    protected String penulis;

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }
    //Memiliki method abstrak displayInfo() yang harus diimplementasikan oleh subclass-nya.
    public abstract void displayInfo();

    public String getJudul() {
        return judul;
    }
}
