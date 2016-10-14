package pe.edu.ulima.visortexto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GestionRenderizado {
    private static GestionRenderizado singleton = null;
    public static  GestionRenderizado getInstance(){
        if(singleton==null){
            singleton= new GestionRenderizado();
        }
        return singleton;
    }
    
    private GestionRenderizado(){};
    
    public ByteArrayOutputStream renderizar(String titulo, String contenido,String tipo) throws IOException{
       // ModoVisualizacionFactory factory=new ModoVisualizacionFactory();
        ModoVisualizacionFactory factory= new ModoVisualizacionFactory().getInstance();
        ModoVisualizadorAdapter adapter=factory.obtenerAdapter(tipo);
        
        ByteArrayOutputStream baos=adapter.renderizar(titulo, contenido);
        return  baos;
    }
}
