package ServiciosArchivos;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Author:Dilian Us
 * date:16/01/2023
 * email:dilian0217@gmail.com
 */
public class LectorArchivos {
    public void leerArchivo(String direccionArchivo,ArrayList<String> clientes) {
        try{
            Scanner scanner = new Scanner(Paths.get(direccionArchivo));
            String lineaTexto;
            while(scanner.hasNextLine()){
                lineaTexto = scanner.nextLine();
                clientes.add(lineaTexto);
            } 
       
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            
        }  
    }
}
