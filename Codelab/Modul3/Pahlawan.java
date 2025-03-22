package Codelab.Modul3;

public class Pahlawan extends KarakterGame {
    public Pahlawan (String nama, int kesehatan){
        super(nama, kesehatan);
    }
    @Override
    public void serang (KarakterGame target){
        System.out.println(getNama() + "Menyerang " + target.getNama() + " Menggunakan Vandal!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}
