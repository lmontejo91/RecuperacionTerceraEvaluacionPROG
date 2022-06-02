/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recuterceraevaluacion_luciamontejo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Bomberos {
    static ArrayList<String[]> datos_Intervenciones=new ArrayList<>();
    static String datos_porLinea[]=new String[11];
    
    //MÉTODO que va a leer los archivos y almacenar los datos necesarios.
    public static void leerArchivos(File ruta){
        File archivos_Bomberos[]=ruta.listFiles();
        
        try{
            for(File aux: archivos_Bomberos){
                Scanner lector=new Scanner(aux).useDelimiter(";|\n");
                for(int i=0; i<11;i++){ //Este FOR es para recorrer la primera línea de cada archivo sin guardarla.
                    lector.next();
                } 
                do{
                    for(int i=0; i<11;i++){
                        datos_porLinea[i]=lector.next();
                        //System.out.println(i+" --> "+datos_porLinea[i]);
                    } 
                    datos_Intervenciones.add(datos_porLinea);
                }while(lector.hasNextLine());
                
                
                lector.close();
            }
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void IntervencionConMasYMenosSalidas(){
        int contador=0;
        Map<String, Integer> map_salidasTotales_porIntervenion = new HashMap<String, Integer>()
        {{
             put("FUEGOS",0);
             put("DAÑOS EN CONSTRUCCION",0);
             put("SALVAMENTOS Y RESCATES",0);
             put("DAÑOS POR AGUA",0);
             put("INCIDENTES DIVERSOS",0);
             put("SALIDAS SIN INTERVENCION",0);
             put("SERVICIOS VARIOS",0);
        }};
        ArrayList<Integer> salidasTotales_porIntervenion=new ArrayList<>();
        //int salidasTotales_porIntervenion[]=new int[7];
        
        for(int i=3; i<10; i++){
            for(String[] elemento : datos_Intervenciones){
               contador+=Integer.parseInt(elemento[i]);
            }
            salidasTotales_porIntervenion.add(contador);
        }
        
        map_salidasTotales_porIntervenion.put("FUEGOS", salidasTotales_porIntervenion.get(0));
        map_salidasTotales_porIntervenion.put("DAÑOS EN CONSTRUCCION", salidasTotales_porIntervenion.get(1));
        map_salidasTotales_porIntervenion.put("SALVAMENTOS Y RESCATES", salidasTotales_porIntervenion.get(2));
        map_salidasTotales_porIntervenion.put("DAÑOS POR AGUA", salidasTotales_porIntervenion.get(3));
        map_salidasTotales_porIntervenion.put("INCIDENTES DIVERSOS", salidasTotales_porIntervenion.get(4));
        map_salidasTotales_porIntervenion.put("SALIDAS SIN INTERVENCION", salidasTotales_porIntervenion.get(5));
        map_salidasTotales_porIntervenion.put("SERVICIOS VARIOS", salidasTotales_porIntervenion.get(6));
        
        System.out.println(map_salidasTotales_porIntervenion);
        
    }
    
    public static void main(String[] args) {
        File directorio_Bomberos = new File("Bomberos");
    
        //System.out.println(directorio_Bomberos.isDirectory());
        //System.out.println(directorio_Bomberos.exists());
        leerArchivos(directorio_Bomberos);
        
    }
    
}
