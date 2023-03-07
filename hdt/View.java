/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/
import java.util.*;

/// chatGPT creo unos metodos, pero fueron modificados 

public class View {
    
    Scanner sc = new Scanner(System.in);
    String eleccion;
    int ele;
    String num;
    Map<String, ArrayList<String>> mapita;
    Map<String, ArrayList<String>> carrito;
    boolean ciclo = true;
    String llave;
    String opcion;
    String opcionSec;

    
    public void programaInicial(){
        while(ciclo){
            System.out.println("------------- Bienvenido al menu en linea -------------  ");
            System.out.println("1) Agregar un producto a la colección del usuario. ");
            System.out.println("2) Mostrar la categoría del producto ");
            System.out.println("3) Mostrar los datos del producto");
            System.out.println("4) Mostrar el producto y la categoría de todo el inventario ");
            System.out.println("5) Mostrar el producto y la categoría de todo el inventario, ordenadas ");
            System.out.println("6) Mostrar el producto y la categoría existentes ");
            System.out.println("7) Salir");

            ele = sc.nextInt();
            sc.nextLine();
            if(ele == (1)){
                System.out.println("Escriba la categoria producto que desea agregar a la coleccion: ");
                llave = sc.nextLine();
                boolean elec = mapita.containsKey(llave);
                if(elec){
                    System.out.println("Desea agrergar un producto? ");
                    opcion = sc.next();
                    carrito.get(llave).add(opcion);
                }if(!elec){
                    System.out.println("Producto no existente");
                }
            }
            if(ele == (2)){
                System.out.println("Nombre el producto que desea: ");
                eleccion = sc.nextLine();
                String[] valores = mapita.keySet().toArray(new String[mapita.size()]);
                boolean encontrar = false;
                String opcionSec = null;
                for (Map.Entry<String, ArrayList<String>> entry : mapita.entrySet()){
                    String cate = entry.getKey();
                    List<String> products = entry.getValue();

                    if (products.contains(eleccion)) {
                        encontrar = true;
                        opcionSec = cate;
                        break;
                    }
                }
                if(encontrar){
                    System.out.println("La categoria: "+ opcionSec);
                }
                else {
                    System.out.println("Esta categoria no existe ");
                }

            }
            if(ele == 3){
                for (String llave : carrito.keySet()) {
                    System.out.println(llave + " --> " + carrito.get(llave));
                }
            }
            if(ele == 4){
                String[] valores = carrito.keySet().toArray(new String[carrito.size()]);
                List<String> alfa = Arrays.asList(valores);
                Collections.sort(alfa);
                for (String cate : alfa) {
                    System.out.println(cate + " -- " + carrito.get(cate));
                }
            }
            if(ele == 5){
                profiler();
            }
            if(ele == 6){
                String[] valores = mapita.keySet().toArray(new String[mapita.size()]);
                List<String> alfa = Arrays.asList(valores);
                Collections.sort(alfa);
                for (String cate : alfa) {
                    System.out.println(cate + " -- " + mapita.get(cate));
                }
            }
            if(ele == 7){
                ciclo = false;
            }
        }

    }

    public void preguntar(){
        System.out.println("Escribir la eleccion que desea realizar: hashmap, treemap, linkedhashmap");
        eleccion = sc.next();
        eleccion = eleccion.toLowerCase();
        num = eleccion;
        mapita = MapFactory.createMap(eleccion);
        carrito = MapFactory.createMap(eleccion);
    }

    public void profiler(){
        for (String llave : mapita.keySet()) {
            System.out.println(llave + " : " + mapita.get(llave));
        }
    }

}
