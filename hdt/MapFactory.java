/**
 * @author:Marcela Cordon 
 * 
 * @since:06/03/2023
 **/

 import java.util.Map;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.TreeMap;
 import java.util.LinkedHashMap;
 
 public class MapFactory {
 
     public static Map createMap(String mapType) {
         switch(mapType) {
             case "1":
                 return new HashMap<String, ArrayList<String>>();
             case "2":
                 return new TreeMap<String, ArrayList<String>>();
             case "3":
                 return new LinkedHashMap<String, ArrayList<String>>();
             default:
                 throw new IllegalArgumentException("No es valido");
         }
     }
 }
