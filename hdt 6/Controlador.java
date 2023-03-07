import java.util.Scanner;

/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/

public class Controlador {

    View v = new View();
    Read reader = new Read();
    MapFactory mapF = new MapFactory();


    public void principal() {
        v.bienvenida();
        v.preguntarMap();
        MapFactory.createMap(v.choice);
        reader.main(null);
    }
    
    


}
