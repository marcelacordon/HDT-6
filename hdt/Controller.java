
/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/
import java.util.*;
import java.io.*;


public class Controller {

    
    View v = new View();
    Map<String, ArrayList<String>> miMap;
    Map<String, ArrayList<String>> carreta;
    String llave;
    
    public void principal(){
        v.preguntar();
        leer();
        v.programaInicial();
    }

    public void leer(){
        String data = "src/ListadoProducto (2).txt";
        try (BufferedReader buffer = new BufferedReader(new FileReader(data))){
            String linea;
                while ((linea = buffer.readLine()) != null) {
                String[] partes = linea.split("\\|");
                String llave = partes[0].trim();
                String valor = partes[1].trim();
                if (miMap.containsKey(llave)) {
                    miMap.get(llave).add(valor);
                }else{
                    ArrayList<String> listaValores = new ArrayList<>();
                    ArrayList<String> arrayCarreta = new ArrayList<>();
                    listaValores.add(valor);
                    carreta.put(llave, arrayCarreta);
                    arrayCarreta.removeAll(arrayCarreta);
                    miMap.put(llave, listaValores);
                }
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(map);
        for (String llave : miMap.keySet()) {
            System.out.println(llave + " : " + miMap.get(llave));
        }
    }  



}
