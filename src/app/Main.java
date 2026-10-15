package app;

import model.Kendaraan;
import controller.RentarController;

public class Main {
    public static void main(String[] args) {
        RentarController controller = new RentarController();

        //tambah data awall// data dummy
        controller.tambahDataAwal(new Kendaraan(
            "B 1234 ABC", 
            "Toyota Avanza", 
            "MOBIL", 
            300000));

        controller.tambahDataAwal(new Kendaraan(
            "B 5678 DEF", 
            "Honda Vario", 
            "MOTOR", 
            100000));

        controller.tambahDataAwal(new Kendaraan(
            "B 9012 GHI", 
            "Suzuki Swift", 
            "MOBIL", 
            250000));

        controller.jalankan();
    }
}
