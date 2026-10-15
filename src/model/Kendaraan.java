package model;

/* 
[SRP]: 
Kendaraan hanya bertanggung jawab atas DATA Kendaraan dan aturan bisnis miliknya sendiri (hitung biaya sewa).
*/

// public class Kendaraan {
//     private final String platNomor;
//     private final String merk;
//     private final String jenis;
//     private final long tarifPerhari;
//     private boolean tersedia = true;

//     public Kendaraan(String platNomor, String merk, String jenis, long tarifPerhari) {
//         this.platNomor = platNomor;
//         this.merk = merk;
//         this.jenis = jenis;
//         this.tarifPerhari = tarifPerhari;
//     }

//     public long hitungBiaya(int hari){
//         long total = tarifPerhari * hari;

//         if (jenis.equals("MOBIL")){
//             total+= 50000; // ASURANSI
//         }else if(jenis.equals("MOTOR")){
//             if(hari >= 7 ) total -= total / 10;
//         }
//         return total;
//     }

//     public String getPlatNomor(){
//         return platNomor;
//     }

//     public String getMerk(){
//         return merk;
//     }

//     public String getJenis(){
//         return jenis;
//     }

//     public Long getTarifPerhari(){
//         return tarifPerhari;
//     }

//     public boolean isTersedia(){
//         return tersedia;
//     }

//     public void setTersedia(boolean tersedia){
//         this.tersedia = tersedia;
//     }
// }

//[SRP] + [OCP]:
//Kelas dibuat abstract secara tertutup untuk modifikasi (jadi tidak lagi blok if-else untuk menentukan jenis objeknya),
//dengan abstract sifatnya jadi terbuka untuk di extend, jika ada jenis baru maka subclass baru.
public abstract class Kendaraan {
    private final String platNomor;
    private final String merk;
    private final long tarifPerHari;
    private boolean tersedia = true;

    public Kendaraan(String platNomor, String merk, long tarifPerHari) {
        this.platNomor = platNomor;
        this.merk = merk;
        this.tarifPerHari = tarifPerHari;
    }

    // [OCP] Setiap subclass menentukan sendiri nama jenis & cara hitung biayanya.
    public abstract String getJenis();

    public abstract long hitungBiaya(int hari);

    public String getPlatNomor() {
        return platNomor;
    }

    public String getMerk() {
        return merk;
    }

    public long getTarifPerHari() {
        return tarifPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
