package Codelab.Modul3;

public class KarakterGame {
    private String nama;
    private int kesehatan;

    public KarakterGame (String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama (){
        return nama;
    }

    public void setKesehatan (int kesehatan){
        this.kesehatan = kesehatan;
    }

    public int getKesehatan (){
        return kesehatan;
    }

    public void serang (KarakterGame target){

    }

}
