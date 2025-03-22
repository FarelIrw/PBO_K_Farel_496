package Codelab.Modul3;

public class Musuh extends KarakterGame{

    public Musuh (String nama, int kesehatan){
        super (nama, kesehatan);
    }

    @Override
    public void serang (KarakterGame target){
        System.out.println(getNama() + " menyerang " + target.getNama() + " Menggunakan Operator!");
        target.setKesehatan(target.getKesehatan() - 15);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " +target.getKesehatan());
    }
}
