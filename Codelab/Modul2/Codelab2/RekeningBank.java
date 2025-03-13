package Codelab.Modul2.Codelab2;

import java.util.Scanner;

public class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    Double saldo;

    double setor;
    double selisih ;
    double jumlah;
    double akhir;
    double tarik;


    void tampilkaninfo(){
        // Output Tampilan data
        System.out.println("Nomor Rekening anda :"+nomorRekening);
        System.out.println("Nama Pemilik Saldo  :"+namaPemilik );
        System.out.println("Saldo yang dimiliki :"+saldo);
    }

    void setorUang () {
        // menambahkan file scanner
        Scanner scanner = new Scanner(System.in);
        //Meminta input nilai setoran
        System.out.printf("\nMasukkan Jumlah uang yang akan di setorkan:Rp.");
        setor = scanner.nextDouble();

        //Menjumlahkan dan Menampilkan data yang telah diinputkan
        jumlah = setor +saldo;
        System.out.println("" + namaPemilik + " menyetor Rp." + setor + ". Saldo anda sekarang: Rp." + jumlah);

    }

    void tarikUang(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nMasukkan Jumlah uang yang akan di tarik:Rp. ");
        tarik = scanner.nextDouble();

        selisih = jumlah - tarik;
        if (tarik < saldo) {
            System.out.println("" + namaPemilik + " menarik uang sebesar Rp." + tarik + ". (Berhasil!) Saldo anda sekarang: Rp." + selisih);
        }else {
            System.out.println("" + namaPemilik + " menarik uang sebesar Rp." + tarik + ". (Gagal! Saldo tidak mencukupi!) Saldo anda sekarang: Rp." +jumlah);
        }
    }

    void tampilkanDataAkhir(){
        System.out.println("\nNomor Rekening anda :"+nomorRekening);
        System.out.println("Nama Pemilik Saldo  :"+namaPemilik );
        if (tarik < saldo){
            System.out.println("Saldo yang dimiliki :"+selisih);
        }else {
            System.out.println("Saldo yang dimiliki :"+jumlah);
        }
    }
}
