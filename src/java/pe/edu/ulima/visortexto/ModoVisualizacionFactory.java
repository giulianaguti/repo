package pe.edu.ulima.visortexto;

public class ModoVisualizacionFactory {
    
    private static ModoVisualizacionFactory singleton= null;
    public static ModoVisualizacionFactory getInstance(){
        if(singleton==null){
            singleton= new ModoVisualizacionFactory();
            
        }
        return singleton;
    }

    public ModoVisualizadorAdapter obtenerAdapter(String tipo) {
        if (tipo.equals("pdf")) {
            return new PDFAdapter();
        } else if (tipo.equals("html")) {
            return new HTMLAdapter();
        } else {
            return null;
        }
    }
}
