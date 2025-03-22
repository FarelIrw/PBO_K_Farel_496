package Codelab.Modul2.Codelab2;

public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        const rekening1 = {
            nomorRekening : 202410370110496;
            rekening1.namaPemilik = "Farel Bayuputra Irawan";
            rekening1.saldo = 1000000.0;
        }
        rekening2.nomorRekening = "202410370110501";
        rekening2.namaPemilik   = "Aldhitofa";
        rekening2.saldo         = 500000.0;

        rekening1.tampilkaninfo();
        System.out.printf("\n");
        rekening2.tampilkaninfo();

        rekening1.setorUang();
        rekening2.setorUang();

        rekening1.tarikUang();
        rekening2.tarikUang();

        rekening1.tampilkanDataAkhir();
        rekening2.tampilkanDataAkhir();


    }
}
