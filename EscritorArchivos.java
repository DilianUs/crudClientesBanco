import java.io.FileWriter;

public class EscritorArchivos {
    public void anadirCliente(String direccionArchivo,Cliente cliente){
        try {
            String filePath = direccionArchivo;
            FileWriter fw = new FileWriter(filePath, true); 
            String lineToAppend = cliente.toString();    
            fw.write(lineToAppend + "\r\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
