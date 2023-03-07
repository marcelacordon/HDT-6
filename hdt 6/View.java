/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/

import java.util.Scanner;

public class View {
    
    Scanner sc = new Scanner(System.in);

    String choice; 

    public void bienvenida(){
        System.out.println("------------- Bienvenidos al menu en linea!------------- \n");
    }

    public String preguntarMap() {
        System.out.println("Que implementación desea? \n 1) HashMap \n 2) TreeMap \n 3) LinkedHashMap");
        return choice = sc.next();
    }

    /**
	 * Muestra todo el inventario
	 */
	public void showInventory() {
		for (String key: products) {
			String[] valueArray = map.get(key);
			String cantidad = valueArray[1];
			String categoria = valueArray[0];	
			
			vista.productInfoFeedback(key, cantidad, categoria);
		}
	}
    
}
