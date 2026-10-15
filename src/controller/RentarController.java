package controller;
import model.Kendaraan;
import model.KendaraanRepository;
import model.PenyewaanRepository;
import view.RentalView;
import view.StrukView;
import model.Penyewaan;

public class RentarController {
    private final KendaraanRepository kendaraanRepo = new KendaraanRepository();
    private final PenyewaanRepository penyewaanRepo = new PenyewaanRepository();
    private final RentalView view = new RentalView();
    private final StrukView strukView = new StrukView();

    public void tambahDataAwal(Kendaraan kendaraan){
        kendaraanRepo.tambah(kendaraan);
    }

    public void jalankan(){
        while(true){
            String pilihan = view.tampilMenu();
            switch(pilihan){
                case "1" ->view.tampilDaftarkendaraan(kendaraanRepo.semua());
                case "2" -> tambahKendaraan();
                case "3" -> sewaKendaraan();
                case "4" -> KembalikanKendaraan();
                case "5" -> view.tampilkanRiwayat(penyewaanRepo.semua());
                case "0" -> {
                    view.tampilPesan("Terima kasih telah menggunakan aplikasi ini");
                    return;
                }

                default -> view.tampilPesan("Pilihan tidak valid atau Menu tidak ada");
            }   
        }

    }

    public void tambahKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        if(plat.isEmpty() || kendaraanRepo.cariByPlat(plat) != null){
            view.tampilPesan("Plat nomor kosong atau sudah terdaftar.");
            return;
        }

        String merk = view.bacaTeks("Merk");
        String jenis = view.bacaTeks("Jenis (MOBIL/MOTOR)").toUpperCase();
        if(!jenis.equals("MOBIL") && !jenis.equals("MOTOR")){
            view.tampilPesan("Jenis tidak dikenali");
            return;
        }

        long tarif = view.bacaAngka("Tarif perhari");
        if(tarif <= 0){
            System.out.println("Tarif harus lebih dari 0");
            return;
        }

        kendaraanRepo.tambah(new Kendaraan(plat, merk, jenis, tarif));
        view.tampilPesan("kendaraan Berhasil di tambahkan");
    }

    public void sewaKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        Kendaraan kendaraan = kendaraanRepo.cariByPlat(plat);
        if(kendaraan == null || !kendaraan.isTersedia()){
            view.tampilPesan("Kendaraan tidak ditemukan atau sedang disewa.");
            return;
        }
        String nama = view.bacaTeks("Nama Penyewa");
        int hari = (int) view.bacaAngka("Lama sewa (hari)");
        if(hari <=0){
            view.tampilPesan("Lama sewa minimal 1 hari");
            return;
        }

        long totalBiaya = kendaraan.hitungBiaya(hari);
        Penyewaan sewa = new Penyewaan(plat, nama, kendaraan, hari, totalBiaya);
        penyewaanRepo.tambah(sewa);
        kendaraan.setTersedia(false);
        strukView.cetak(sewa);
    }

    public void KembalikanKendaraan(){
        String plat = view.bacaTeks("Plat Nomor");
        Penyewaan sewa = penyewaanRepo.cariAktifByPlat(plat);
        if(sewa == null){
            view.tampilPesan("Tidak ada penyewaan");
            return;
        }

        sewa.selesai();
        sewa.getKendaraan().setTersedia(true);
        view.tampilPesan("Kendaraan "+ sewa.getKendaraan().getMerk() + " Telah dikembalikan..");
    }
}
