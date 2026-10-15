package app;

// import model.Kendaraan;
import controller.RentarController;
import model.Mobil;
import model.Motor;
//import model.Kendaraan;
import model.Minibus;

public class Main {
    public static void main(String[] args) {
        RentarController controller = new RentarController();

        //tambah data awall// data dummy
        controller.tambahDataAwal(new Mobil(
            "B 1234 ABC", 
            "Toyota Avanza",  
            300000));   

        controller.tambahDataAwal(new Motor(
            "B 5678 DEF", 
            "Honda Vario",  
            100000));

        controller.tambahDataAwal(new Mobil(
            "B 9012 GHI", 
            "Suzuki Swift", 
            250000));

        controller.tambahDataAwal(new Minibus(
                        "L 7777 GH", 
                        "Toyota Hiace", 
                        900000)
                );

        controller.jalankan();
    }
}
