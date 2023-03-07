/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        String fileName = "ListadoProducto (2).txt"; // poner el nombre del txt
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = buffer.readLine()) != null) {
                String[] parts = line.split("\\|");
                String llave = parts[0].trim();
                String valor = parts[1].trim();

                if (hashMap.containsKey(llave)) {
                    // si la llave ya existe, agregar un nuev valor al arraylist
                    hashMap.get(llave).add(valor);
                } else {
                    // si la no existe, crea un nuevo ArrayList para que la llave y agregar una lista
                    ArrayList<String> listaValor = new ArrayList<>();
                    listaValor.add(valor);
                    hashMap.put(llave, listaValor);
                }
            }
            buffer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // print the HashMap
        for (String llave : hashMap.keySet()) {
            System.out.println(llave + " : " + hashMap.get(llave));
        }
    }
}

